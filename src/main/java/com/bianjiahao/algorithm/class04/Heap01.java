package com.bianjiahao.algorithm.class04;

/**
 * 堆
 * @Author Obito
 * @Date 2021/10/1 9:38 上午
 */
public class Heap01 {
    /**
     * 自定义大根堆
     */
    static class MyMaxHeap{
        // 定义堆
        private int[] heap;
        // 定义堆大小的最大值
        private final int limit;
        // 定义堆的大小
        private int heapSize;

        public MyMaxHeap(int limit) {
            heap = new int[limit];
            this.limit = limit;
            heapSize = 0;
        }

        public static void swap(int[] arr, int i, int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        /**
         * 将数放入大根堆中
         * @param value 要放入的数
         */
        public void push(int value){
            if (heapSize == limit){
                throw new RuntimeException("Heap size is Full!");
            }
            heap[heapSize] = value;
            heapInsert(heap,heapSize++);
        }

        /**
         * 将数放入堆中并且保证依然是个大根堆
         * @param arr 堆
         * @param index 放人的位置
         */
        private void heapInsert(int[] arr, int index) {
            while(arr[index] > arr[(index - 1) / 2]){
                swap(arr,index,(index - 1)/2);
                index = (index - 1) / 2;
            }

        }
    }
}
