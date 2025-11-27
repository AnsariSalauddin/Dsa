package in.LinkedList.Question.Medium;

import in.LinkedList.Question.Medium.Node;

public class MergeTwoSortedLinkedList {
    public static Node mergeTwoSortedLinkedList(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        Node dummy = new Node(-1);
        Node tail = dummy;

        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1 != null && temp2 != null) {
            if (temp1.data <= temp2.data) {
                tail.next = temp1;
                temp1 = temp1.next;
            } else {
                tail.next = temp2;
                temp2 = temp2.next;
            }
            tail = tail.next;
        }

        if (temp1 != null) {
            tail.next = temp1;
        } else {
            tail.next = temp2;
        }

        return dummy.next;
    }
    //merge two sorted linkedlist using recursion
    public static Node mergeTwoSortedLinkedListII(Node head1, Node head2){
        if(head1==null || head2==null){
            return head1==null?head2:head1;
        }
        if(head1.data<=head2.data){
            head1.next=mergeTwoSortedLinkedListII(head1.next,head2);
            return head1;
        }else {
            head2.next=mergeTwoSortedLinkedListII(head1,head2.next);
            return head2;
        }

    }


    public static void printLinkedList(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    static void main() {
        Node node = new Node(1);
        node.next = new Node(3);
        node.next.next = new Node(4);

        Node node1 = new Node(2);
        node1.next = new Node(5);
        node1.next.next = new Node(6);
        node1.next.next.next = new Node(7);
        node1.next.next.next.next = new Node(8);
//        Node node2 = mergeTwoSortedLinkedList(node, node1);
//        printLinkedList(node2);
        Node node3 = mergeTwoSortedLinkedListII(node, node1);
        System.out.println(node3.data);
        printLinkedList(node3);



    }
}
