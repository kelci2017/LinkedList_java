package main.java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingleLinkedListTests {

    private SingleLinkedNodeList<String> setUp() {
        SingleLinkedNodeList<String> list=new SingleLinkedNodeList<String>();
        list.add("Steve");
        list.add("Carl");
        list.add("Raj");
        return list;
    }

    @Test
    public void addLastTest() {
        SingleLinkedNodeList<String> list = setUp();
        int size = list.getSize();
        list.addLast("Kelci");
        assertEquals("Kelci", list.getElement(size), "Kelci should be the last");
    }

    @Test
    public void addFirstTest() {
        SingleLinkedNodeList<String> list = setUp();
        list.addFirst("Kelci");
        assertEquals("Kelci", list.getElement(0), "Kelci should be the first");
    }

    @Test
    public void addInMiddleTest() {
        SingleLinkedNodeList<String> list = setUp();
        list.add(2, "Kelci");
        int size = list.getSize();
        assertEquals("Kelci", list.getElement(2), "Kelci should be the second");
    }

    @Test
    public void searchTest() {
        SingleLinkedNodeList<String> list = setUp();
        list.add(2, "Kelci");
        assertEquals("Raj", list.getElement(3), "Raj should be the second");
    }

    @Test
    public void removeByIndexTest() {
        SingleLinkedNodeList<String> list = setUp();
        list.add("Kelci");
        int size = list.getSize();
        list.remove(size-1);
        assertEquals("Raj", list.getElement(list.getSize()-1), "Raj should be the last one");
    }

    @Test
    public void removeTest() {
        SingleLinkedNodeList<String> list = setUp();
        list.add("Kelci");
        list.remove("Kelci");
        assertEquals(false, list.contain("Kelci"), "Kelci should not in the list");
    }
    @Test
    public void reverseTest() {
        SingleLinkedNodeList<String> list = setUp();
        String first = list.getElement(0);
        int size = list.getSize();
        String last = list.getElement(size-1);
        list.reverse();
        assertEquals(last, list.getElement(0), "Last should be the first");
    }
}
