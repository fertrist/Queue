package queue.impl.node;

import queue.impl.Queue;

import java.util.NoSuchElementException;

public class NodeQueue implements Queue {

    public Node front;
    public Node rear;
    int size;

    public NodeQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    /**
     * Remove from a front.
     */
    public int delete() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int element = front.getData();
        front = front.getNext();
        front.setPrev(null);
        size--;
        return element;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return rear == null;
    }

    /**
     * Add to a rear.
     */
    public void add(int element) {
        if (rear == null) {
            addFirst(element);
            return;
        }
        else {
            addElement(element);
        }
        size++;
    }

    private void addFirst(int element) {
        rear = new Node(element);
        front = rear;
    }

    private void addElement(int element) {
        Node oldRear = rear;
        rear = new Node(element);
        oldRear.setNext(rear);
        rear.setPrev(oldRear);
    }
}
