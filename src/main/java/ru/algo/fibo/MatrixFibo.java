package ru.algo.fibo;

import ru.algo.common.BigMatrix4x4;
import ru.algo.common.CommonFibo;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

public class MatrixFibo implements CommonFibo {

    @Override
    public String name() {
        return "Числа Фибоначчи (через умножение матриц)";
    }

    @Override
    public BigInteger fibo(long n) {

        if (n == 0)
            return ZERO;

        if (n == 1 || n == 2)
            return ONE;

        BigMatrix4x4 m = new BigMatrix4x4();
        m.a11 = ONE; m.a12 = ONE;
        m.a21 = ONE; m.a22 = ZERO;

        m = m.power(n - 1);

        return m.a11;
    }
}
