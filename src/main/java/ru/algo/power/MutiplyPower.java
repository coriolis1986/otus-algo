package ru.algo.power;

import ru.algo.common.CommonPower;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import static java.lang.Math.pow;

public class MutiplyPower implements CommonPower {

    private static final DecimalFormat DECIMAL_FORMAT;

    static {
        DECIMAL_FORMAT = new DecimalFormat("#.###########");
        DECIMAL_FORMAT.setRoundingMode(RoundingMode.HALF_UP);
    }

    @Override
    public String name() {
        return "Возведение в степень через домножение";
    }

    @Override
    public String[] exec(String[] input) {
        double a = Double.parseDouble(input[0]);
        long n = Long.parseLong(input[1]);

        double result = power(a, n);

        String str;

        if (result == (long) result)
            str = ((long) result) + ".0";

        else
            str = DECIMAL_FORMAT.format(result).replace(",", ".");

        return new String[] { str };
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
