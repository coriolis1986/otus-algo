package ru.algo.bits;

import ru.algo.common.CommonAlgo;
import ru.algo.common.CommonAlgoTest;

public class KingTest extends CommonAlgoTest {

    private static final String IN_PATH = "06_bits/01_king";

    @Override
    protected CommonAlgo init() {
        return new King();
    }

    @Override
    protected String inPath() {
        return IN_PATH;
    }
}