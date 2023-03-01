package ru.algo.sort;

import ru.algo.common.CommonSort;

public class SelectionSort implements CommonSort {

    @Override
    public String name() {
        return "Сортировка вставками";
    }

    @Override
    public int[] sort(int[] arr) {

        for (int i = arr.length - 1; i > 0 ; i--) {
            int posMax = 0;

            for (int j = 1; j <= i; j++)
                if (arr[posMax] < arr[j])
                    posMax = j;

            swap(arr, posMax, i);
        }

        return arr;
    }
}
