package ru.algo.sort;

import ru.algo.common.CommonSort;

public class InsertionShiftSort implements CommonSort {

    @Override
    public String name() {
        return "Сортировка вставками";
    }

    @Override
    public int[] sort(int[] arr) {
        int j;

        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];

            for (j = i - 1; j >= 0 && arr[j] > temp; j--)
                arr[j + 1] = arr[j];

            arr[j + 1] = temp;
        }

        return arr;
    }
}
