package ru.algo.fibo;

import ru.algo.common.CommonAlgo;
import ru.algo.common.CommonAlgoTest;

class GoldFiboTest extends CommonAlgoTest {

    private static final String IN_PATH = "04_fibo";

    @Override
    protected CommonAlgo init() {
        return new GoldFibo();
    }

    @Override
    protected String inPath() {
        return IN_PATH;
    }
}