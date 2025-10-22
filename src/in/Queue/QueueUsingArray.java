package in.Queue;

public class QueueUsingArray {
    static class Queue<T>{
        private int capacity;
        private int rear;
        private T[] array;
        @SuppressWarnings("unchecked")
        Queue(int size){
            this.capacity=size;
            this.rear=-1;
            this.array=(T[]) new Object[size];
        }
        public boolean isEmpty(){
            return rear==-1;
        }
        public boolean isFull(){
            return rear==capacity-1;
        }
        public void add(T data){
            if(rear==capacity-1){
                System.out.println("queue is fulll");
                return;
            }
            array[++rear]=data;
        }
        public T remove(){
            if (rear==-1){
                System.out.println("queue is empty");
                return null;
            }
            T data=array[0];
            for (int i=0; i<array.length-1;i++){
                array[i]=array[i+1];
            }
            array[rear]=null;
            rear--;
            return data;
        }
        public T peek(){
            if(rear==-1){
                System.out.println("queue is empty");
                return null;
            }
            return array[0];
        }
    }
    public static void main(String[] args) {
        Queue<Integer> queue=new Queue<>(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        Integer remove = queue.remove();
        System.out.println(remove);
        System.out.println(queue.remove());
        queue.add(6);

    }
}
