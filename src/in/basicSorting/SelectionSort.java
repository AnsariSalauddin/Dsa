package in.basicSorting;

public class SelectionSort {
    public static void selectionSort(int[] arr){
        for (int i=0; i<arr.length-1;i++){
            int minPost=i;
            for (int j=i+1;j<arr.length;j++){
                if(arr[minPost]>arr[j]){
                    minPost=j;
                }
            }
            int temp=arr[minPost];
            arr[minPost]=arr[i];
            arr[i]=temp;
        }
    }
    public static void printArray(int[] arr){
        for (int num:arr){
            System.out.print(num+" ");
        }
    }
    public static void main(String[] args) {
        int[] arr={5,4,1,3,2};
        selectionSort(arr);
        printArray(arr);
    }
}
