package ru.algo.sort.random;

import ru.algo.common.CommonAlgo;
import ru.algo.common.CommonAlgoTest;
import ru.algo.sort.InsertionShiftSort;

public class InsertionShiftSortTest extends CommonAlgoTest {

    @Override
    protected CommonAlgo init() {
        return new InsertionShiftSort();
    }

    @Override
    protected String inPath() {
        return "07_sorting/0.random";
    }
}