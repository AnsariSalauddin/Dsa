package in.Heap;

import java.util.Comparator;

public class HeapSort<T> {
    Comparator<T> comparator;
    HeapSort(Comparator<T> comparator){
        this.comparator=comparator;
    }
    public HeapSort() {
        this.comparator = (a, b) -> ((Comparable<T>) a).compareTo(b);
    }
    public  void heapSort(T[] arr){
        int n=arr.length;
        for (int i=n/2;i>=0;i--){
            heapify(arr,i,n);
        }
        for (int i=n-1; i>0; i--){
            T temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(arr,0,i);
        }
    }
    public  void heapify(T[] arr,int i, int size){
        int left=2*i+1;
        int right=2*i+2;
        int midIdx=i;

        if(left<size && comparator.compare(arr[left],arr[midIdx])>0){
            midIdx=left;
        }
        if (right<size && comparator.compare(arr[right],arr[midIdx])>0){
            midIdx=right;
        }
        if (midIdx!=i){
            T temp=arr[midIdx];
            arr[midIdx]=arr[i];
            arr[i]=temp;
            heapify(arr,midIdx,size);
        }

    }
    public static void main(String[] args) {
        Integer arr[]={1,2,4,5,3};
        HeapSort<Integer> heapSort=new HeapSort<>();
        heapSort.heapSort(arr);
        for (int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();

    }
}
