package ru.algo.power;

import ru.algo.common.CommonAlgo;
import ru.algo.common.CommonAlgoTest;

public class MutiplyPowerTest extends CommonAlgoTest {

    private static final String IN_PATH = "03_power";

    @Override
    protected CommonAlgo init() {
        return new MutiplyPower();
    }

    @Override
    protected String inPath() {
        return IN_PATH;
    }
}