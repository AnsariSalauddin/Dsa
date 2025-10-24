package in.Stack.StackQuestion;

import java.util.Stack;

public class InfixToPostFix {
    public static int pre(char c){
        if(c=='^'){
            return 3;
        }else if(c=='/' || c=='*'){
            return 2;
        }else if(c=='+' || c=='-'){
            return 1;
        }else {
            return -1;
        }
    }
    public static boolean asociation(char c){
        return c=='^';
    }
    public static String infixToPostFixt(String str){
        StringBuilder res=new StringBuilder();
        Stack<Character> stack=new Stack<>();
        int len=str.length();
        for (int i=0; i<len; i++){
            char cur=str.charAt(i);
            if((cur>='A' && cur<='Z') || (cur>='a' && cur<='z') || (cur>='0' &&cur<='9')){
                res.append(cur);
            }else if(cur=='('){
                stack.push(cur);
            }else if(cur==')'){
                while (!stack.isEmpty() && stack.peek()!='('){
                    res.append(stack.pop());
                }
                stack.pop();
            }else {
                while (!stack.isEmpty() && stack.peek() != '(' &&
                        (pre(stack.peek()) > pre(cur) ||
                                (pre(stack.peek()) == pre(cur) && !asociation(cur)))) {
                    res.append(stack.pop());
                }
                stack.push(cur);
            }

        }
        while (!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.toString();
    }
    public static void main(String[] args) {
        String exp = "a*(b+c)/d";
        String s = infixToPostFixt(exp);
        System.out.println(s);
    }
}
