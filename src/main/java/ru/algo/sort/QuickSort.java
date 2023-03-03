package ru.algo.sort;

import ru.algo.common.CommonSort;

import static java.lang.String.format;

public class QuickSort implements CommonSort {

    @Override
    public String name() {
        return "Быстрая сортировка";
    }

    @Override
    public int[] sort(int[] arr) {
        return quicksort(arr, 0, arr.length - 1);
    }

    private int[] quicksort(int[] arr, int left, int right) {

        if (left >= right)
            return arr;

        int medPos = split(arr, left, right);
        quicksort(arr, left, medPos - 1);
        quicksort(arr, medPos, right);

        return arr;
    }

    private int split(int[] arr, int left, int right) {

        int el = arr[right];
        int pos = left - 1;

        for (int i = left; i <= right; i++) {
            if (arr[i] <= el)
                swap(arr, i, ++pos);
        }

        return pos;
    }
}
