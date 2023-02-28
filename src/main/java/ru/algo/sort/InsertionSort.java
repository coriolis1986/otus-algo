package ru.algo.sort;

import ru.algo.common.CommonSort;

public class InsertionSort implements CommonSort {

    @Override
    public String name() {
        return "Сортировка вставками";
    }

    @Override
    public int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++)
            for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--)
                swap(arr, j - 1, j);

        return arr;
    }
}
