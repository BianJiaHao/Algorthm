package com.bianjiahao.review.first;

import java.util.PriorityQueue;

public class HeapSortQuestion {

    public static void sortedArrDistanceLessK(int[] arr,int k) {
        if (arr == null || arr.length < 2 || k > arr.length || k <= 0) {
            return;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for (; index < Math.min(arr.length - 1,k); index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        for (; i < arr.length; i++,index++) {
            arr[i] = heap.poll();
            heap.add(index);
        }
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }
}
