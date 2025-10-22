package in.Queue;

public class QueueUsingLinkedList {
    static class Node<T>{
        private T data;
        private Node next;
        Node(T data){
            this.data=data;
            this.next=null;
        }

    }
    static class Queue<T>{
        Node<T> front;
        Node<T> rear;

        public boolean isEmpty(){
            return front==null&& rear==null;
        }
        public void add(T data){
            Node<T> node=new Node<>(data);
            if(isEmpty()){
                front=rear=node;
                return;
            }
            rear.next=node;
            rear=node;
        }
        public T remove(){
            if (isEmpty()){
                System.out.println("Queue is empty");
            }
            T data=front.data;
           if(front==rear){
               front=rear=null;
           }else {
               front=front.next;
           }
            return data;
        }
        public T peek(){
            if (isEmpty()){
                System.out.println("queue is empty");
            }
            return front.data;
        }
    }
    public static void main(String[] args) {
        Queue<Integer> queue=new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        while (!queue.isEmpty()){
            System.out.println(queue.remove());
        }
    }
}
