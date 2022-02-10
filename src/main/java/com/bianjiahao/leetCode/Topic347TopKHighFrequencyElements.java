package com.bianjiahao.leetCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Obito
 */
public class Topic347TopKHighFrequencyElements {

    public static int[] getNum(int[] arr,int k) {
        if (arr == null || k < 0 || k > arr.length) {
            return new int[]{};
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getKey();
            int count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{value,count});
                }
            }else {
                queue.offer(new int[]{value,count});
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
