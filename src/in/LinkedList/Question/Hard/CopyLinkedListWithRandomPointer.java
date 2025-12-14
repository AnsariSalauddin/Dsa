package in.LinkedList.Question.Hard;

import java.util.HashMap;

class  Node2 {
    int data;
    Node2 next;
    Node2 random;
    public Node2(int data){
        this.data=data;
        this.next=null;
        this.random=null;
    }
}
public class CopyLinkedListWithRandomPointer {

     public static Node2 copyLinkedListWithRandomPointer(Node2 head){
         Node2 newHead=new Node2(head.data);
         Node2 oldTemp=head.next;
         Node2 newTemp=newHead;
         HashMap<Node2,Node2> track=new HashMap<>();
         track.put(head, newHead);
         while (oldTemp!=null){
             Node2 copy=new Node2(oldTemp.data);
             track.put(oldTemp,copy);
             newTemp.next=copy;
             newTemp=newTemp.next;
             oldTemp=oldTemp.next;
         }
         
         oldTemp=head;
         newTemp=newHead;
         while (oldTemp!=null){
             newTemp.random=track.get(oldTemp.random);
             oldTemp=oldTemp.next;
             newTemp=newTemp.next;
         }
         return newHead;
     }
    public static void printLinkedListWithRandomPointer(Node2 head) {
        Node2 temp = head;

        while (temp != null) {
            int data = temp.data;
            int randomData = (temp.random != null) ? temp.random.data : -1;  // or "null"

            System.out.print(data + "(" + randomData + ") -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }


    static void main() {
        Node2 head = new Node2(7);
        head.next = new Node2(13);
        head.next.next = new Node2(11);
        head.next.next.next = new Node2(10);
        head.next.next.next.next = new Node2(1);

// random pointers (sample)
        head.random = null;                            // 7 -> null
        head.next.random = head;                       // 13 -> 7
        head.next.next.random = head.next.next.next.next; // 11 -> 1
        head.next.next.next.random = head.next;        // 10 -> 13
        head.next.next.next.next.random = head.next.next; // 1 -> 11

        printLinkedListWithRandomPointer(head);
        Node2 node2 = copyLinkedListWithRandomPointer(head);
        printLinkedListWithRandomPointer(node2);


    }
}
