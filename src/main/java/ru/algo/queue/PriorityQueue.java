package ru.algo.queue;

import ru.algo.array.FactorArray;
import ru.algo.common.CommonPriorityQueue;
import ru.algo.common.CommonQueue;

public class PriorityQueue<T> implements CommonPriorityQueue<T> {

    private final FactorArray<CommonQueue<T>> queues = new FactorArray<>();

    @Override
    public void enqueue(int priority, T item) {
        if (queues.get(priority) == null)
            queues.add(new SimpleQueue<T>(), priority);

        queues.get(priority).enqueue(item);
    }

    @Override
    public T dequeue() {
        T result = null;

        for (int priority = queues.size() - 1; priority >= 0; priority--) {
            if (queues.get(priority) != null) {
                result = queues.get(priority).dequeue();

                if (result != null)
                    return result;
            }
        }

        return result;
    }
}
