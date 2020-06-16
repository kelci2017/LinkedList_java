package main.java;

public class MainClass {

    public static void main(String[] args) {

//        SingleLinkedNodeList<String> list=new SingleLinkedNodeList<String>();
//        list.add("Steve");
//        list.add("Carl");
//        list.add("Raj");
//        list.addFirst("Negan");
//        list.add("Rick");
//        list.add(2, "Glenn");
//
//        for (int i=0; i<list.getSize();i++){
//            System.out.print(list.getElement(i)+"\n");
//        }
//        System.out.print("Size of the list is: " + list.getSize() +"\n");
//        System.out.print("================\n");
//
//        list.remove("Negan");
//        for (int i=0; i<list.getSize();i++){
//            System.out.print(list.getElement(i)+"\n");
//        }
//        System.out.print("Size of the list is: " + list.getSize() +"\n");
//        System.out.print("================\n");
//
//        list.remove(1);
//        for (int i=0; i<list.getSize();i++){
//            System.out.print(list.getElement(i)+"\n");
//        }
//        System.out.print("Size of the list is: " + list.getSize() +"\n");
        DoubleLinkedNodeList<String> list=new DoubleLinkedNodeList<>();
        list.add("Steve");
        list.add("Carl");
        list.add("Raj");
        list.reverse();
        for (int i=0; i<list.getSize();i++){
            System.out.print(list.getElement(i)+"\n");
        }
    }
}
