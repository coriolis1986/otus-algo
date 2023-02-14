package ru.algo.fibo;

import ru.algo.common.CommonFibo;

import java.math.BigInteger;

import static java.lang.Math.sqrt;

public class GoldFibo implements CommonFibo {
    @Override
    public String name() {
        return "Числа Фибоначчи (золотое сечение)";
    }

    @Override
    public String[] exec(String[] input) {
        long n = Long.parseLong(input[0]);

        return new String[] { fibo(n).toString() };
    }

    @Override
    public BigInteger fibo(long n) {

        double sqrt5 = sqrt(5);
        double phi = (1 + sqrt5) / 2;
        double num = (Math.pow(phi, n) / sqrt5) + 0.5;

        return BigInteger.valueOf((long) Math.abs(num));
    }
}
