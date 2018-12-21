package queue.impl.node;

public class Node {

    int element;
    Node next;
    Node prev;

    public Node(int element) {
        this.element = element;
        next = null;
        prev = null;
    }

    public void setData(int element) {
        this.element = element;
    }

    public int getData() {
        return element;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getPrev() {
        return prev;
    }
}
