package ru.algo.sort;

import ru.algo.common.CommonSort;

public class MergeSort implements CommonSort {

    @Override
    public String name() {
        return "Сортировка слиянием";
    }

    @Override
    public int[] sort(int[] arr) {
        return mergesort(arr, 0, arr.length - 1);
    }

    private int[] mergesort(int[] arr, int left, int right) {

        if (left >= right)
            return arr;

        int med = (right + left) / 2;

        mergesort(arr, left, med);
        mergesort(arr, med + 1, right);

        return merge(arr, left, med, right);
    }

    private int[] merge(int[] arr, int left, int med, int right) {

        int p1 = left;
        int p2 = med + 1;
        int ptmp = 0;

        int[] tmp = new int[right - left + 1];

        while (p1 <= med && p2 <= right) {
            if (arr[p1] < arr[p2])
                tmp[ptmp++] = arr[p1++];

            else
                tmp[ptmp++] = arr[p2++];
        }

        while (p1 <= med)
            tmp[ptmp++] = arr[p1++];

        while (p2 <= right)
            tmp[ptmp++] = arr[p2++];

        System.arraycopy(tmp, 0, arr, left, tmp.length);

        return arr;
    }
}
