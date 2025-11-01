package in.Stack.StackQuestion;

import java.util.Stack;

public class EvalutionPostfixExpression {
    //    public static boolean isOperator(char c1){
//
//        switch (c1){
//            case '+':
//            case '-':
//            case '*':
//            case '/':
//            case '^':
//            case '%':
//                return true;
//        }
//        return false;
//    }
    static int floorDiv(int a, int b) {
        if (a * b < 0 && a % b != 0)
            return (a / b) - 1;
        return a / b;
    }

    public static int evaluationPostfixExpression(String[] arr) {
        Stack<Integer> res = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (Character.isDigit(arr[i].charAt(0)) || (arr[0].length() > 1 && arr[i].charAt(0) == '-')) {
                res.push(Integer.parseInt(arr[i]));
            } else {
                int p1 = res.pop();
                int p2 = res.pop();
                if (arr[i].charAt(0) == '+') {
                    res.push(p2 + p1);
                } else if (arr[i].charAt(0) == '-') {
                    res.push(p2 - p1);
                }else if(arr[i].charAt(0)=='*'){
                    res.push(p2*p1);
                }else if(arr[i].charAt(0)=='/'){
                    res.push(floorDiv(p2,p1));
                }else if(arr[i].charAt(0)=='^'){
                    res.push((int)Math.pow(p2,p1));
                }
            }
        }
        return res.pop();
    }

    public static void main(String[] args) {
        String[] arr = {"2", "3", "1", "*", "+", "9", "-"};
        System.out.println(evaluationPostfixExpression(arr));
    }
}
