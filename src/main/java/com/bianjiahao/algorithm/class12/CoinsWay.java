package com.bianjiahao.algorithm.class12;

/**
 * 硬币选择问题
 * @author Obito
 */
public class CoinsWay {

    /**
     * 暴力递归
     * @param coins 硬币面值的集合
     * @param aim 最终要组合的金额
     * @return 方法数
     */
    public static int violenceWay(int[] coins,int aim) {
        if (coins == null || aim < 0) {
            return 0;
        }
        return process(coins,0,aim);
    }

    public static int process(int[] coins, int index, int aim) {
        if (index == coins.length) {
            return aim == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int number = 0; number * coins[index] <= aim; number++) {
            ways += process(coins,index + 1,aim - number * coins[index]);
        }
        return ways;
    }

    /**
     * 动态规划
     * @param coins 硬币面值的集合
     * @param aim 最终要组合的金额
     * @return 方法数
     */
    public static int dpWay(int[] coins,int aim) {
        if (coins == null || aim < 0) {
            return 0;
        }
        int coinsKinds = coins.length;
        int[][] dp = new int[coinsKinds +1][aim + 1];
        dp[coinsKinds][0] = 1;
        for (int i = coinsKinds - 1; i >=0 ; i--) {
            for (int j = 0; j <= aim; j++) {
                dp[i][j] = dp[i + 1][j];
                if (j - coins[i] >= 0){
                    dp[i][j] += dp[i][j - coins[i]];
                }
            }
        }
        return dp[0][aim];
    }

    public static void main(String[] args) {
        int[] arr = { 1,2,5 };
        int sum = 11;
        System.out.println(violenceWay(arr,sum));
        System.out.println(dpWay(arr,sum));
    }

}
