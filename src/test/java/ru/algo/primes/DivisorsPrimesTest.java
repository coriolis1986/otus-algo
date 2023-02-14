package ru.algo.primes;

import ru.algo.common.CommonAlgo;
import ru.algo.common.CommonAlgoTest;

class DivisorsPrimesTest extends CommonAlgoTest {

    @Override
    protected CommonAlgo init() {
        return new DivisorsPrimes();
    }

    @Override
    protected String inPath() {
        return "05_primes";
    }
}