package in.Stack.StackQuestion;

import java.util.Stack;

class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first=first;
        this.second=second;
    }
}
public class MinStackII {
    private Stack<Pair> stack=new Stack<>();

    public void push(int data){
        if(stack.isEmpty()){
            stack.push(new Pair(data,data));
            return;
        }
        stack.push(new Pair(data,Math.min(data,stack.peek().second)));
    }
    public int pop(){
        if(stack.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        Pair pop = stack.pop();
        return pop.first;

    }
    public int minValue(){
        if(stack.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        return stack.pop().second;
    }

    static void main() {
        MinStackII minStackII=new MinStackII();
        minStackII.push(12);
        minStackII.push(15);
        minStackII.push(10);
        minStackII.pop();
        System.out.println(minStackII.minValue());

    }
}
