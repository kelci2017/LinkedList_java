package main.java;

public class SingleLinkedNodeList<T> {

    SingleLinkedNode<T> first;
    int size;

//------------------------Add element----------------------
    public void add(T e) {
        addLast(e);
    }

    public void add(int index, T element) {
        checkElementIndex(index);
        SingleLinkedNode newNode = new SingleLinkedNode(element,null);
        if (index == 0) {
            addFirst(element);
            return;
        }
        if (index == size) {
            addLast(element);
            return;
        }
        SingleLinkedNode pre = null;
        SingleLinkedNode cur = first;
        int a = 0;
        while (cur != null) {
            if (index == a) {
                pre.next = newNode;
                newNode.next = cur;
                break;
            }
            pre = cur;
            cur = cur.next;
            a++;
        }
        size++;
    }

    public void addFirst(T e)
    {
        final SingleLinkedNode<T> f = first;
        final SingleLinkedNode<T> newNode = new SingleLinkedNode<T>( e, f);
        first = newNode;
        size++;
    }

    public void addLast(T e) {
        SingleLinkedNode newNode = new SingleLinkedNode(e,null);
        SingleLinkedNode cur = first;
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

//--------------remove some element-----------------------------
    public boolean remove(T o) {
        if (o == first.val) {
            removeFirst();
            return true;
        }
        SingleLinkedNode pre = null;
        SingleLinkedNode cur = first;
        while (cur != null) {
            if (o == cur.val) {
                pre.next = cur.next;
                size--;
                return true;
            }
            pre = cur;
            cur = cur.next;
        }
        return false;
    }
    public T removeFirst(){
        T val = first.val;
        first = first.next;
        size--;
        return val;
    }

    public T remove(int index) {
        if (index == 0) return removeFirst();
        checkElementIndex(index);
        SingleLinkedNode pre = null;
        SingleLinkedNode cur = first;
        T val = first.val;
        int a = 0;
        while (cur != null) {
            if (index == a) {
                val = (T) cur.val;
                pre.next = cur.next;
                break;
            }
            pre = cur;
            cur = cur.next;
            a++;
        }
        size--;
        return val;
    }

//---------------check index------------------------
    private void checkElementIndex(int index) {
        if (!(index >= 0 && index < size))
            throw new IndexOutOfBoundsException(index + "is out of bounds");
    }

//------------------------------------------------
    public SingleLinkedNode<T> reverse(){
        SingleLinkedNode<T> last = null;
        while(first != null){
            SingleLinkedNode<T> next = first.next;
            first.next = last;
            last = first;
            first = next;
        }
        first = last;
        return first;
    }

//---------------------SingleLinkedNode class----------------
    private class SingleLinkedNode<T> {
        T val;
        SingleLinkedNode<T> next;

        SingleLinkedNode() {}
        SingleLinkedNode(T val) {
            this.val = val;
        }
        SingleLinkedNode(T val, SingleLinkedNode next) {
            this.val = val;
            this.next = next;
        }
    }
}