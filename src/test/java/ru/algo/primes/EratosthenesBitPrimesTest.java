package ru.algo.primes;

import ru.algo.common.CommonAlgo;
import ru.algo.common.CommonAlgoTest;

class EratosthenesBitPrimesTest extends CommonAlgoTest {

    @Override
    protected CommonAlgo init() {
        return new EratosthenesBitPrimes();
    }

    @Override
    protected String inPath() {
        return "05_primes";
    }
}