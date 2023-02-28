package ru.algo.fibo;

import ru.algo.common.CommonFibo;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

public class IterativeFibo implements CommonFibo {

    @Override
    public String name() {
        return "Числа Фибоначчи (итеративный)";
    }

    @Override
    public BigInteger fibo(long n) {

        if (n == 0)
            return ZERO;

        if (n == 1 || n == 2)
            return ONE;

        BigInteger numPrevPrev = ONE;
        BigInteger numPrev = ONE;
        BigInteger num = ZERO;

        for (long i = 3; i <= n; i++) {
            num = numPrevPrev.add(numPrev);

            numPrevPrev = numPrev;
            numPrev = num;
        }

        return num;
    }
}
