package in.LinkedList.Question.easy;

public class RemoveDuplicatesFromSortedLinkedList {
    public static Node removeDuplicatesFromSortedLinkedList(Node head){
        Node temp=head;
        while (temp!=null && temp.next!=null){
            Node cur=temp.next;
            while (cur!=null && cur.data==temp.data){
                cur=cur.next;
            }
            temp.next=cur;
            temp=temp.next;
        }
        return head;
    }
    public static Node removeDuplicatesFromSortedLinkedListII(Node head){
        Node temp=head;
        while (temp!=null && temp.next!=null){
            if(temp.data==temp.next.data){
                Node next=temp.next.next;
                temp=next;
            }else {
                temp=temp.next;
            }
        }
        return head;
    }
    public static void printLinkedList(Node head){
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    static void main() {
        Node head = new Node(11);
        head.next = new Node(11);
        head.next.next = new Node(11);
        head.next.next.next = new Node(11);
        head.next.next.next.next = new Node(11);
        printLinkedList(head);
        Node head1 = removeDuplicatesFromSortedLinkedList(head);
        printLinkedList(head1);

        Node head2 = removeDuplicatesFromSortedLinkedListII(head);
        printLinkedList(head2);
    }
}
