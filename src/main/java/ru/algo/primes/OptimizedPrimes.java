package ru.algo.primes;

import ru.algo.common.CommonPrimes;

import static java.lang.Long.parseLong;

public class OptimizedPrimes implements CommonPrimes {

    @Override
    public String name() {
        return "Простые числа (оптимизация поиска)";
    }

    @Override
    public String[] exec(String[] input) {
        return new String[] { Long.toString(primes(parseLong(input[0]))) };
    }

    private long count = 0;

    @Override
    public long primes(long n) {

        count = n >= 2 ? 1 : 0; // 2 не участвует в проверке ниже, поэтому засчитаем его сразу

        long[] primes = new long[(int) (n / 2) + 1];

        for (long i = 3; i <= n; i += 2)
            if (checkIsPrime(i, primes))
                count++;

        return count;
    }

    public boolean checkIsPrime(long num, long[] primes) {
        if (num < 2)
            return false;

        boolean isPrime;
        isPrime = checkAccumulated(num, primes);

        if (!isPrime)
            isPrime = checkDivisors(num);

        if (isPrime)
            primes[(int) count] = num;

        return isPrime;
    }

    private boolean checkAccumulated(long num, long[] primes) {
        for (long prime : primes) {
            if (prime == 0)
                return false;

            if (num % prime == 0)
                return true;
        }

        return false;
    }

    private boolean checkDivisors(long num) {
        long divisors = 0;

        for (long i = 1; i <= num / 2; i++) {
            if (num % i == 0)
                divisors++;

            if (divisors > 2)
                break;
        }

        return divisors * 2 == 2;
    }
}
