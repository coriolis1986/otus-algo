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
public class ExternalArraySort extends CommonExternalSort {

    public static void main(String... args) {
        ExternalArraySort s = new ExternalArraySort();

        s.merge();
    }

    private static final CommonSort SORTER = new MergeSort();
    private static final int READ_LIMIT = 100;

    private static final String PART_RIGHT = "/opt/sort/part.2";
    private static final String PART_TEMP = "/opt/sort/part.3";

    @SneakyThrows
    private void merge() {
        int p = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE_NAME))) {

            while (true) {
                int[] arr = readArray(reader);
                p += arr.length;

                mergeParts(arr);

                if (arr.length == 0)
                    break;
            }
        }

        System.out.println(p);
    }

    @SneakyThrows
    private void mergeParts(int[] partLeft) {

        File file2 = new File(PART_RIGHT);
        file2.createNewFile();

        int curLeft = 0;

        try (BufferedReader reader2 = new BufferedReader(new FileReader(file2));
             Writer writer = new FileWriter(PART_TEMP)) {

            Integer curNum1 = curLeft == partLeft.length ? null : partLeft[curLeft++];
            String curLine2 = reader2.readLine();

            while (true) {
                if (curNum1 == null)
                    break;

                if (curLine2 == null)
                    break;

                int curNum2 = Integer.parseInt(curLine2);

                if (curNum1 < curNum2) {
                    writer.write(curNum1 + "\n");

                    curNum1 = curLeft >= partLeft.length ? null : partLeft[curLeft++];

                    if (curNum1 == null)
                        break;
                }

                else {
                    writer.write(curNum2 + "\n");

                    curLine2 = reader2.readLine();

                    if (curLine2 == null)
                        break;
                }
            }

            while (curNum1 != null) {
                writer.write(curNum1 + "\n");
                curNum1 = curLeft >= partLeft.length ? null : partLeft[curLeft++];
            }

            while (curLine2 != null) {
                writer.write(Integer.parseInt(curLine2) + "\n");
                curLine2 = reader2.readLine();
            }

            file2.delete();
            new File(PART_TEMP).renameTo(file2);
        }
    }

    @SneakyThrows
    private int[] readArray(BufferedReader reader) {

        int counter = 0;
        int[] arr = new int[READ_LIMIT];

        while (true) {
            String curLine = reader.readLine();

            boolean eof = curLine == null;

            if (counter < READ_LIMIT && !eof)
                arr[counter++] = Integer.parseInt(curLine);

            else {
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
}
