package in.basicSorting;

public class InsertionSort {
    public static void insertionSort(int[] arr){
        for (int i=1; i<arr.length;i++){
            int curr=arr[i];
            int prev=i-1;
            while (prev>=0 && arr[prev]>curr){
                arr[prev+1]=arr[prev];
                prev--;
            }
            arr[prev+1]=curr;
        }
    }
    public static void printarray(int[] arr){
        for (int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr={4,3,2,1};
        insertionSort(arr);
        printarray(arr);
    }
}
