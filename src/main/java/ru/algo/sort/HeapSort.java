package ru.algo.sort;

import ru.algo.common.CommonSort;

public class HeapSort implements CommonSort {

    @Override
    public String name() {
        return "Сортировка кучей";
    }

    @Override
    public int[] sort(int[] arr) {

        int lastIndex = arr.length - 1;

        int start = parent(lastIndex);

        for (int i = start; i >= 0; i--)
            heapify(arr, i, arr.length - 1);

        for (int j = arr.length - 1; j > 0;) {
            swap(arr, 0, j);
            heapify(arr, 0, --j);
        }

        return arr;
    }

    private void heapify(int[] arr, int root, int border) {

        int left = left(root);
        int right = right(root);

        int max = root;

        if (left <= border && arr[left] > arr[max])
            max = left;

        if (right <= border && arr[right] > arr[max])
            max = right;

        if (max == root)
            return;

        swap(arr, max, root);

        heapify(arr, max, border);
    }

    /*private void heapify(int[] arr, int i) {

        int left = left(i);
        int right = right(i);

        int leftVal = left <= arr.length - 1 ? arr[left] : -1;
        int rightVal = right <= arr.length - 1 ? arr[right] : -1;

        if (leftVal == -1 && rightVal == -1)
            return;

        int curVal = arr[i];

        int chg = -1;

        if (leftVal > -1 && leftVal > curVal)
            chg = left;

        if (rightVal > -1 && rightVal > curVal && rightVal > leftVal)
            chg = right;

        if (chg > -1)
            swap(arr, i, chg);
    }*/

    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    private int left(int pos) {
        return 2 * pos + 1;
    }

    private int right(int pos) {
        return 2 * pos + 2;
    }

    /*
        родитель:       P = (x - 1) / 2
        левый потомок:  L = 2x + 1
        правый потомок: R = 2x + 2
     */
}
