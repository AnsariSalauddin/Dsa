package in.Stack.implemention;

public class StackUsingArray1 {
    static class Stack<T>{
        private T[] array;
        private int capacity;
        private int top;
        Stack(int size){
            this.capacity=size;
            this.array=(T[]) new Object[size];
            this.top=-1;
        }

        public boolean isEmpty(){
            return top==-1;
        }
        public boolean isFull(){
            return top==capacity-1;
        }
        public void push(T data){
            if(isFull()){
                throw new RuntimeException("Stack is full"+", Stack size is "+this.capacity);
            }
            array[++top]=data;
        }
        public T pop(){
            if(isEmpty()){
                throw new RuntimeException("Stack is empty");
            }
            return array[top--];
        }
        public T peek(){
            if(isEmpty()){
                throw new RuntimeException("Stack is empty");
            }
            return array[top];
        }
    }
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
    }
}
