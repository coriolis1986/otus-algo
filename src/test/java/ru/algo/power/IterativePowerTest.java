package ru.algo.power;

import ru.algo.common.CommonAlgo;
import ru.algo.common.CommonAlgoTest;

public class IterativePowerTest extends CommonAlgoTest {

    private static final String IN_PATH = "03_power";

    @Override
    protected CommonAlgo init() {
        return new IterativePower();
    }

    @Override
    protected String inPath() {
        return IN_PATH;
    }
}