package ru.algo.power;

import ru.algo.common.CommonPower;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class IterativePower implements CommonPower {

    private static final DecimalFormat DECIMAL_FORMAT;

    static {
        DECIMAL_FORMAT = new DecimalFormat("#.###########");
        DECIMAL_FORMAT.setRoundingMode(RoundingMode.HALF_UP);
    }

    @Override
    public String name() {
        return "Возведение в степень (итеративный алгоритм)";
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

        for (int i = 1; i <= n; i++)
            result *= a;

        return result;
    }
}
