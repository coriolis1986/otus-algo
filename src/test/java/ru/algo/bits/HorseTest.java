package ru.algo.bits;

import ru.algo.common.CommonAlgo;
import ru.algo.common.CommonAlgoTest;

public class HorseTest extends CommonAlgoTest {

    private static final String IN_PATH = "06_bits/02_horse";

    @Override
    protected CommonAlgo init() {
        return new Horse();
    }

    @Override
    protected String inPath() {
        return IN_PATH;
    }
}