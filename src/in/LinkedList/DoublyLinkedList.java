package in.LinkedList;

class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        next = null;
        prev = null;
    }
}

public class DoublyLinkedList {
    Node head;
    Node tail;
    public void insertAtHead(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }
    // Insert at the end
    public void insertAtTail(int data) {
        Node newNode = new Node(data);

        if (tail == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }
    // Delete a node by value
    public void delete(int data) {
        if (head == null) return;

        Node temp = head;

        while (temp != null && temp.data != data) {
            temp = temp.next;
        }

        if (temp == null) return; // not found

        // If deleting head
        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
            return;
        }

        // If deleting tail
        if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
            return;
        }

        // Middle node
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    public void printForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Print backward
    public void printBackward() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
    static void main() {

        DoublyLinkedList dd=new DoublyLinkedList();
        dd.insertAtHead(1);
        dd.insertAtHead(2);
        dd.printForward();

    }
}
