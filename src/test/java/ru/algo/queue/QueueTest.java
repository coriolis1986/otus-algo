package ru.algo.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueTest {

    @Test
    void testQueue() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        assertEquals(queue.dequeue(), 1);
        assertEquals(queue.dequeue(), 2);
        assertEquals(queue.dequeue(), 3);
        assertEquals(queue.dequeue(), 4);
        assertEquals(queue.dequeue(), 5);
    }

    @Test
    void testPriorityQueue() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.enqueue(3, 1);
        queue.enqueue(2, 2);
        queue.enqueue(4, 3);
        queue.enqueue(6, 4);
        queue.enqueue(6, 5);
        queue.enqueue(1, 6);
        queue.enqueue(4, 7);
        queue.enqueue(4, 8);

        assertEquals(queue.dequeue(), 4);
        assertEquals(queue.dequeue(), 5);
        assertEquals(queue.dequeue(), 3);
        assertEquals(queue.dequeue(), 7);
        assertEquals(queue.dequeue(), 8);
        assertEquals(queue.dequeue(), 1);
        assertEquals(queue.dequeue(), 2);
        assertEquals(queue.dequeue(), 6);
    }
}
