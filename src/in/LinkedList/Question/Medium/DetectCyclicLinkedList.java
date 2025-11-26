package in.LinkedList.Question;

import in.LinkedList.Question.easy.Node;

public class DetectCyclicLinkedList {
    public static boolean detectCyclicInLinkedList(Node head){
        Node slow=head;
        Node fast=head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
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

    }
}
