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
        private final int[] heap;
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
         * 返回最大值，并且将最大值删除，数组依然要保存大根堆
         * @return 数组的最大值
         */
        public int pop(){
            // 大根堆的第一个数一定是最大值
            int ans = heap[0];
            // 将数组的第一个值和最后一个值进行交换
            swap(heap,0,--heapSize);
            // 将除了最后一个数的数组变成大根堆
            heapify(heap,0,heapSize);
            return ans;
        }

        /**
         * 将数组变成大根堆
         * @param arr 数组
         * @param index 开始的下标
         * @param heapSize 数组大小
         */
        public void heapify(int[] arr, int index, int heapSize) {
            // 找到左孩子的下标
            int left = index * 2 + 1;
            while (left < heapSize){
                int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
                largest = arr[largest] > arr[index] ? largest : index;
                if (largest == index){
                    break;
                }
                swap(arr,largest,index);
                index = largest;
                left = index * 2 + 1;
            }
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
