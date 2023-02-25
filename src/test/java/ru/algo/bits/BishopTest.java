package ru.algo.bits;

import ru.algo.common.CommonAlgo;
import ru.algo.common.CommonAlgoTest;

public class BishopTest extends CommonAlgoTest {

    private static final String IN_PATH = "06_bits/04_bishop";

    @Override
    protected CommonAlgo init() {
        return new Bishop();
    }

    @Override
    protected String inPath() {
        return IN_PATH;
    }
}