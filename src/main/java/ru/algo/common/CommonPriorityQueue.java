package ru.algo.common;

public interface CommonPriorityQueue<T> {

    void enqueue(int priority, T item);

    T dequeue();
}
