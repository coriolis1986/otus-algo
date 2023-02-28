package ru.algo.fibo;

import ru.algo.common.CommonFibo;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

public class RecursiveFibo implements CommonFibo {

    @Override
    public String name() {
        return "Числа Фибоначчи (рекурсивный)";
    }

    @Override
    public BigInteger fibo(long n) {
        if (n == 0)
            return ZERO;

        if (n == 1 || n == 2)
            return ONE;

        return fibo(n - 2).add(fibo( n - 1));
    }
}
