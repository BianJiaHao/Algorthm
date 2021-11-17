package com.bianjiahao.algorithm.class05;

/**
 * 计数排序
 * @author admin
 */
public class CountSort {

    /**
     * 计数排序
     * @param arr 要排序的数据
     */
    public static void countSort(int[] arr){
        // 如果要排序的数组为空或者数组的大小小于2直接返回
        if (arr == null || arr.length < 2){
            return;
        }
        // 找出数组中的最大值
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max,arr[i]);
        }
        // 准备一个最大长度的桶
        int[] bucket = new int[max + 1];
        // 遍历数组，有几个就在桶对应的位置上加几个
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        // 将桶倒出来
        int i = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j]-- > 0){
                arr[i++] = j;
            }
        }
    }
}
