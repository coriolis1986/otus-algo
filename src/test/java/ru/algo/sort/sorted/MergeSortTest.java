package ru.algo.sort.sorted;

import ru.algo.common.CommonAlgo;
import ru.algo.common.CommonAlgoTest;
import ru.algo.sort.MergeSort;

public class MergeSortTest extends CommonAlgoTest {

    @Override
    protected CommonAlgo init() {
        return new MergeSort();
    }

    @Override
    protected String inPath() {
        return "07_sorting/2.sorted";
    }
}