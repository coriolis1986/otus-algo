package ru.algo.sort;

import lombok.SneakyThrows;
import ru.algo.common.CommonExternalSort;
import ru.algo.common.CommonSort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class ExternalTwoFileSort extends CommonExternalSort {

    public static void main(String... args) {
        ExternalTwoFileSort s = new ExternalTwoFileSort();

        s.merge();
    }

    private static final String PART_LEFT = "/opt/sort/part.1";
    private static final String PART_RIGHT = "/opt/sort/part.2";
    private static final String PART_TEMP = "/opt/sort/part.3";

    private static final CommonSort SORTER = new MergeSort();

    @SneakyThrows
    private void merge() {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE_NAME))) {
            while (true) {
                final File part1 = new File(PART_LEFT);
                part1.createNewFile();

                int[] arr;

                try (Writer writer = new FileWriter(part1)) {

                    arr = readAndPepareArray(reader);

                    for (int el : arr)
                        writer.write(el + "\n");

                    writer.flush();
                    mergeParts();
                }

                if (arr.length == 0)
                    break;
            }
        }

        File finalOutputFile = new File(OUTPUT_FILE_NAME);

        new File(PART_RIGHT).renameTo(finalOutputFile);
    }

    @SneakyThrows
    private int[] readAndPepareArray(BufferedReader reader) {
        int[] arr = new int[PART_SIZE];
        int counter = 0;
        boolean eof;

        while (true) {
            String curLine = reader.readLine();

            eof = curLine == null;

            if (!eof)
                arr[counter++] = Integer.parseInt(curLine);

            if (counter == PART_SIZE || eof) {
                if (eof) {
                    int[] newArr = new int[counter];
                    System.arraycopy(arr, 0, newArr, 0, counter);

                    arr = newArr;
                }

                arr = SORTER.sort(arr);

                break;
            }
        }

        return arr;
    }

    @SneakyThrows
    private void mergeParts() {

        File file1 = new File(PART_LEFT);
        File file2 = new File(PART_RIGHT);
        file2.createNewFile();

        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1));
             BufferedReader reader2 = new BufferedReader(new FileReader(file2));
             Writer writer = new FileWriter(PART_TEMP)) {

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

            file1.delete();
            file2.delete();
            new File(PART_TEMP).renameTo(file2);
        }
    }
}
