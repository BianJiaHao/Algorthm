package com.bianjiahao.algorithm.class09;

import java.util.PriorityQueue;

/**
 * 黄金切分问题
 * @author Obito
 */
public class LessMoneySplitGold {

    public static int greedProcess(int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : arr) {
            queue.add(i);
        }
        int ans = 0;
        int cur = 0;
        while (queue.size() > 1){
            cur = queue.poll() + queue.poll();
            ans += cur;
            queue.add(cur);
        }
        return ans;
    }

    public static int violence(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        return violenceProcess(arr,0);
    }

    private static int violenceProcess(int[] arr, int pre) {
        if (arr.length == 1){
            return pre;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                ans = Math.min(ans,violenceProcess(copyAndMergeTwo(arr,i,j),pre + arr[i] + arr[j]));
            }
        }
        return ans;
    }

    private static int[] copyAndMergeTwo(int[] arr, int i, int j) {
        int[] ans = new int[arr.length - 1];
        int ansi = 0;
        for (int k = 0; k < arr.length; k++) {
            if (k != i && k != j){
                ans[ansi++] = arr[k];
            }
        }
        ans[ansi] = arr[i] + arr[j];
        return ans;
    }
}
