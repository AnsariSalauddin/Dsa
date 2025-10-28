package in.Stack.StackQuestion;

import java.util.Stack;

public class PrefixAndInfix {
    public static boolean isOperator(char c){
        switch (c){
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
            case '%':
                return true;
        }
        return false;
    }
    public static String convert(String str){
        Stack<String> st=new Stack<>();
        int n=str.length()-1;
        for (int i=n; i>=0;i--){
            char ch=str.charAt(i);
            if(isOperator(ch)){
                String ch1=st.pop();
                String ch2=st.pop();
                String tm="("+ch1+ch+ch2+")";
                st.push(tm);
            }else {
                st.push(ch+"");
            }
        }
        return st.pop();
    }
    public static void main(String[] args) {
        String exp = "*-A/BC-/AKL";
        System.out.println("Infix : " + convert(exp));
    }
}
