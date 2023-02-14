package ru.algo.fibo;

import ru.algo.common.CommonAlgo;
import ru.algo.common.CommonAlgoTest;

public class MatrixFiboTest extends CommonAlgoTest {

    private static final String IN_PATH = "04_fibo";

    @Override
    protected CommonAlgo init() {
        return new MatrixFibo();
    }

    @Override
    protected String inPath() {
        return IN_PATH;
    }
}
