package ru.algo.bits;

import ru.algo.common.CommonAlgo;
import ru.algo.common.CommonAlgoTest;

public class RookTest extends CommonAlgoTest {

    private static final String IN_PATH = "06_bits/03_rook";

    @Override
    protected CommonAlgo init() {
        return new Rook();
    }

    @Override
    protected String inPath() {
        return IN_PATH;
    }
}