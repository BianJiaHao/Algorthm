package com.bianjiahao.review.first;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Heap02 {

    public static class MyHeap<T> {
        private ArrayList<T> heap;
        private HashMap<T,Integer> indexMap;
        private Integer heapSize;
        private Comparator<? super T> comparator;

        public MyHeap(Comparator<? super T> comparator) {
            heap = new ArrayList<>();
            indexMap = new HashMap<>();
            heapSize = 0;
            this.comparator = comparator;
        }

        public void put(T value) {
            heap.add(value);
            indexMap.put(value,heapSize);
            heapInsert(heapSize++);
        }

        public T pop() {
            T ans = heap.get(0);
            int endIndex = heapSize - 1;
            swap(0,endIndex);
            heap.remove(endIndex);
            indexMap.remove(ans);
            heapify(0,--heapSize);
            return ans;
        }

        public void resign(T value) {
            Integer index = indexMap.get(value);
            heapify(index,heapSize);
            heapInsert(index);
        }

        public void heapInsert(int index) {
            while (comparator.compare(heap.get(index),heap.get((index - 1) / 2)) < 0) {
                swap(index,(index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        public void heapify(int index,int heapSize) {
            int leftIndex = index * 2 +1;
            while (leftIndex < heapSize) {
                int largest = leftIndex + 1 < heapSize && comparator.compare(heap.get(leftIndex),heap.get(leftIndex + 1)) < 0 ? leftIndex + 1 : leftIndex;
                largest = comparator.compare(heap.get(index),heap.get(largest)) < 0 ? largest : index;
                if (largest == index) {
                    break;
                }
                swap(largest,index);
                index = largest;
                leftIndex = index * 2 + 1;
            }
        }

        public void swap(int i,int j) {
            T o1 = heap.get(i);
            T o2 = heap.get(j);
            heap.set(i,o2);
            heap.set(j,o1);
            indexMap.put(o1,j);
            indexMap.put(o2,i);
        }
    }
}
