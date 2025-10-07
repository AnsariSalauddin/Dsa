package in.Stack.StackQuestion;

import java.util.Stack;

public class InStackPushElementAtBottom {
    public static void pushAtBottom(Stack<Integer> stack,int data){
        if(stack.isEmpty()){
            stack.push(data);
            return;
        }
        int top=stack.pop();
        pushAtBottom(stack,data);
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        pushAtBottom(stack,0);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }
}
