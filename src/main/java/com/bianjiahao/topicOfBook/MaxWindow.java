package com.bianjiahao.topicOfBook;

import java.util.LinkedList;

/**
 * 生产窗口最大值数组
 * @author Obito
 */
public class MaxWindow {

    public static int[] getMaxWindow(int[] arr,int size){
        if (arr == null || arr.length == 0){
            return new int[]{};
        }
        if (arr.length <= size){
            int max = getMaxNumber(arr,0,arr.length - 1);
            return new int[]{max};
        }
        int head = 0;
        int tail = head + size - 1;
        int[] ints = new int[arr.length - size + 1];
        int index = 0;
        while (tail <= arr.length - 1){
            int maxNumber = getMaxNumber(arr, head, tail);
            ints[index] = maxNumber;
            head++;
            tail++;
            index++;
        }
        return ints;
    }

    private static int getMaxNumber(int[] arr, int start, int end) {
        int max = arr[start];
        for (int i = start; i <= end; i++) {
            max = Math.max(max,arr[i]);
        }
        return max;
    }

    private static int[] getMaxNumber(int[] arr,int size) {
        if (arr == null || arr.length < size || size < 1){
            return null;
        }
        LinkedList<Integer> queueMax = new LinkedList<>();
        int[] ints = new int[arr.length - size + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!queueMax.isEmpty() && arr[queueMax.peekLast()] < arr[i]){
                queueMax.pollLast();
            }
            queueMax.add(i);
            if (queueMax.peekFirst() == i - size){
                queueMax.peekFirst();
            }
            if (i >= size - 1){
                ints[index++]  = arr[queueMax.peekFirst()];
            }
        }
        return ints;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{4,3,5,4,3,3,6,7};
        int[] maxWindow = getMaxNumber(ints, 3);
        for (int i = 0; i < maxWindow.length; i++) {
            System.out.print(maxWindow[i]);
        }
    }
}
