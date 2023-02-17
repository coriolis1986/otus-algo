package ru.algo.array;

import lombok.extern.slf4j.Slf4j;
import ru.algo.common.CommonArray;

@SuppressWarnings("unchecked")
@Slf4j
public class FactorArray<T> implements CommonArray<T> {

    public T[] array;

    private static final int FACTOR_SIZE = 5;
    private static final int INITIAL_SIZE = 1;

    private int size = 0;

    public FactorArray() {
        this.array = (T[]) new Object[INITIAL_SIZE];
    }

    @Override
    public void add(T item, int index) {
        resize(index);
        this.array[index] = item;

        size++;
    }

    public void move(int currentIndex, int newIndex) {
        array[newIndex] = array[currentIndex];
    }

    @Override
    public T remove(int index) {
        T obj = get(index);

        array[index] = null;
        size--;

        return obj;
    }

    @Override
    public T get(int index) {
        if (index > size)
            return null;

        return array[index];
    }

    @Override
    public int size() {
        return size;
    }

    private void resize(int index) {
        if (array.length > index)
            return;

        int newSize = array.length;

        while (index >= newSize)
            newSize *= FACTOR_SIZE;

        T[] newArray = (T[]) new Object[newSize + 1];

        System.arraycopy(array, 0, newArray, 0, array.length);

        this.array = newArray;
    }
}
