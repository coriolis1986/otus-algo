package ru.algo.primes;

import ru.algo.common.CommonPrimes;

public class EratosthenesPrimes implements CommonPrimes {

    @Override
    public String name() {
        return "Простые числа (решето Эрастофена)";
    }

    @Override
    public long primes(long longN) {

        if (longN == 1)
            return 0;

        int n = (int) longN;

        boolean[] primes = new boolean[n];

        long count = 1;

        for (int i = 3; i <= n; i += 2) {
            if (primes[i - 1])
                continue;

            if (checkIsPrime(i)) {
                count++;

                for (int j = i; j <= n; j += i)
                    primes[j - 1] = true;
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
