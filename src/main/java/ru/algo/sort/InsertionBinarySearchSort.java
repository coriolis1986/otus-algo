package ru.algo.sort;

import ru.algo.common.CommonSort;

public class InsertionBinarySearchSort implements CommonSort {

    @Override
    public String name() {
        return "Сортировка вставками";
    }

    @Override
    public int[] sort(int[] arr) {
        int j;

        for (int i = 0; i < arr.length; i++) {
            int item = arr[i];

            int pos = binarySearch(arr, item, 0, i - 1);

            for (j = i - 1; j >= pos; j--)
                arr[j + 1] = arr[j];

            arr[j + 1] = item;
        }

        return arr;
    }

    private int binarySearch(int[] arr, int item, int low, int high) {
        if (high <= low) {
            if (item >= arr[low])
                return low + 1;

            else
                return low;
        }

        int mid = (low + high) / 2;

        if (item >= arr[mid])
            return binarySearch(arr, item, mid + 1, high);

        else
            return binarySearch(arr, item, low, mid - 1);
    }
}
