package in.LinkedList.Question.easy;

public class MiddleOfLinkedList {
    public static int middleElementOfLinkedList(Node head){
        Node slow=head;
        Node fast=head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.data;
    }
    static void main() {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);
        System.out.println(middleElementOfLinkedList(head));
    }
}
