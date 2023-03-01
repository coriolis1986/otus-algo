package ru.algo.power;

import ru.algo.common.CommonPower;

public class IterativePower implements CommonPower {

    @Override
    public String name() {
        return "Возведение в степень (итеративный алгоритм)";
    }

    @Override
    public double power(double a, long n) {

        double result = 1;

        for (int i = 1; i <= n; i++)
            result *= a;

        return result;
    }
}
