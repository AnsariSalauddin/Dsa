package in.Stack.StackQuestion;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    //brute force time complexity o(n*2) and space complexity o(n)
    public static int[] nextGreaterElement(int[] arr){
        int n=arr.length;
        int[] nge=new int[n];
        for (int i=0; i<n; i++){
            nge[i]=-1;
            for (int j=i; j<n; j++){
                if(arr[j]>arr[i]){
                    nge[i]=arr[j];
                    break;
                }

            }
        }
        return nge;
    }
    //better approach
    public static int[] nextGreaterElementII(int[] arr){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int[] nge=new int[n];
        for (int i=n-1; i>=0; i--){
            while (!st.isEmpty() && arr[i]>=st.peek()){
                st.pop();
            }

            if(st.isEmpty()) {
                nge[i] = -1;
            }
            else{
                nge[i]=st.peek();
            }
            st.push(arr[i]);
        }
        return nge;
    }
    static void main() {
        int[] arr = {1, 3, 2, 4};
        //Output: [3, 4, 4, -1]
        int[] ints = nextGreaterElement(arr);
        System.out.println(Arrays.toString(ints));
        int[] ints1 = nextGreaterElementII(arr);
        System.out.println(Arrays.toString(ints1));
    }
}
