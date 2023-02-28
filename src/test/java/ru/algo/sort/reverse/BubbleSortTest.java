package ru.algo.sort.reverse;

import ru.algo.common.CommonAlgo;
import ru.algo.common.CommonAlgoTest;
import ru.algo.sort.BubbleSort;

public class BubbleSortTest extends CommonAlgoTest {

    @Override
    protected CommonAlgo init() {
        return new BubbleSort();
    }

    @Override
    protected String inPath() {
        return "07_sorting/3.revers";
    }
}