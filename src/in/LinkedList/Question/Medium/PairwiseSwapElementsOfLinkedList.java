package in.LinkedList.Question.Medium;

public class PairwiseSwapElementsOfLinkedList {
    //iterative method
    public static void pairwiseSwapElementOfLinkedList(Node head){
        Node cur=head;
        while (cur!=null && cur.next!=null){
            int temp=cur.data;
            cur.data=cur.next.data;
            cur.next.data=temp;
            cur=cur.next.next;
        }
    }
    // recursive method
    public static Node pairwiseSwapElementOfLinkedListII(Node head){
        if(head==null || head.next==null ){
            return null;
        }
        int temp=head.data;
        head.data=head.next.data;
        head.next.data=temp;
        pairwiseSwapElementOfLinkedList(head.next.next);
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
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        Node node = pairwiseSwapElementOfLinkedListII(head);
        printLinkedList(node);

    }
}
