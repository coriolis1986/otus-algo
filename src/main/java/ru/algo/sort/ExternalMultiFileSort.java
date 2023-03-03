package ru.algo.sort;

import lombok.SneakyThrows;
import ru.algo.common.CommonExternalSort;
import ru.algo.common.CommonSort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.StringReader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@SuppressWarnings({"ConstantConditions", "ResultOfMethodCallIgnored"})
public class ExternalMultiFileSort extends CommonExternalSort {

    public static void main(String... args) {
        ExternalMultiFileSort s = new ExternalMultiFileSort();

//        s.generate();
        s.split();
        s.merge(0);
    }

    @SneakyThrows
    private void merge(int prevSuffix) {
        AtomicInteger partNum = new AtomicInteger(0);

        Map<File, File> pairs = prepareFilePairs(prevSuffix);

        if (pairs.size() == 1) {
            Map.Entry<File, File> firstEntrySet = pairs.entrySet().iterator().next();

            if (firstEntrySet.getValue() == null) {
                File last = firstEntrySet.getKey();
                File finalOutputFile = new File(OUTPUT_FILE_NAME);

                last.renameTo(finalOutputFile);

                return;
            }
        }

        pairs.forEach((p1, p2) -> mergePair(p1, p2, partNum.incrementAndGet(), prevSuffix + 1));

        merge(prevSuffix + 1);
    }

    @SneakyThrows
    private void mergePair(File file1, File file2, int partNum, int suffix) {

        String newPart = preparePartName(partNum, suffix);

        try (Writer writer = new FileWriter(newPart);
             BufferedReader reader1 = file1 == null ? new BufferedReader(new StringReader("")) : new BufferedReader(new FileReader(file1));
             BufferedReader reader2 = file2 == null ? new BufferedReader(new StringReader("")) : new BufferedReader(new FileReader(file2))) {

            String curLine1 = reader1.readLine();
            String curLine2 = reader2.readLine();

            while (true) {
                if (curLine1 == null)
                    break;

                if (curLine2 == null)
                    break;

                int curNum1 = Integer.parseInt(curLine1);
                int curNum2 = Integer.parseInt(curLine2);

                if (curNum1 < curNum2) {
                    writer.write(curNum1 + "\n");

                    curLine1 = reader1.readLine();

                    if (curLine1 == null)
                        break;
                }

                else {
                    writer.write(curNum2 + "\n");

                    curLine2 = reader2.readLine();

                    if (curLine2 == null)
                        break;
                }
            }

            while (curLine1 != null) {
                writer.write(Integer.parseInt(curLine1) + "\n");
                curLine1 = reader1.readLine();
            }

            while (curLine2 != null) {
                writer.write(Integer.parseInt(curLine2) + "\n");
                curLine2 = reader2.readLine();
            }
        }
    }

    private Map<File, File> prepareFilePairs(int suffix) {
        File[] partFiles = Arrays.stream(new File(PARTS_DIR).listFiles())
                .filter(name -> name.getPath().contains(String.format(".dat.%03d", suffix)))
                .toArray(File[]::new);

        Map<File, File> pairs = new HashMap<>();

        File file1 = null;
        File file2 = null;

        for (File partFile : partFiles) {
            if (file1 == null) {
                file1 = partFile;
                continue;
            }

            file2 = partFile;

            pairs.put(file1, file2);
            file1 = null;
            file2 = null;
        }

        if (file1 != null && file2 == null)
            pairs.put(file1, null);

        return pairs;
    }

    @SneakyThrows
    private void split() {

        CommonSort sorter = new HeapSort();
        AtomicInteger counter = new AtomicInteger(0);
        int partNum = 1;
        int[] partArray;

        while (true) {
            try (Stream<String> stream = Files.lines(Paths.get(INPUT_FILE_NAME))) {

                partArray = stream.skip(counter.get())
                        .mapToInt(Integer::parseInt)
                        .peek(num -> counter.incrementAndGet())
                        .limit(PART_SIZE)
                        .toArray();

                if (partArray.length == 0)
                    break;

                partArray = sorter.sort(partArray);

                writeArrayAsPartFile(partArray, partNum++, 0);
            }
        }
    }

    @SneakyThrows
    private void writeArrayAsPartFile(int[] arr, int partNum, int suffix) {
        final var fileName = preparePartName(partNum, suffix);

        try (FileWriter writer = new FileWriter(fileName)) {
            for (int j : arr)
                writer.write(j + "\n");

            System.out.printf("Writed %s with %d records\n", fileName, arr.length);
        }
    }

    private String preparePartName(int partNum, int suffix) {
        return String.format("/opt/sort/part.%03d.dat.%03d", partNum, suffix);
    }
}
