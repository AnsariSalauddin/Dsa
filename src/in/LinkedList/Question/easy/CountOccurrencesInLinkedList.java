package in.LinkedList.Question.easy;

public class CountOccurrencesInLinkedList {
    //using iterative
    public static int countOccurrenceInLinkedList(Node head,int k){
        Node temp=head;
        int count=0;

        while (temp!=null){
            if(temp.data==k){
                count++;
            }
            temp=temp.next;
        }
        return count;
    }

    //using recursive
    public static int countOccurrenceInLinkedListII(Node head,int k){
        if(head==null){
            return 0;
        }
        int i = countOccurrenceInLinkedListII(head.next, k);
        if(head.data==k){
            i++;
        }
        return i;
    }
    static void main() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        System.out.println(countOccurrenceInLinkedList(head,1));
        System.out.println(countOccurrenceInLinkedListII(head,1));

    }
}
