package ru.algo.sort.random;

import ru.algo.common.CommonAlgo;
import ru.algo.common.CommonAlgoTest;
import ru.algo.sort.ShellSort;

public class ShellSort3Test extends CommonAlgoTest {

    @Override
    protected CommonAlgo init() {
        return new ShellSort(new int[] { 160, 80, 45, 15, 3, 1 });
    }

    @Override
    protected String inPath() {
        return "07_sorting/0.random";
    }
}