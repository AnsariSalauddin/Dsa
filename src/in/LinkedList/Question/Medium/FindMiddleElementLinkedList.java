package in.LinkedList.Question;

import in.LinkedList.Question.easy.Node;

public class FindMiddleElementLinkedList {
    public static int middleElementLinkedList(Node node){
        Node slow=node;
        Node fast=node;

        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.data;
    }
    static void main() {
        Node node=new Node(1);
        node.next=new Node(2);
        node.next.next=new Node(3);
        node.next.next.next=new Node(4);
        node.next.next.next.next=new Node(5);
        int i = middleElementLinkedList(node);
        System.out.println(i);

    }
}
