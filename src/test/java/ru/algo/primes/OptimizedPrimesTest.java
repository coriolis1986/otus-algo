package ru.algo.primes;

import ru.algo.common.CommonAlgo;
import ru.algo.common.CommonAlgoTest;

class OptimizedPrimesTest extends CommonAlgoTest {

    @Override
    protected CommonAlgo init() {
        return new OptimizedPrimes();
    }

    @Override
    protected String inPath() {
        return "05_primes";
    }
}