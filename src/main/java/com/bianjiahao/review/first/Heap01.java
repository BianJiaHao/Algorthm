package com.bianjiahao.review.first;

public class Heap01 {


    static class MyHeap {
        private final int[] heap;
        private final int limit;
        private int heapSize;

        public MyHeap(int limit) {
            heap = new int[limit];
            this.limit = limit;
            heapSize = 0;
        }

        public void swap(int[] arr,int i,int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        public void push(int value) {
            if (heapSize == limit) {
                throw new RuntimeException("heap is full");
            }
            heap[heapSize] = value;
            heapInsert(heap,heapSize++);
        }

        public void heapInsert(int[] heap,int index) {
            while (heap[index] > heap[(index - 1) / 2]) {
                swap(heap,index,(index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        public int pop() {
            int ans = heap[0];
            swap(heap,0,--heapSize);
            heapify(heap,0,heapSize);
            return ans;
        }

        public void heapify(int[] arr,int index,int heapSize) {
            int left = index * 2 + 1;
            while (left < heapSize) {
                int largest = left + 1 < heapSize && heap[left + 1] > heap[left] ? left + 1 : left;
                largest = arr[largest] > arr[index] ? largest : index;
                if (largest == index) {
                    break;
                }
                swap(heap,largest,index);
                index = largest;
                left = index * 2 + 1;
            }
        }
    }
}
