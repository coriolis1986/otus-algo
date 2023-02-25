package ru.algo.bits;

import ru.algo.common.CommonAlgo;
import ru.algo.common.CommonAlgoTest;

public class QueenTest extends CommonAlgoTest {

    private static final String IN_PATH = "06_bits/05_queen";

    @Override
    protected CommonAlgo init() {
        return new Queen();
    }

    @Override
    protected String inPath() {
        return IN_PATH;
    }
}