package ru.algo.array;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import ru.algo.common.CommonArray;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class SpaceArray<T> implements CommonArray<T> {

    // Получается разреженный массив
    // Данные будут храниться в матрице NM,
    //     где M - последнее число индекса - в горизонтальном (вложенном) массиве
    //         N - прочие числа - в вертикальном (основном) массиве

    private final FactorArray<FactorArray<T>> array;

    private final AtomicInteger size = new AtomicInteger(0);

    public SpaceArray() {
        this.array = new FactorArray<>();
    }

    @Override
    public void add(T item, int index) {
        Pair pair = resize(index);

        if (array.get(pair.extPos) == null)
            array.add(new FactorArray<>(), pair.extPos);

        try {
            array.get(pair.extPos).add(item, pair.intPos);
        } catch (Exception ex) {
            System.out.println(pair.extPos + " - " + pair.intPos);
            ex.printStackTrace();
        }

        size.incrementAndGet();
    }

    @Override
    public T remove(int index) {
        T result = get(index);

        Pair pair = new Pair(index);
        array.get(pair.extPos).remove(pair.intPos);

        size.decrementAndGet();

        return result;
    }

    @Override
    public T get(int index) {
        Pair pair = new Pair(index);

        return array.get(pair.extPos).remove(pair.intPos);
    }

    @Override
    public int size() {
        return size.get();
    }

    private Pair resize(int index) {
        Pair pair = new Pair(index);

        if (array.size() == pair.extPos)
            array.add(new FactorArray<>(), pair.extPos);

        return pair;
    }

    @Data
    private static class Pair {
        private int extPos;
        private int intPos;

        public Pair(int index) {
            this.intPos = index % 10;
            this.extPos = index / 10;
        }
    }
}
