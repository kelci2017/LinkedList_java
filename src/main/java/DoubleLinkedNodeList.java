package main.java;

public class DoubleLinkedNodeList<T> {
    private LinkedNode<T> first;
    private LinkedNode<T> last;
    int size;

    //------------------------Add element----------------------
    public boolean add(T e) {
        linkLast(e);
        return true;
    }

    public void add(int index, T element) {

        if (index == size)
            linkLast(element);
        else
            linkBefore(element, getNode(index));
    }

    public void addFirst(T e) {
        linkFirst(e);
    }

    public void addLast(T e) {
        linkLast(e);
    }

    private void linkBefore(T e, LinkedNode<T> succ) {
        final LinkedNode<T> pred = succ.prev;
        final LinkedNode<T> newNode = new LinkedNode<T>(pred, e, succ);
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
    }

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

    private void linkLast(T e) {
        final LinkedNode<T> l = last;
        final LinkedNode<T> newNode = new LinkedNode<T>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    //-------------------------search for some element------------
    public T getElement(int index) {
        checkElementIndex(index);
        return getNode(index).val;
    }


    public int getSize() {
        return size;
    }

    //--------------remove some element-----------------------------
    public boolean remove(T element) {
        for (LinkedNode<T> x = first; x != null; x = x.next) {
            if (element.equals(x.val)) {
                unlink(x);
                return true;
            }
        }
        return false;
    }

    public T remove(int index) {
        checkElementIndex(index);
        return unlink(getNode(index));
    }
    //--------------------get node based on index--------------------------

    private LinkedNode<T> getNode(int index) {
        checkElementIndex(index);
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
    //--------------------remove node based on index--------------------------
    private T unlink(LinkedNode<T> x) {
        final T element = x.val;
        final LinkedNode<T> next = x.next;
        final LinkedNode<T> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.val = null;
        size--;
        return element;
    }

    //---------------check index------------------------
    private void checkElementIndex(int index) {
        if (!(index >= 0 && index < size))
            throw new IndexOutOfBoundsException(index + "is out of bounds");
    }

    //------------------------private LinkedNode class---------------------------
    private static class LinkedNode<T> {
        T val;
        LinkedNode<T> next;
        LinkedNode<T> prev;

        LinkedNode() {
        }

        LinkedNode(T val) {
            this.val = val;
        }

        LinkedNode(LinkedNode<T> pre, T val, LinkedNode<T> next) {
            this.prev = pre;
            this.val = val;
            this.next = next;
        }
    }
}
