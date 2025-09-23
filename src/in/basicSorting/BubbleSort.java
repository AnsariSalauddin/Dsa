package in.basicSorting;

public class BubbleSort {
    public static void bubbleSort(int[] arr){
        boolean swap=false;
         for (int i = 0; i < arr.length - 1; i++) {
             swap = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap=true;
                }
            }
            if(!swap){
                System.out.println("break");
                break;
            }
        }
        for (int num:arr){
            System.out.print(num+" ");
        }

    }
    public static void main(String[] args) {
        int[] arr={5,4,6,2,1};
         bubbleSort(arr);

    }
}
