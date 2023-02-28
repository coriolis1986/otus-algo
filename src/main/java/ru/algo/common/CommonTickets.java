package ru.algo.common;

import static java.lang.Integer.parseInt;

public interface CommonTickets extends CommonAlgo {

    default String[] exec(String[] input) {
        long n = parseInt(input[0]);

        return new String[] { Long.toString(findTickets(n)) };
    }

    long findTickets(long n);
}
