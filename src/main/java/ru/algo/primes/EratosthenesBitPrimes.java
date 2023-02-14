package ru.algo.primes;

import ru.algo.common.CommonPrimes;

import static java.lang.Long.parseLong;

public class EratosthenesBitPrimes implements CommonPrimes {

    @Override
    public String name() {
        return "Простые числа (решето Эрастофена с битовой матрицей)";
    }

    @Override
    public String[] exec(String[] input) {
        return new String[] { Long.toString(primes(parseLong(input[0]))) };
    }

    @Override
    public long primes(long longN) {

        if (longN == 1)
            return 0;

        int n = (int) longN;

        int[] primes = new int[n / 4 + (n % 4 > 0 ? 1 : 0)];

        long count = 1;

        for (int i = 3; i <= n; i += 2) {
            int arrPosI = i >> 4;
            int valueI = (int) Math.pow(2, i % 16);

            if ((primes[arrPosI] & valueI) > 0)
                continue;

            if (checkIsPrime(i)) {
                count++;

                for (int j = i; j <= n; j += i) {
                    int arrPosJ = j >> 4;
                    int valueJ = (int) Math.pow(2, j % 16);

                    primes[arrPosJ] |= valueJ;
                }
            }
        }

        return count;
    }

    public boolean checkIsPrime(int num) {
        if (num < 2)
            return false;

        long divisors = 0;

        long checkMax = num / 2;

        for (int i = 1; i <= checkMax; i++) {
            if (num % i == 0)
                divisors++;
        }

        return divisors * 2 == 2;
    }
}
