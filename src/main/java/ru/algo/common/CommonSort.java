package ru.algo.common;

import java.util.Arrays;
import java.util.stream.Collectors;

public interface CommonSort extends CommonAlgo {

    int[] sort(int[] arr);

    default String[] exec(String[] input) {
        final int[] arr = Arrays.stream(input[1].split("\\s+")).mapToInt(Integer::parseInt).toArray();

        return new String[] { Arrays.stream(sort(arr)).mapToObj(Integer::toString).collect(Collectors.joining(" ")) };
    }

    default void swap(int[] arr, int posA, int posB) {
        int temp = arr[posA];
        arr[posA] = arr[posB];
        arr[posB] = temp;
    }

    default void print(int i, int item, int[] arr) {
        if (arr.length > 10)
            return;

        System.out.print(i + " [" + item + "] : ");

        for (int j : arr)
            System.out.print(j + " ");

        System.out.println();
    }
}
