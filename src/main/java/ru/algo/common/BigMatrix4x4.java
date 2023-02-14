package ru.algo.common;

import lombok.NoArgsConstructor;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

@NoArgsConstructor
public class BigMatrix4x4 {

    /**
     * a11 a12
     * a21 a22
     */

    public BigInteger a11; public BigInteger a12;
    public BigInteger a21; public BigInteger a22;

    public static BigMatrix4x4 SINGLE;

    static {
        SINGLE = new BigMatrix4x4();
        SINGLE.a11 = ONE;
        SINGLE.a12 = ZERO;
        SINGLE.a21 = ZERO;
        SINGLE.a22 = ONE;
    }

    public BigMatrix4x4(BigMatrix4x4 m) {
        this.a11 = m.a11;
        this.a12 = m.a12;
        this.a21 = m.a21;
        this.a22 = m.a22;
    }

    public BigMatrix4x4 multiple(BigMatrix4x4 m2) {
        BigMatrix4x4 res = new BigMatrix4x4();

        res.a11 = this.a11.multiply(m2.a11).add(this.a12.multiply(m2.a21));
        res.a12 = this.a11.multiply(m2.a12).add(this.a12.multiply(m2.a22));
        res.a21 = this.a21.multiply(m2.a11).add(this.a22.multiply(m2.a21));
        res.a22 = this.a21.multiply(m2.a12).add(this.a22.multiply(m2.a22));

        return res;
    }

    public BigMatrix4x4 power(long n) {
        BigMatrix4x4 src = new BigMatrix4x4(this);
        BigMatrix4x4 result = new BigMatrix4x4(this);

        long sumPows = 1;

        while (sumPows << 1 < n) {
            sumPows <<= 1;

            result = result.multiple(result);
        }

        long remainingPows = n - sumPows;

        if (sumPows < n)
            for (int i = 1; i <= remainingPows; i++)
                result = result.multiple(src);

        return result;
    }

    public boolean equals(BigMatrix4x4 m) {
        return  this.a11.equals(m.a11) &&
                this.a21.equals(m.a21) &&
                this.a12.equals(m.a12) &&
                this.a22.equals(m.a22);
    }

    @Override
    public String toString() {
        String res = "";
        res += a11 + " " + a12 + "\n";
        res += a21 + " " + a22 + "\n";
        res += "\n";

        return res;
    }
}
