package com.bianjiahao.topicOfBook;

import java.util.Stack;

/**
 * 可见山峰对数量
 * @author admin
 */
public class VisiblePeaks {

    public static class Record {
        private final int value;
        private int count;

        public Record(int value) {
            this.value = value;
            this.count = 1;
        }
    }

    public static int getCount(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int size = arr.length;
        int maxIndex = 0;
        Stack<Record> stack = new Stack<>();
        // 首先找到一个最大值的Index
        for (int i = 0; i < arr.length; i++) {
            maxIndex = arr[maxIndex] > arr[i] ? maxIndex : i;
        }
        // 将一个最大值先压入栈中
        stack.push(new Record(arr[maxIndex]));
        int index = nextIndex(maxIndex,size);
        int res = 0;
        // 开始遍历
        while (index != maxIndex) {
            while (stack.peek().value < arr[index]) {
                int k = stack.pop().count;
                res += getSum(k) + 2 * k;
            }
            if (stack.peek().value == arr[index]) {
                stack.peek().count++;
            }else {
                stack.push(new Record(arr[index]));
            }
            index = nextIndex(index,size);
        }
        // 开始清理第一阶段（栈中剩余数量大于2个）
        while (stack.size() > 2) {
            int times = stack.pop().count;
            res += getSum(times) + 2 * times;
        }
        // 开始清理第二阶段（栈中剩余数量等于2个）
        if (stack.size() == 2) {
            int times = stack.pop().count;
            res += getSum(times) + stack.peek().count == 1 ? times : 2 *  times;
        }
        // 开始清理第三阶段（栈中剩余数量等于1个）
        res += getSum(stack.pop().count);
        return res;
    }

    public static int nextIndex(int index,int size) {
        return index < size - 1 ? index + 1 : 0;
    }

    public static int getSum(int k) {
        return k == 1 ? 0 : (k * (k - 1) / 2);
    }
}
