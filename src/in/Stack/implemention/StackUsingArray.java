package in.Stack.implemention;

public class StackUsingArray {
    static class Stack<T> {
        private T[] array;
        private int top;
        private int capacity;

        @SuppressWarnings("unchecked")
        public Stack(int size) {
            this.capacity = size;
            this.array = (T[]) new Object[size];
            this.top = -1;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == capacity - 1;
        }

        public void push(T data) {
            if (isFull()) {
                throw new RuntimeException("Stack is full");
            }
            array[++top] = data;
        }

        public T pop() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return array[top--];
        }

        public T peek() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return array[top];
        }
    }

    public static void main(String[] args) {
        Stack<Integer> intStack = new Stack<>(5);
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);

        while (!intStack.isEmpty()) {
            System.out.println(intStack.pop());
        }

        System.out.println("\nUsing String Stack:");
        Stack<String> stringStack = new Stack<>(5);
        stringStack.push("Hello");
        stringStack.push("World");

        while (!stringStack.isEmpty()) {
            System.out.println(stringStack.pop());
        }
    }
}
