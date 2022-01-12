package com.bianjiahao.topicOfBook;

import java.util.Stack;

/**
 * @author Obtio
 */
public class LargestRectangularMatrix {

    public static int maximalRectangle(String[] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[][] arr = new int[matrix.length][matrix[0].length()];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length(); j++) {
                arr[i][j] = matrix[i].charAt(j) - '0';
            }
        }
        int ans = 0;
        int[] height = new int[matrix[0].length()];
        for (int index = 0; index < matrix.length; index++) {

            for (int j = 0; j < arr[index].length; j++) {
                if (arr[index][j] == 0){
                    height[j] = 0;
                }else {
                    height[j] += 1;
                }
            }
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < height.length; i++) {
                while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                    Integer popIndex = stack.pop();
                    ans = Math.max(ans,stack.isEmpty() ? i * height[popIndex] : (i - stack.peek() - 1) * height[popIndex]);
                }
                stack.push(i);
            }
            while (!stack.isEmpty()) {
                Integer popIndex = stack.pop();
                ans = Math.max(ans,stack.isEmpty() ? height.length * height[popIndex] : (height.length - 1 - stack.peek()) * height[popIndex]);
            }
        }

        return ans;
    }

    public static int maximalRectangle2(String[] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int ans = 0;
        int[] height = new int[matrix[0].length()];
        for (String s : matrix) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '0') {
                    height[j] = 0;
                } else {
                    height[j] += 1;
                }
            }
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < height.length; i++) {
                while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                    Integer popIndex = stack.pop();
                    ans = Math.max(ans, stack.isEmpty() ? i * height[popIndex] : (i - stack.peek() - 1) * height[popIndex]);
                }
                stack.push(i);
            }
            while (!stack.isEmpty()) {
                Integer popIndex = stack.pop();
                ans = Math.max(ans, stack.isEmpty() ? height.length * height[popIndex] : (height.length - 1 - stack.peek()) * height[popIndex]);
            }
        }

        return ans;
    }


}
