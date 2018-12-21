package queue.impl.array;

import queue.impl.Queue;

public class FixedSizeArrayQueue implements Queue {

    public static final int DEFAULT_SIZE = 100000000;

    private int numbers[];

    private int index;

    public FixedSizeArrayQueue() {
        numbers = new int[DEFAULT_SIZE];
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public void add(int number) {
        if (index == DEFAULT_SIZE - 1) {
            throw new IndexOutOfBoundsException("ArrayQueue is full. Remove some elements");
        }
        this.numbers[index] = number;
        this.index++;
    }

    public int delete() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("ArrayQueue is empty");
        }

        int number = this.numbers[0];

        for (int i = 0; i < this.index - 1; i++) {
            numbers[i] = numbers[i + 1];
        }
        this.index--;
        return number;
    }
}