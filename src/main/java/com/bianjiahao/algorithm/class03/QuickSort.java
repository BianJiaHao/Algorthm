package com.bianjiahao.algorithm.class03;

/**
 * 快速排序
 * @author admin
 * @date 2021-9-26
 */
public class QuickSort {
    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
