package com.bianjiahao.review.first;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

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

    public static void main(String[] args) {
        final HashMap<String, String> map = new HashMap<String, String>(2);
        for (int i = 0; i < 10000000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    map.put(UUID.randomUUID().toString(), "");
                    map.get(UUID.randomUUID().toString());
                }
            }).start();
        }
    }
}
