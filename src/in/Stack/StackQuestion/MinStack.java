package in.Stack.StackQuestion;

import java.util.LinkedList;
import java.util.Stack;

//optimize approach
//time complexity o(1)
// space Complexity 0(n)
public class MinStack {
    private int min;
    private Stack<Integer> stack=new Stack<>();

    public  void push(int data){
        if(stack.isEmpty()){
            stack.add(data);
            min=data;
        }else if(data>min){
            stack.push(data);
        }else {
            stack.push(2*data-min);
            min=data;
        }
    }
    public  int pop(){
        if(stack.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        Integer pop = stack.pop();
        if(pop<min){
            int originMin=min;
            min=2*min-pop;
            return originMin;
        }else {
            return pop;
        }
    }
    public  int minValue(){
        return min;
    }
    public  int top(int data){
        Integer peek = stack.peek();
        if(peek<min){
            return min;
        }else {
            return peek;
        }
    }
    static void main() {
        MinStack minStack=new MinStack();
        minStack.push(12);
        minStack.push(15);
        minStack.push(10);
        int pop = minStack.pop();
        System.out.println(pop);
        System.out.println(minStack.minValue());
    }
}
