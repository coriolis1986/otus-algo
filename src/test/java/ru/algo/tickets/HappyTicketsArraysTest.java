package ru.algo.tickets;

import ru.algo.common.CommonAlgo;
import ru.algo.common.CommonAlgoTest;

class HappyTicketsArraysTest extends CommonAlgoTest {

    private static final String IN_PATH = "02_tickets";

    @Override
    protected CommonAlgo init() {
        return new HappyTicketsArrays();
    }

    @Override
    protected String inPath() {
        return IN_PATH;
    }
}