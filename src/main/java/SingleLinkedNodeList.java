package main.java;

public class SingleLinkedNodeList<T> {

    private SingleLinkedNode<T> first;
    private int size;

//------------------------Add element----------------------
    public void add(T e) {
        addLast(e);
    }

    public void add(int index, T element) {
        checkElementIndex(index);
        SingleLinkedNode<T> newNode =
                new SingleLinkedNode(element, null);
        if (index == 0) {
            addFirst(element);
            return;
        }
        if (index == size) {
            addLast(element);
            return;
        }
        SingleLinkedNode<T> prev = null;
        SingleLinkedNode<T> curr = first;
        int a = 0;
        while (curr != null) {
            if (index == a) {
                prev.next = newNode;
                newNode.next = curr;
                break;
            }
            prev = curr;
            curr = curr.next;
            a++;
        }
        size++;
    }

    public void addFirst(T e)
    {
        final SingleLinkedNode<T> f = first;
        first = new SingleLinkedNode<T>(e, f);
        size++;
    }

    public void addLast(T e) {
        SingleLinkedNode<T> newNode = new SingleLinkedNode(e, null);
        SingleLinkedNode<T> cur = first;
        if (first == null) {
            first = newNode;
            size++;
            return;
        }
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
        size++;
    }

//-------------------------search for some element------------
    public T getElement(int index)
    {
        checkElementIndex(index);
        SingleLinkedNode<T> x = first;
        for (int i = 0; i < index; i++)
        {
            x = x.next;
        }
        return x.val;
    }

    public int getSize(){
        return size;
    }

    public boolean contain(T o){
        SingleLinkedNode<T> x = first;
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
    public void remove(T o) {
        if (o == first.val) {
            removeFirst();
            return;
        }
        SingleLinkedNode<T> pre = null;
        SingleLinkedNode<T> cur = first;
        while (cur != null) {
            if (o == cur.val) {
                pre.next = cur.next;
                size--;
                return;
            }
            pre = cur;
            cur = cur.next;
        }
    }
    public void removeFirst(){
        first = first.next;
        size--;
    }

    public void remove(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }
        checkElementIndex(index);
        SingleLinkedNode<T> prev = null;
        SingleLinkedNode<T> curr = first;
        int a = 0;
        while (curr != null) {
            if (index == a) {
                prev.next = curr.next;
                break;
            }
            prev = curr;
            curr = curr.next;
            a++;
        }
        size--;
    }

//---------------check index------------------------
    private void checkElementIndex(int index) {
        if (!(index >= 0 && index < size))
            throw new IndexOutOfBoundsException(index + "is out of bounds");
    }

//-------------------Reverse-----------------------------
    public void reverse()
    {
        SingleLinkedNode<T> last = null;
        while(first != null)
        {
            SingleLinkedNode<T> next = first.next;
            first.next = last;
            last = first;
            first = next;
        }
        first = last;
    }

//---------------------SingleLinkedNode class----------------
    private static class SingleLinkedNode<T> {
        T val;
        SingleLinkedNode<T> next;

        SingleLinkedNode() {}
        SingleLinkedNode(T val) {
            this.val = val;
        }
        SingleLinkedNode(T val, SingleLinkedNode<T> next) {
            this.val = val;
            this.next = next;
        }
    }
}