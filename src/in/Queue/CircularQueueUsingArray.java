package in.Queue;

public class CircularQueueUsingArray {
    static class Queue<T>{
       private int capacity;
       private int front;
       private int rear;
       private T[] array;

       @SuppressWarnings("unchecked")
       Queue(int size){
           this.capacity=size;
           this.rear=-1;
           this.front=-1;
           this.array=(T[]) new Object[size];
       }

       public boolean isEmpty(){
           return rear==-1 && front==-1;
       }
       public boolean isFull(){
           return (rear+1)%capacity==front;
       }
       public void add(T data){
           if(isFull()){
               System.out.println("Queue is fulll");
               return;
           }
           if(front==-1 && rear==-1){
               front=0;
           }
           rear=(rear+1)%capacity;
           array[rear]=data;
       }
       public T remove(){
           if(isEmpty()){
               System.out.println("Queue is empty");
           }
           T data=array[front];
           if(front==rear){
               rear=front=-1;
           }else {
               front=(front+1)%capacity;
           }
           return data;
       }
       public T peek(){
           if(isEmpty()){
               System.out.println("queue is empty");
           }
           return array[front];
       }

    }
    public static void main(String[] args) {
        Queue<Integer> queue=new Queue<>(2);
        queue.add(1);
        queue.add(2);
        System.out.println(queue.remove());
        queue.add(3);
        System.out.println(queue.remove());
        queue.add(4);
        while (!queue.isEmpty()){
            System.out.println(queue.remove());
        }

    }
}
