package com.bianjiahao.leetCode;

/**
 * 最少的硬币数量
 * @author Obito
 */
public class Topic103MinCoinsNumber {

    public static int violenceWay(int[] coins,int amount) {
        if (coins == null || amount < 0) {
            return -1;
        }
        int[][] dp = new int[coins.length][amount + 1];
        return process(coins,0,amount,dp);
    }

    public static int process(int[] coins, int index, int amount,int[][] dp) {
        if (index == coins.length - 1) {
            dp[index][amount] = amount % coins[index] == 0 ? amount/coins[index] : -1;
            return dp[index][amount];
        }
        int ans = Integer.MAX_VALUE;
        for (int number = 0; number * coins[index] <= amount; number++) {
            int process;
            if (dp[index + 1][amount - number * coins[index]] != 0){
                process = dp[index + 1][amount - number * coins[index]];
            }else {
                process = process(coins, index + 1, amount - number * coins[index],dp);
            }
            if (process != -1) {
                ans = Math.min(ans,process + number);
            }
        }
        dp[index][amount] = ans == Integer.MAX_VALUE ? -1 : ans;
        return dp[index][amount];
    }

    public static void main(String[] args) {
        int[] arr = { 288,160,10,249,40,77,314,429 };
        int sum = 9208;
        System.out.println(violenceWay(arr,sum));
    }
}
