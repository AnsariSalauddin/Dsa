package in.Heap;

import java.util.ArrayList;
import java.util.Comparator;

public class HeapUsingArrayList {
    static class Heap<T>{
        ArrayList<T> arrayList=new ArrayList<>();
        Comparator<T> comparator;
        Heap(Comparator<T> comparator){
            this.comparator=comparator;
        }
        public Heap() {
            this.comparator = (a, b) -> ((Comparable<T>) a).compareTo(b);
        }

        public void add(T data){
            arrayList.add(data);
            int cIx=arrayList.size()-1;
            int pIx=(cIx-1)/2;

            while (comparator.compare(arrayList.get(cIx),(arrayList.get(pIx))) < 0){
                T temp=arrayList.get(cIx);
                arrayList.set(cIx,arrayList.get(pIx));
                arrayList.set(pIx,temp);
                cIx = pIx;
                pIx = (cIx - 1) / 2;
            }
        }
        public void heapify(int i){
            int left=2*i+1;
            int right=2*i+2;
            int minIdx=i;
            if(left<arrayList.size() && comparator.compare(arrayList.get(minIdx),(arrayList.get(left)))>0){
                minIdx=left;
            }
            if(right<arrayList.size() && comparator.compare(arrayList.get(minIdx),(arrayList.get(right)))>0){
                minIdx=right;
            }
            if(minIdx!=i){
                T temp=arrayList.get(i);
                arrayList.set(i,arrayList.get(minIdx));
                arrayList.set(minIdx,temp);
                heapify(minIdx);
            }
        }
        public T remove(){
            T data=arrayList.get(0);

//            T temp=arrayList.get(0);
            arrayList.set(0,arrayList.get(arrayList.size()-1));
//            arrayList.set(arrayList.size()-1,temp);
            arrayList.remove(arrayList.size()-1);
            heapify(0);
            return data;
        }
        public boolean isEmpty(){
            return arrayList.isEmpty();
        }
        public T peek(){
            return arrayList.get(0);
        }
    }
    public static void main(String[] args) {
        Heap<Integer> heap=new Heap<>((a,b)->a-b);
        heap.add(5);
        heap.add(3);
        heap.add(4);
        heap.add(1);
        heap.add(2);
        heap.add(10);
        heap.add(100);
        while (!heap.isEmpty()){
            System.out.println(heap.remove());
        }

    }
}
