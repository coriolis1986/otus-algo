package ru.algo.common;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public interface CommonPower extends CommonAlgo {

    default String[] exec(String[] input) {

        DecimalFormat DECIMAL_FORMAT;

        DECIMAL_FORMAT = new DecimalFormat("#.###########");
        DECIMAL_FORMAT.setRoundingMode(RoundingMode.HALF_UP);

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

    double power(double a, long n);
}
