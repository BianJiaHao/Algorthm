package com.bianjiahao.algorithm.class11;

/**
 * 背包问题
 * @author Obito
 */
public class Knapsack {

    /**
     * 暴力递归过程
     * @param weight 商品重量的数组
     * @param values 商品价值的数组
     * @param bag 背包的总容量
     * @return 能反入商品的最大价值
     */
    public static int getMaxValue(int[] weight,int[] values,int bag) {
        return process(weight,values,0,bag);
    }

    public static int process(int[] weight, int[] values, int index, int bag) {
        if (bag <= 0){
            return 0;
        }
        if (index == weight.length){
            return 0;
        }
        // 不选择
        int processOfNo = process(weight, values, index + 1, bag);
        // 选择
        int processOfYes = Integer.MIN_VALUE;
        if (bag >= weight[index]){
            processOfYes = values[index] + process(weight, values, index + 1, bag - weight[index]);
        }
        return Math.max(processOfNo,processOfYes);
    }

    /**
     * 动态规划
     * @param weight 商品重量的数组
     * @param values 商品价值的数组
     * @param bag 背包的总容量
     * @return 能反入商品的最大价值
     */
    public static int dpWay(int[] weight,int[] values,int bag) {
        int n = weight.length;
        int[][] dp = new int[n + 1][bag + 1];
        for (int i = n - 1; i >= 0 ; i--) {
            for (int j = 1; j <= bag; j++) {
                // 不选择
                int processOfNo = dp[i + 1][j];
                // 选择
                int processOfYes = Integer.MIN_VALUE;
                if (j >= weight[i]){
                    processOfYes = values[i] + dp[i + 1][j - weight[i]];
                }
                dp[i][j] = Math.max(processOfNo,processOfYes);
            }
        }
        return dp[0][bag];

    }

    public static void main(String[] args) {
        int[] weights = { 3, 2, 4, 7 };
        int[] values = { 5, 6, 3, 19 };
        int bag = 11;
        System.out.println(getMaxValue(weights,values,bag));
        System.out.println(dpWay(weights,values,bag));
    }
}
