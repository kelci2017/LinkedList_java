package main.java;

public class LinkedNodeList<T> {
    LinkedNode<T> first;
    LinkedNode<T> last;
    int size;

    private void linkFirst(T e) {
        final LinkedNode<T> f = first;
        final LinkedNode<T> newNode = new LinkedNode<T>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }
    void linkLast(T e) {
        final LinkedNode<T> l = last;
        final LinkedNode<T> newNode = new LinkedNode<T>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    void linkBefore(T e, LinkedNode<T> succ) {
        // assert succ != null;
        final LinkedNode<T> pred = succ.prev;
        final LinkedNode<T> newNode = new LinkedNode<T>(pred, e, succ);
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
    }

    public boolean add(T e) {
        linkLast(e);
        return true;
    }

    public void add(int index, T element) {

        if (index == size)
            linkLast(element);
        else
            linkBefore(element, node(index));
    }

    LinkedNode<T> node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            LinkedNode<T> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            LinkedNode<T> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
//    public void add(T node) {
//        LinkedNode a = new LinkedNode<T>(node);
//        a.next = next;
//        next = a;
//    }
//
//    public void addFirst(T node) {
//        LinkedNode a = new LinkedNode<T>(node);
//        a.next = this;
//    }
//
//    public void addLast(T node) {
//        LinkedNode a = new LinkedNode<T>(node);
//        next = a;
//    }
//
//    public void add(T node, int index) {
//        LinkedNode a = new LinkedNode<T>(node);
//        a.next = next;
//        next = a;
//    }
}
