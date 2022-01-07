package com.bianjiahao.topicOfBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 单调栈问题
 * @author Obito
 */
public class GetNearLessNoRepeat {

    /**
     * arr 没有重复数据
     * @param arr 数组
     * @return 每个数左右两侧离他们最近的比他们小的位置
     */
    public static int[][] getNearLessNoRepeat(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[][] ans = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                Integer index = stack.pop();
                ans[index][0] = stack.isEmpty() ? -1 : stack.peek();
                ans[index][1] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            Integer index = stack.pop();
            ans[index][0] = stack.isEmpty() ? -1 : stack.peek();
            ans[index][1] = -1;
        }
        return ans;
    }

    /**
     * arr 有重复的数据
     * @param arr 数组
     * @return 每个数左右两侧离他们最近的比他们小的位置
     */
    public static int[][] getNearLessHaveRepeat(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[][] ans = new int[arr.length][2];
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek().get(0)]) {
                List<Integer> list = stack.pop();
                for (Integer index : list) {
                    ans[index][0] = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                    ans[index][1] = i;
                }
            }
            if (!stack.isEmpty() && arr[i] == arr[stack.peek().get(0)]) {
                List<Integer> list = stack.pop();
                list.add(i);
                stack.push(list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }
        while (!stack.isEmpty()) {
            List<Integer> list = stack.pop();
            for (Integer index: list) {
                ans[index][0] = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                ans[index][1] = -1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,1,3,4,3,5,3,2,2};
        int[][] nearLessNoRepeat = getNearLessHaveRepeat(arr);
        String s = Arrays.deepToString(nearLessNoRepeat);
        System.out.println(s);
    }

}
