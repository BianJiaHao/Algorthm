package com.bianjiahao.review.first;

public class HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i >= 0 ; i--) {
            heapify(arr,i,arr.length);
        }
        int heapSize = arr.length;
        swap(arr,0,--heapSize);
        while (heapSize > 0) {
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }

    public static void heapify(int[] arr,int index,int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largestIndex = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largestIndex = arr[largestIndex] > arr[index] ? largestIndex : index;
            if (largestIndex == index) {
                break;
            }
            swap(arr,largestIndex,index);
            index = largestIndex;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
