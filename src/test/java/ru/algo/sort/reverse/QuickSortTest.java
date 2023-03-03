package ru.algo.sort.reverse;

import ru.algo.common.CommonAlgo;
import ru.algo.common.CommonAlgoTest;
import ru.algo.sort.QuickSort;

public class QuickSortTest extends CommonAlgoTest {

    @Override
    protected CommonAlgo init() {
        return new QuickSort();
    }

    @Override
    protected String inPath() {
        return "07_sorting/3.revers";
    }
}