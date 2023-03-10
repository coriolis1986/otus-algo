package ru.algo.tickets;

import ru.algo.common.CommonTickets;

import java.util.Arrays;

public class HappyTicketsArrays implements CommonTickets {

    @Override
    public String name() {
        return "Счастливые билеты (с массивами)";
    }

    public long findTickets(long n) {
        long[] arr = new long[10];
        Arrays.fill(arr, 1);

        long[] values = asd(n, arr);

        return countTickets(values);
    }

    private long[] asd(long n, long[] prevArr) {
        if (--n == 0)
            return prevArr;

        int len = prevArr.length + 9;
        long[] arr = new long[len];

        for (int i = 0; i < arr.length; i++) {
            long sum = 0;

            int jmin = Math.max(i - 9, 0);

            for (int j = i; j >= jmin; j--) {
                if (j >= prevArr.length)
                    continue;

                sum += prevArr[j];
            }

            arr[i] = sum;
        }

        return asd(n, arr);
    }

    private long countTickets(long[] arr) {
        long count = 0;

        for (long j : arr)
            count += j * j;

        return count;
    }
}
