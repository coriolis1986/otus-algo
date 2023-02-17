package ru.algo.queue;

import lombok.Data;
import ru.algo.common.CommonQueue;

public class SimpleQueue<T> implements CommonQueue<T> {

    private Node<T> head;
    private Node<T> current;

    @Override
    public void enqueue(T item) {

        Node<T> node = new Node<T>();
        node.item = item;

        if (current != null)
            current.prev = node;

        current = node;

        if (head == null)
            head = node;
    }

    @Override
    public T dequeue() {
        if (head == null)
            return null;

        T item = head.item;

        head = head.prev;

        return item;
    }

    @Data
    private static class Node<T> {

        private T item;
        private Node<T> prev = null;
    }
}
