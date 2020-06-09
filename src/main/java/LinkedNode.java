package main.java;

public class LinkedNode<T> {
    T val;
    LinkedNode<T> next;
    LinkedNode<T> prev;
    LinkedNode() {}

    LinkedNode(T val) {
        this.val = val;
    }
    LinkedNode(T val, LinkedNode next) {
        this.val = val;
        this.next = next;
    }

    LinkedNode(LinkedNode pre, T val, LinkedNode next) {
        this.prev = pre;
        this.val = val;
        this.next = next;
    }
}
