package in.LinkedList.Question;

class Node {
    int data;
    Node next;
    public Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class ReverseLinkedList {
    public static void traverseForwor(Node node){
        Node temp=node;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    public static Node reverseLinkedList(Node head){
        Node cur=head;
        Node prev=null;
        Node next=null;

        while (cur!=null){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        head=prev;
        return head;
    }
    static void main() {
        Node node=new Node(1);
        node.next=new Node(2);
        node.next.next=new Node(3);
        node.next.next.next=new Node(4);
        node.next.next.next.next=new Node(5);
        traverseForwor(node);
        System.out.println();
        Node node1 = reverseLinkedList(node);
        traverseForwor(node1);

    }
}
