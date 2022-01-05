package com.bianjiahao.algorithm.class12;

/**
 * 洗咖啡问题
 * @author Obito
 */
public class Coffee {

    /**
     * 暴力递归
     * @param coffee 每个喝完咖啡的时间
     * @param washTime 洗碗机洗一个杯子所需要的时间
     * @param volatilizeTime 自由挥发干净所需要的时间
     * @return 全部干净最早的时间
     */
    public static int violenceWay(int[] coffee,int washTime,int volatilizeTime) {
        if (coffee == null || washTime < 0 || volatilizeTime < 0) {
            return 0;
        }
        return process(coffee,washTime,volatilizeTime,0,0);
    }

    public static int process(int[] coffee, int washTime, int volatilizeTime, int index, int washLine) {
        if (index == coffee.length - 1) {
            return Math.min(Math.max(washLine,coffee[index]) + washTime,coffee[index] + volatilizeTime);
        }
        int wash = Math.max(washLine,coffee[index]) + washTime;
        int nextPlanOne = process(coffee,washTime,volatilizeTime,index + 1,wash);
        int planOneTime = Math.max(wash,nextPlanOne);
        int dry = coffee[index] + volatilizeTime;
        int nextPlanTwo = process(coffee,washTime,volatilizeTime,index + 1,washLine);
        int planTwoTime = Math.max(dry,nextPlanTwo);
        return Math.min(planOneTime,planTwoTime);
    }

    /**
     * 动态规划
     * @param coffee 每个喝完咖啡的时间
     * @param washTime 洗碗机洗一个杯子所需要的时间
     * @param volatilizeTime 自由挥发干净所需要的时间
     * @return 全部干净最早的时间
     */
    public static int dpWay(int[] coffee,int washTime,int volatilizeTime) {
        int coffeeSize = coffee.length;
        if (washTime > volatilizeTime) {
            return coffee[coffeeSize - 1] + volatilizeTime;
        }
        int limit = coffee[coffeeSize - 1] + coffeeSize * washTime;
        int[][] dp = new int[coffeeSize][limit + 1];
        for (int i = 0; i < limit; i++) {
            dp[coffeeSize - 1][i] = Math.min(Math.max(i,coffee[coffeeSize - 1]) + washTime,coffee[coffeeSize - 1] + volatilizeTime);
        }
        for (int i = coffeeSize - 2; i >= 0 ; i--) {
            int curLimit = coffee[i] + (i + 1) * washTime;
            for (int washLine = 0; washLine < curLimit; washLine++) {
                int wash = Math.max(washLine,coffee[i]) + washTime;
                int nextPlanOne = dp[i + 1][wash];
                int planOneTime = Math.max(wash,nextPlanOne);
                int dry = coffee[i] + volatilizeTime;
                int nextPlanTwo = dp[i + 1][washLine];
                int planTwoTime = Math.max(dry,nextPlanTwo);
                dp[i][washLine] = Math.min(planOneTime,planTwoTime);
            }

        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] coffee = new int[]{1,1,2,3,4,5,8};
        int washTime = 3;
        int volatilizeTime = 10;
        System.out.println(violenceWay(coffee,washTime,volatilizeTime));
        System.out.println(dpWay(coffee,washTime,volatilizeTime));
    }
}
