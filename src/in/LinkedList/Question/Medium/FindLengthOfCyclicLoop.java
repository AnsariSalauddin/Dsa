package in.LinkedList.Question.Medium;

public class FindLengthOfCyclicLoop {
    public static int findLengthOfCycliLoop(Node head){
        Node slow=head;
        Node fast=head;
        while (slow!=null && fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return countLength(slow);
            }
        }
        return 0;
    }
    public static int countLength(Node head){
        int count=1;
        Node temp=head;
        while (temp.next!=head){
            count++;
            temp=temp.next;
        }
        return count;
    }
    static void main() {

        Node head = new Node(25);
        head.next = new Node(14);
        head.next.next = new Node(19);
        head.next.next.next = new Node(33);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = head.next.next;
        int lengthOfCycliLoop = findLengthOfCycliLoop(head);
        System.out.println(lengthOfCycliLoop);
    }
}
