package ru.algo.array;

import lombok.extern.slf4j.Slf4j;
import ru.algo.common.CommonArray;

@SuppressWarnings("unchecked")
@Slf4j
public class VectorArray<T> implements CommonArray<T> {

    private T[] array;

    private static final int VECTOR_SIZE = 5;

    private int size = 0;

    public VectorArray() {
        this.array = (T[]) new Object[VECTOR_SIZE];
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

    private void resize(int index) {
        if (array.length - 1 >= index)
            return;

        int newSize = array.length + (index / 5) * VECTOR_SIZE;

        T[] newArray = (T[]) new Object[newSize + 1];

        System.arraycopy(array, 0, newArray, 0, array.length);

        this.array = newArray;
    }
}
