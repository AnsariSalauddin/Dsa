package in.array;

import java.util.HashMap;

public class LargestSubarrayWith0Sum {
    public static int largestSubArrayWithSum(int[] arr){
        if(arr.length==0){
            return 0;
        }
        HashMap<Integer,Integer> hs=new HashMap<>();
        int sum=0;
        int maxLen=0;

        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
            if(sum==0){
                maxLen=i+1;
            }
            if(hs.containsKey(sum)){
                maxLen=Math.max(maxLen,i-hs.get(sum));
            }else {
                hs.put(sum, i);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] arr={15, -2, 2, -8, 1, 7, 10, 23};
        int i = largestSubArrayWithSum(arr);
        System.out.println(i);
    }
}
