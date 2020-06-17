package main.java;

public class MainClass {

    public static void main(String[] args) {

        SingleLinkedNodeList<String> singleLinkedList=new SingleLinkedNodeList<String>();
        singleLinkedList.add("Steve");
        singleLinkedList.add("Carl");
        singleLinkedList.add("Raj");
        singleLinkedList.addFirst("Negan");
        singleLinkedList.add("Rick");
        singleLinkedList.add(2, "Glenn");

        for (int i=0; i<singleLinkedList.getSize();i++){
            System.out.print(singleLinkedList.getElement(i)+"\n");
        }
        System.out.print("================\n");

        singleLinkedList.remove("Negan");
        for (int i=0; i<singleLinkedList.getSize();i++){
            System.out.print(singleLinkedList.getElement(i)+"\n");
        }
        System.out.print("================\n");

        singleLinkedList.remove(1);
        for (int i=0; i<singleLinkedList.getSize();i++){
            System.out.print(singleLinkedList.getElement(i)+"\n");
        }

        DoubleLinkedNodeList<String> doubleLinkedList=new DoubleLinkedNodeList<>();
        doubleLinkedList.add("Steve");
        doubleLinkedList.add("Carl");
        doubleLinkedList.add("Raj");
        doubleLinkedList.reverse();
        for (int i=0; i<doubleLinkedList.getSize();i++){
            System.out.print(doubleLinkedList.getElement(i)+"\n");
        }
    }
}
