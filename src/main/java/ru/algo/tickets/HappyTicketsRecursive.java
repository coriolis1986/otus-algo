package ru.algo.tickets;

import ru.algo.common.CommonAlgo;

import static java.lang.Integer.parseInt;

public class HappyTicketsRecursive implements CommonAlgo {

    @Override
    public String name() {
        return "Счастливые билеты (рекурсия)";
    }

    @Override
    public String[] exec(String[] input) {
        int n = parseInt(input[0]);

        return new String[] { Integer.toString(findTickets(n)) };
    }

    // ======= Алгоритм =======
    private int findTickets(int n) {
        algo(n, 0, 0);

        return count;
    }

    private int count = 0;

    private void algo(int remainingDigits, int sumA, int sumB) {

        if (remainingDigits == 0) {
            if (sumA == sumB)
                count++;

            return;
        }

        for (int a = 0; a <= 9; a++)
            for (int b = 0; b <= 9; b++)
                algo(remainingDigits - 1, sumA + a, sumB + b);
    }
}
