package main.java;

public class DoubleLinkedNodeList<T> {
    private DoubleLinkedNode<T> first;
    private DoubleLinkedNode<T> last;
    int size;

    //------------------------Add element----------------------
    public boolean add(T e) {
        addLast(e);
        return true;
    }

    public void add(int index, T element) {

        if (index == size)
            addLast(element);
        else
            linkBefore(element, getNode(index));
    }

    public void addFirst(T e) {
        final DoubleLinkedNode<T> f = first;
        final DoubleLinkedNode<T> newNode = new DoubleLinkedNode<T>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }

    public void addLast(T e) {
        final DoubleLinkedNode<T> l = last;
        final DoubleLinkedNode<T> newNode = new DoubleLinkedNode<T>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    private void linkBefore(T e, DoubleLinkedNode<T> succ) {
        final DoubleLinkedNode<T> pred = succ.prev;
        final DoubleLinkedNode<T> newNode = new DoubleLinkedNode<T>(pred, e, succ);
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
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

    public boolean contain(T o){
        DoubleLinkedNode<T> x = first;
        for (int i = 0; i < size; i++)
        {
            if (x.val == o) {
                return true;
            }
            x = x.next;
        }
        return false;
    }
    //--------------remove some element-----------------------------
    public boolean remove(T element) {
        for (DoubleLinkedNode<T> x = first; x != null; x = x.next) {
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

    private T unlink(DoubleLinkedNode<T> x) {
        final T element = x.val;
        final DoubleLinkedNode<T> next = x.next;
        final DoubleLinkedNode<T> prev = x.prev;

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
    //--------------------get node based on index--------------------------

    private DoubleLinkedNode<T> getNode(int index) {
        checkElementIndex(index);
        if (index < (size >> 1)) {
            DoubleLinkedNode<T> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            DoubleLinkedNode<T> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    //---------------check index------------------------
    private void checkElementIndex(int index) {
        if (!(index >= 0 && index < size))
            throw new IndexOutOfBoundsException(index + "is out of bounds");
    }

    //-------------------Reverse-----------------------------
    public void reverse() {
        DoubleLinkedNode<T> temp = null;
        DoubleLinkedNode<T> curr = first;
        while(curr != null)
        {
            temp = curr.next;
            curr.next = curr.prev;
            curr.prev = temp;
            curr = temp;
        }
        temp = first;
        first = last;
        last = temp;
    }
    //------------------------private LinkedNode class---------------------------
    private static class DoubleLinkedNode<T> {
        T val;
        DoubleLinkedNode<T> next;
        DoubleLinkedNode<T> prev;

        DoubleLinkedNode() {
        }

        DoubleLinkedNode(T val) {
            this.val = val;
        }

        DoubleLinkedNode(DoubleLinkedNode<T> pre, T val, DoubleLinkedNode<T> next) {
            this.prev = pre;
            this.val = val;
            this.next = next;
        }
    }
}
