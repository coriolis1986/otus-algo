package ru.algo.array;

import org.junit.jupiter.api.Test;
import ru.algo.common.CommonArray;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class ArraysTest {

    private static final int[] REPEATS = new int[] {
            10000,
            50000,
            100000,
            500000,
            1000000,
            5000000,
            10000000,
    };

    List<CommonArray<Integer>> arraysList = new LinkedList<>() {{
        add(new SingleArray<>());
        add(new VectorArray<>());
        add(new FactorArray<>());
        add(new SpaceArray<>());
        add(new MatrixArray<>());
    }};

    @Test
    public void testArrays() {

        for (CommonArray<Integer> array : arraysList) {
            for (int repeats : REPEATS)
                doTest(array, repeats);

            System.out.println();
        }
    }

    private void doTest(CommonArray<Integer> array, int repeats) {
        testArrayAddings(array, repeats);
        testArrayReadings(array, repeats);
        testArrayRemovings(array, repeats);

        System.out.println();
    }

    private void testArrayRemovings(CommonArray<Integer> array, int repeats) {
        if (repeats >= 100000 &&
                (array instanceof MatrixArray<Integer> || array instanceof SingleArray<Integer>)) {
            System.out.printf("[%s] %d removings: too slow %n", array.getClass().getSimpleName(), repeats);
            return;
        }

        long msec = Calendar.getInstance().getTimeInMillis();
        int size = array.size();

        for (int i = 0; i < size; i++)
            array.remove(i);

        msec = Calendar.getInstance().getTimeInMillis() - msec;

        System.out.printf("[%s] %d removings: [%d] msec %n", array.getClass().getSimpleName(), size, msec);
    }

    private void testArrayReadings(CommonArray<Integer> array, int repeats) {
        if (repeats > 100000 && array instanceof SingleArray) {
            System.out.printf("[%s] %d readings: too slow %n", array.getClass().getSimpleName(), repeats);
            return;
        }

        long msec = Calendar.getInstance().getTimeInMillis();

        for (int i = 1; i <= repeats; i++)
            array.get(i);

        msec = Calendar.getInstance().getTimeInMillis() - msec;

        System.out.printf("[%s] %d readings: [%d] msec %n", array.getClass().getSimpleName(), repeats, msec);
    }

    private void testArrayAddings(CommonArray<Integer> array, int repeats) {
        if (repeats > 100000 && array instanceof SingleArray) {
            System.out.printf("[%s] %d addings: too slow %n", array.getClass().getSimpleName(), repeats);
            return;
        }

        long msec = Calendar.getInstance().getTimeInMillis();

        for (int i = 1; i <= repeats; i++)
            array.add(i, i);

        msec = Calendar.getInstance().getTimeInMillis() - msec;

        System.out.printf("[%s] %d addings: [%d] msec %n", array.getClass().getSimpleName(), repeats, msec);
    }
}
