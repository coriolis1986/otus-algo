package ru.algo.sort;

import ru.algo.common.CommonSort;

public class BubbleSort implements CommonSort {

    @Override
    public String name() {
        return "Сортировка пузырьком";
    }

    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] > arr[j])
                    swap(arr, i, j);

        return arr;
    }
}
