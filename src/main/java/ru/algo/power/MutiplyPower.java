package ru.algo.power;

import ru.algo.common.CommonPower;

import static java.lang.Math.pow;

public class MutiplyPower implements CommonPower {

    @Override
    public String name() {
        return "Возведение в степень через домножение";
    }

    @Override
    public double power(double a, long n) {

        double result = 1;

        long currentPow = n;
        long sumPows = 0;

        while (currentPow > 1) {
            currentPow /= 2;
            sumPows += currentPow;

            result *= pow(a, currentPow);
        }

        if (sumPows < n)
            result *= pow(a, n - sumPows);

        return result;
    }
}
