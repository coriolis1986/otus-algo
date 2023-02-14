package ru.algo.primes;

import ru.algo.common.CommonAlgo;
import ru.algo.common.CommonAlgoTest;

class EratosthenesPrimesTest extends CommonAlgoTest {

    @Override
    protected CommonAlgo init() {
        return new EratosthenesPrimes();
    }

    @Override
    protected String inPath() {
        return "05_primes";
    }
}