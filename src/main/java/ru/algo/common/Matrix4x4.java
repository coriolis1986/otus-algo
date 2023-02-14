package ru.algo.common;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Matrix4x4 {

    /**
     * a11 a12
     * a21 a22
     */

    public long a11; public long a12;
    public long a21; public long a22;

    public static Matrix4x4 SINGLE;

    static {
        SINGLE = new Matrix4x4();
        SINGLE.a11 = 1;
        SINGLE.a12 = 0;
        SINGLE.a21 = 0;
        SINGLE.a22 = 1;
    }

    public Matrix4x4(Matrix4x4 m) {
        this.a11 = m.a11;
        this.a12 = m.a12;
        this.a21 = m.a21;
        this.a22 = m.a22;
    }

    public Matrix4x4 multiple(Matrix4x4 m2) {
        Matrix4x4 res = new Matrix4x4();

        res.a11 = this.a11 * m2.a11 + this.a12 * m2.a21;
        res.a12 = this.a11 * m2.a12 + this.a12 * m2.a22;
        res.a21 = this.a21 * m2.a11 + this.a22 * m2.a21;
        res.a22 = this.a21 * m2.a12 + this.a22 * m2.a22;

        return res;
    }

    public Matrix4x4 power(long n) {
        Matrix4x4 src = new Matrix4x4(this);
        Matrix4x4 result = new Matrix4x4(this);

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

    public boolean equals(Matrix4x4 m) {
        return  this.a11 == m.a11 &&
                this.a21 == m.a21 &&
                this.a12 == m.a12 &&
                this.a22 == m.a22;
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
