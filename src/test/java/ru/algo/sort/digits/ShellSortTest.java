package ru.algo.sort.digits;

import ru.algo.common.CommonAlgo;
import ru.algo.common.CommonAlgoTest;
import ru.algo.sort.ShellSort;

public class ShellSortTest extends CommonAlgoTest {

    @Override
    protected CommonAlgo init() {
        return new ShellSort();
    }

    @Override
    protected String inPath() {
        return "07_sorting/1.digits";
    }
}