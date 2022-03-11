package com.bianjiahao.review.first;

public class CountSort {

    public static void countSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = Math.max(i,max);
        }
        int[] bucket = new int[max + 1];
        for (int i : arr) {
            bucket[i]++;
        }
        int i = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j]-- > 0) {
                arr[i++] = j;
            }
        }
    }
}
