package in.LinkedList.Question.easy;

public class RemoveEverykthNodeOflinkedList {
    public static Node removeEveryKthNodeOfLinkedList(Node head, int k) {
        Node temp = head;
        Node prev = null;
        int i = 0;
        while (temp != null) {
            i++;
            if (i % k == 0) {
                if (prev != null) {
                    prev.next = temp.next;
                }else {
                    head = temp.next;
                }
            } else {
                prev = temp;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void printlinkedList(Node head){
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
        Node node = removeEveryKthNodeOfLinkedList(head, 2);
        printlinkedList(node);
    }
}
