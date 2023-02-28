package ru.algo.common;

import static java.lang.Long.parseLong;

public interface CommonPrimes extends CommonAlgo {

    long primes(long n);

    default String[] exec(String[] input) {
        return new String[] { Long.toString(primes(parseLong(input[0]))) };
    }
}
