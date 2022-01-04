package com.bianjiahao.algorithm.class12;

/**
 * 硬币选择问题
 * @author Obito
 */
public class CoinsWay {

    public static int violenceWay(int[] coins,int aim) {
        if (coins == null || aim < 0) {
            return 0;
        }
        return process(coins,0,aim);
    }

    private static int process(int[] coins, int index, int aim) {
        if (index == coins.length) {
            return aim == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int number = 0; number * coins[index] <= aim; number++) {
            ways += process(coins,index + 1,aim - number * coins[index]);
        }
        return ways;
    }
}
