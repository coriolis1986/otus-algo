package ru.algo.tickets;

import ru.algo.common.CommonTickets;

public class HappyTicketsRecursive implements CommonTickets {

    @Override
    public String name() {
        return "Счастливые билеты (рекурсия)";
    }

    public long findTickets(long n) {
        algo(n, 0, 0);

        return count;
    }

    private long count = 0;

    private void algo(long remainingDigits, long sumA, long sumB) {

        if (remainingDigits == 0) {
            if (sumA == sumB)
                count++;

            return;
        }

        for (long a = 0; a <= 9; a++)
            for (long b = 0; b <= 9; b++)
                algo(remainingDigits - 1, sumA + a, sumB + b);
    }
}
