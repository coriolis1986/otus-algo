package ru.algo.sort.reverse;

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
        return "07_sorting/3.revers";
    }
}