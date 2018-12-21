package queue.impl.array;

import queue.impl.Queue;

import static java.lang.System.arraycopy;

public class DynamicSizeArrayQueue implements Queue {

    private static final int DEFAULT_SIZE = 16;
    private int numbers[];
    private int index;
    private int size;

    public DynamicSizeArrayQueue() {
        initSize(DEFAULT_SIZE);
    }

    public DynamicSizeArrayQueue(int initialSize) {
        initSize(initialSize);
    }

    private void initSize(int size) {
        this.size = size;
        numbers = new int[size];
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public void add(int number)
    {
        if (index == size) {
            extendArray();
        }
        this.numbers[index] = number;
        this.index++;
    }

    private void extendArray() {
        this.size = this.size * 2;
        int [] newArray = new int[this.size];
        arraycopy(numbers, 0, newArray, 0, numbers.length);
        numbers = newArray;
    }

    public int delete() {
        if (isEmpty())
        {
            throw new IndexOutOfBoundsException("ArrayQueue is empty");
        }

        int number = this.numbers[0];
        shiftArray();
        this.index--;
        return number;
    }

    private void shiftArray() {
        int [] shiftedArray = new int[numbers.length - 1];
        arraycopy(numbers, 1, shiftedArray, 0, numbers.length - 1);
        numbers = shiftedArray;
    }
}