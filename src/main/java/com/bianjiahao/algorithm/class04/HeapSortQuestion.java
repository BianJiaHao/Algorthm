package com.bianjiahao.algorithm.class04;

import java.util.PriorityQueue;

/**
 * @Author Obito
 * @Date 2021/10/30 5:08 下午
 * 已知一个几乎有序的数组。几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离一定不超过k，并且k相对于数组长度来说是比较小的。
 * 请选择一个合适的排序策略，对这个数组进行排序。
 */
public class HeapSortQuestion {
    /**
     * 将给定的数组进行排序
     * @param arr 需要进行排序的数组
     * @param k 条件中给出的条件
     */
    public static void sortedArrDistanceLessK(int[] arr,int k){
        // 系统中提供的堆结构，默认为最小堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        // 将数组中的数添加到最小堆中
        int index = 0;
        for (; index < Math.min(arr.length - 1,k); index++) {
            heap.add(arr[index]);
        }
        // 每次将堆中的第一个数弹出，再往后添加一个数
        int i = 0;
        for (; index < arr.length ; i++,index++) {
            arr[i] = heap.poll();
            heap.add(arr[index]);
        }
        // 将最后k个数依次弹出
        while (!heap.isEmpty()){
            arr[i++] = heap.poll();
        }
    }
}
