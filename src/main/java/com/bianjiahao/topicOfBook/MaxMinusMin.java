package com.bianjiahao.topicOfBook;

import java.util.LinkedList;

/**
 * @author Obito
 */
public class MaxMinusMin {

    public static int getNum(int[] arr,int num) {
        if (arr == null || num < 0) {
            return 0;
        }
        LinkedList<Integer> maxQueue = new LinkedList<>();
        LinkedList<Integer> minQueue = new LinkedList<>();
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < arr.length) {
            while (j < arr.length) {
                while (!minQueue.isEmpty() && arr[j] <= arr[minQueue.peekLast()]) {
                    minQueue.pollLast();
                }
                minQueue.add(j);
                while (!maxQueue.isEmpty() && arr[j] >= arr[maxQueue.peekLast()]) {
                    maxQueue.pollLast();
                }
                if (maxQueue.isEmpty()) {
                    maxQueue.add(j);
                }
                if (!maxQueue.isEmpty() && !minQueue.isEmpty() && arr[maxQueue.peekFirst()] - arr[minQueue.peekFirst()] > num) {
                    break;
                }
                j++;
            }
            int n = j - i;
            //res += 1 + ((n - 1) * (n + 2)) / 2;
            res += n;
            if (!minQueue.isEmpty() && minQueue.peekFirst() == i) {
                minQueue.pollFirst();
            }
            if (!maxQueue.isEmpty() && maxQueue.peekFirst() == i) {
                maxQueue.pollFirst();
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6,5,7,9,5};
        int num = 3;
        System.out.println(getNum(arr,num));
    }
}
