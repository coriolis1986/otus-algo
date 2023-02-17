package ru.algo.common;

public interface CommonArray<T> {

    void add(T item, int index);

    T remove(int index);

    T get(int index);

    int size();
}
