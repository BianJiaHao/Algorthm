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

    public int partition(int[] arr,int l,int r){
        // 如果数组左边界 > 右边界 说明无法进行排序
        if (l > r){
            return -1;
        }
        // 相等说明数组只有一个数，无需进行排序
        if (l == r){
            return l;
        }
        // 定义 <= 区域的右边界的下标
        int lessEqual = l -1;
        // 定义开始遍历的下标
        int index = l;
        // 开始遍历数组
        while (index < r){
            // 如果数 <= 数组的最后一个数，将该数和小于区域的右一位进行交换并且将小于区域右扩一位，如果数 > 数组的最后一个元素直接跳过
            if (arr[index] <= arr[r]){
                swap(arr,index,++lessEqual);
            }else {
                index++;
            }
        }
        // 因为最后一个数一直没有动，最后将最后一个数和小于区域的右一位进行交换，并且将小于区域右扩一位
        swap(arr,++lessEqual,r);
        return lessEqual;
    }
}
