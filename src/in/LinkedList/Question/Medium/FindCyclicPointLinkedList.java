package in.LinkedList.Question.Medium;

public class FindCyclicPointLinkedList {
    public static int detectCyclicInLinkedList(Node head) {
        Node slow = head;
        Node fast = head;
        Boolean isCyclic=false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCyclic=true;
                break;
            }
        }
        if(!isCyclic)return -1;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
            if (slow == fast) {
                return slow.data;
            }
        }
        return -1;
    }

    static void main() {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = node.next;
        int i = detectCyclicInLinkedList(node);
        System.out.println(i);

    }
}
