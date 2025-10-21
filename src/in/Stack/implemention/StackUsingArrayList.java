package in.Stack.implemention;

import java.util.ArrayList;
import java.util.List;

public class StackUsingArrayList {
    static class Stack<T> {
        private List<T> list = new ArrayList<>();

        public boolean isEmpty() {
            return list.isEmpty();
        }

        public void push(T data) {
            list.add(data);
        }

        public T pop() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return list.remove(list.size() - 1);
        }

        public T peek() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return list.get(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> intStack = new Stack<>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);

        while (!intStack.isEmpty()) {
            System.out.println(intStack.pop());
        }

        System.out.println("\nUsing String Stack:");
        Stack<String> stringStack = new Stack<>();
        stringStack.push("Hello");
        stringStack.push("World");

        while (!stringStack.isEmpty()) {
            System.out.println(stringStack.pop());
        }
    }
}
