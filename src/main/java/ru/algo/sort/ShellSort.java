package ru.algo.sort;

import ru.algo.common.CommonSort;

public class ShellSort implements CommonSort {

    private static final int[] DEFAULT_STEP_SIZES = { 8, 4, 2, 1 };

    private final int[] stepSizes;

    public ShellSort() {
        this.stepSizes = DEFAULT_STEP_SIZES;
    }

    public ShellSort(int[] stepSizes) {
        this.stepSizes = stepSizes;
    }

    @Override
    public String name() {
        return "Сортировка Шелла";
    }

    @Override
    public int[] sort(int[] arr) {

        for (int step : stepSizes)
            for (int i = 0; i < arr.length; i += step)
                for (int j = i; j > 0 && arr[j - step] > arr[j]; j -= step)
                    swap(arr, j - 1, j);

        return arr;
    }
}
