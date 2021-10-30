package com.bianjiahao.algorithm.class04;

/**
 * @Author Obito
 * @Date 2021/10/30 4:51 下午
 * 堆排序
 */
public class HeapSort {
    /**
     * 堆排序
     * @param arr 需要进行排序的数组
     */
    public static void heapSort(int[] arr){
        // 如果需要进行排序的数组为空，或者数组中只有一个元素的话，直接返回
        if (arr == null || arr.length < 2){
            return;
        }
        // 将数组从下往上变成大根堆
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
        // 定义堆的大小
        int heapSize = arr.length;
        // 因为已经变成了大根堆的结构，所以数组的第一个数一定是当前数组中最大的数，将第一个数和最后一个数进行交换，再将除了除了最后一个数的其他数变成大根堆的结构，周而复始
        swap(arr,0,--heapSize);
        while (heapSize > 0){
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }

    public static void heapify(int[] arr, int index, int heapSize) {
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

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
