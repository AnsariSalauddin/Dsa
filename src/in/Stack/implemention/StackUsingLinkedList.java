package in.Stack.implemention;

public class StackUsingLinkedList {

    static class Stack<T>{
        static class Node<T>{
            T data;
            Node<T> next;
            Node(T data){
                this.data=data;
                this.next=null;
            }
        }

        Node<T> head=null;
        public boolean isEmpty(){
            return head==null;
        }
        public void push(T data){
            Node<T> newNode=new Node(data);
            if(head==null){
                head=newNode;
                return;
            }
            newNode.next=head;
            head=newNode;
        }
        public T pop(){
            if(head==null){
                throw new RuntimeException("Stack is empty");
            }
            T data=head.data;
            head=head.next;
            return data;

        }
        public T peek(){
            if(head==null){
                throw new RuntimeException("Stack is empty");
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
