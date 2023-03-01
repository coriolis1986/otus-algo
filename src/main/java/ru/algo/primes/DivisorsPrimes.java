package ru.algo.primes;

import ru.algo.common.CommonPrimes;

public class DivisorsPrimes implements CommonPrimes {

    @Override
    public String name() {
        return "Простые числа (перебор делителей)";
    }

    @Override
    public long primes(long n) {

        long count = n >= 2 ? 1 : 0; // 2 не участвует в проверке ниже, поэтому засчитаем его сразу

        for (long i = 1; i <= n; i += 2)
            if (checkIsPrime(i))
                count++;

        return count;
    }

    public boolean checkIsPrime(long num) {
        if (num < 2)
            return false;

        long divisors = 0;

        long checkMax = num / 2;

        for (long i = 1; i <= checkMax; i++) {
            if (num % i == 0)
                divisors++;
        }

        return divisors * 2 == 2;
    }
}
