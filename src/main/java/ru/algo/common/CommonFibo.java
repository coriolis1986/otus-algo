package ru.algo.common;

import java.math.BigInteger;

public interface CommonFibo extends CommonAlgo {

    default String[] exec(String[] input) {
        long n = Long.parseLong(input[0]);

        return new String[] { fibo(n).toString() };
    }

    BigInteger fibo(long n);
}
