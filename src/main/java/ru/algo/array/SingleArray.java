package ru.algo.array;

import ru.algo.common.CommonArray;

@SuppressWarnings("unchecked")
public class SingleArray<T> implements CommonArray<T> {

    private T[] array;
    private int size = 0;

    public SingleArray() {
        this.array = (T[]) new Object[0];
    }

    @Override
    public void add(T item, int index) {
        resize(index);

        this.array[index] = item;

        size++;
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
        return array[index];
    }

    @Override
    public int size() {
        return size;
    }

    private void resize(int maxSize) {
        if (array.length >= maxSize + 1)
            return;

        T[] newArray = (T[]) new Object[maxSize + 1];

        System.arraycopy(array, 0, newArray, 0, array.length);

        this.array = newArray;
    }
}
