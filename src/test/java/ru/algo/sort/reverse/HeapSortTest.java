package ru.algo.sort.reverse;

import ru.algo.common.CommonAlgo;
import ru.algo.common.CommonAlgoTest;
import ru.algo.sort.HeapSort;

public class HeapSortTest extends CommonAlgoTest {

    @Override
    protected CommonAlgo init() {
        return new HeapSort();
    }

    @Override
    protected String inPath() {
        return "07_sorting/0.random";
    }
}