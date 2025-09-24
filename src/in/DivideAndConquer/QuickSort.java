package in.DivideAndConquer;

public class QuickSort {
    public static void printArray(int[] arr){
        for (int in:arr){
            System.out.print(in+" ");
        }
        System.out.println();
    }
    public static void quickSort(int[] arr, int si, int ei){
        if(si>=ei){
            return;
        }
        int pIdx = partion(arr, si, ei);
        quickSort(arr,si,pIdx-1);
        quickSort(arr,pIdx+1,ei);
    }
    public static int partion(int[] arr,int si, int ei){
        int piviot=arr[ei];
        int i=si-1;
        for (int j=si; j<ei; j++){
            if(arr[j]<=piviot){
                i++;
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        i++;
        arr[ei]=arr[i];
        arr[i]=piviot;
        return i;
    }
    public static void main(String[] args) {
//        int[] arr={8,3,9,4,5};
        int[] arr={5,4,3,2,1};
        quickSort(arr,0,arr.length-1);
        printArray(arr);

    }
}
