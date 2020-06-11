package main.java;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainClass {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        l1.next = l2;
        while (l2 != null) {
            ListNode a;
            ListNode cur;
            a = new ListNode(l1.next.val, l1.next.next);
            if (l1.val > l2.val) {
                cur = new ListNode(l2.val, l1);
            } else {
                cur = new ListNode(l1.val, l1.next);
                l1.next.next = a;
            }

            l2 = l2.next;
        }
        return l1;

    }

//    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode head = new ListNode(0);
//        ListNode cur = head;
//        while (l1 != null && l2 != null) {
//            if (l1.val<l2.val) {
//                cur.next = l1;
//                l1 = l1.next;
//            } else {
//                cur.next = l2;
//                l2 = l2.next;
//            }
//            cur = cur.next;
//        }
//        if (l1!=null) {
//            cur.next=l1;
//        }
//        if (l2!=null) {
//            cur.next=l2;
//        }
//        if (head != null) {
//            head = head.next;
//        }
//        return head;
//    }

    public static void main(String[] args) {
        String[] names = new String[6];
        names[0]="Alex";
        names[1]="Bob";
        names[2]="Cindy";
        names[3]="Danny";
        names[4]="Emily";
        //move all elements one behind
        names[5]="Emily";
        names[4]="Danny";
        names[3]="Cindy";
        names[2]="Bob";
        names[1]="Alex";
        names[0]="Kelci";


//        ArrayList a = new ArrayList<String>();
//        a.add("string");
//        ListNode c = new ListNode(4);
//        ListNode b = new ListNode(3,c);
//        ListNode l1 = new ListNode(1,b);
//
//        ListNode e = new ListNode(4);
//        ListNode d = new ListNode(2,e);
//        ListNode l2 = new ListNode(1,d);
//
//        //System.out.print("the output is: "+ mergeTwoLists(l1,l2).val);
//
//        LinkedList<String> linkedList = new LinkedList<String>();
//        linkedList.add("Steve");
//        linkedList.add("Carl");
//        linkedList.add("Raj");

        SingleLinkedNodeList<String> list=new SingleLinkedNodeList<String>();
        list.add("Steve");
        list.add("Carl");
        list.add("Raj");

        list.addFirst("Negan");
        list.add("Rick");

        list.add(2, "Glenn");

        for (int i=0; i<list.getSize();i++){
            System.out.print(list.getElement(i)+"\n");
        }
        System.out.print("Size of the list is: " + list.getSize() +"\n");
        System.out.print("================\n");

        list.remove("Negan");
        for (int i=0; i<list.getSize();i++){
            System.out.print(list.getElement(i)+"\n");
        }
        System.out.print("Size of the list is: " + list.getSize() +"\n");
        System.out.print("================\n");

        list.remove(1);
        for (int i=0; i<list.getSize();i++){
            System.out.print(list.getElement(i)+"\n");
        }
        System.out.print("Size of the list is: " + list.getSize() +"\n");
        list.reverse();
        for (int i=0; i<list.getSize();i++){
            System.out.print(list.getElement(i)+"\n");
        }
        System.out.print("Size of the list is: " + list.getSize() +"\n");
    }
}
