package ru.algo.sort.random;

import ru.algo.common.CommonAlgo;
import ru.algo.common.CommonAlgoTest;
import ru.algo.sort.ShellSort;

public class ShellSort2Test extends CommonAlgoTest {

    @Override
    protected CommonAlgo init() {
        return new ShellSort(new int[] { 70, 45, 23, 16, 8, 4, 2, 1 });
    }

    @Override
    protected String inPath() {
        return "07_sorting/0.random";
    }
}