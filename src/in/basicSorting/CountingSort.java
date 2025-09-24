package in.basicSorting;

public class CountingSort {
    public static void countingSort(int[] arr){
        int large=Integer.MIN_VALUE;
        for (int i=0; i<arr.length;i++){
            large=Math.max(arr[i],large);
        }
        int[] count=new int[large+1];
        for (int i=0; i<arr.length; i++){
            count[arr[i]]++;
        }
        int j=0;
        for (int i=0; i<count.length;i++){
            while (count[i]>0){
                arr[j]=i;
                j++;
                count[i]--;
            }
        }
    }
    public static void printArray(int[] arr){
        for (int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr={5,4,1,3,5,5,2};
        countingSort(arr);
        printArray(arr);

    }
}
