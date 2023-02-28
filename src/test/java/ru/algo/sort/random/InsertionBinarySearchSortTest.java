package ru.algo.sort.random;

import ru.algo.common.CommonAlgo;
import ru.algo.common.CommonAlgoTest;
import ru.algo.sort.InsertionBinarySearchSort;

public class InsertionBinarySearchSortTest extends CommonAlgoTest {

    @Override
    protected CommonAlgo init() {
        return new InsertionBinarySearchSort();
    }

    @Override
    protected String inPath() {
        return "07_sorting/0.random";
    }
}