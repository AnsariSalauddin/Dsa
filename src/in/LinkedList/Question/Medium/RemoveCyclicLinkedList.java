package in.LinkedList.Question.Medium;

import in.LinkedList.Question.Medium.Node;

import static in.LinkedList.Question.Medium.DetectCyclicLinkedList.detectCyclicInLinkedList;

public class RemoveCyclicLinkedList {
    public static void removeCyclicLinkedlist(Node head){
        Node slow=head;
        Node fast=head;
        Boolean isCyclic=false;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                isCyclic=true;
                break;
            }
        }
        if(!isCyclic)return;
        slow=head;
        Node prev=null;
        while (slow!=fast){
            slow=slow.next;
            prev=fast;
            fast=fast.next;
        }
        prev.next=null;

    }
    static void main() {
        Node node=new Node(1);
        node.next=new Node(2);
        node.next.next=new Node(3);
        node.next.next.next=new Node(4);
        node.next.next.next.next=new Node(5);
        node.next.next.next.next.next=node.next.next;
        boolean b = detectCyclicInLinkedList(node);
        System.out.println(b);
        removeCyclicLinkedlist(node);
        boolean b1 = detectCyclicInLinkedList(node);
        System.out.println(b1);

    }
}
