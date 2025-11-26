package in.LinkedList.Question.easy;



public class GetNthNodeLinkedList {
    //iterative method
    public static int getNthNodeFromLinkedList(Node head, int k){
        int count=1;
        Node temp=head;
        while (temp!=null){
            if(count==k){
                return temp.data;
            }
            count++;
            temp=temp.next;
        }
        return -1;
    }

    //recursive method
    public static int getNthNodeFromLinkedListII(Node head, int k){
        if(head==null){
            return -1;
        }
        if(k==1){
            return head.data;
        }
        int nthNodeFromLinkedListII = getNthNodeFromLinkedListII(head.next, k - 1);
        return nthNodeFromLinkedListII;
    }
    static void main() {

        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);
        System.out.println(getNthNodeFromLinkedList(head,6));
        System.out.println(getNthNodeFromLinkedListII(head,6));
    }
}
