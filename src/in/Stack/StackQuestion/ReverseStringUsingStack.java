package in.Stack.StackQuestion;

import java.util.Stack;

public class ReverseStringUsingStack {
    public static String reverseString(String str){
        Stack<Character> charStack=new Stack<>();
        for (Character ch:str.toCharArray()){
            charStack.push(ch);
        }
        StringBuilder result=new StringBuilder();
        while (!charStack.isEmpty()){
            result.append(charStack.pop());
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String str="abc";
        String string = reverseString(str);
        System.out.println(string);

    }
}
