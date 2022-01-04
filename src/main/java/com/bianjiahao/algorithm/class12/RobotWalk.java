package com.bianjiahao.algorithm.class12;

/**
 * 机器人走步问题
 * 假设有排成一行的N个位置，记为1~N，N 一定大于或等于 2
 * 开始时机器人在其中的M位置上(M 一定是 1~N 中的一个)
 * 如果机器人来到1位置，那么下一步只能往右来到2位置；
 * 如果机器人来到N位置，那么下一步只能往左来到 N-1 位置；
 * 如果机器人来到中间位置，那么下一步可以往左走或者往右走；
 * 规定机器人必须走 K 步，最终能来到P位置(P也是1~N中的一个)的方法有多少种
 * 给定四个参数 N、M、K、P，返回方法数。
 * @author Obito
 */
public class RobotWalk {

    public static int getRobotWalkWaysNumber(int totalIndex,int currentIndex,int needWalk,int endIndex) {
        if (totalIndex < 2 || currentIndex < 1 || currentIndex > totalIndex || needWalk < 1 || endIndex > totalIndex) {
            return 0;
        }
        return process(totalIndex,currentIndex,needWalk,endIndex);
    }

    public static int process(int totalIndex, int currentIndex, int needWalk, int endIndex) {
        if (needWalk == 0) {
            return currentIndex == endIndex ? 1 : 0;
        }
        if (currentIndex == 1) {
            return process(totalIndex,2,needWalk - 1,endIndex);
        }
        if (currentIndex == totalIndex) {
            return process(totalIndex,totalIndex - 1,needWalk - 1,endIndex);
        }
        return process(totalIndex,currentIndex + 1,needWalk - 1,endIndex) + process(totalIndex,currentIndex - 1,needWalk - 1,endIndex);
    }

    public static int dpWay(int totalIndex,int currentIndex,int needWalk,int endIndex) {
        if (totalIndex < 2 || currentIndex < 1 || currentIndex > totalIndex || needWalk < 1 || endIndex > totalIndex) {
            return 0;
        }
        int[][] dp = new int[needWalk + 1][totalIndex + 1];
        dp[0][endIndex] = 1;
        for (int i = 1; i <= needWalk; i++) {
            for (int j = 1; j <= totalIndex; j++) {
                if (j == 1) {
                    dp[i][j] = dp[i - 1][2];
                } else if (j == totalIndex) {
                    dp[i][j] = dp[i - 1][totalIndex - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }
            }
        }
        return dp[needWalk][currentIndex];

    }

    public static void main(String[] args) {
        System.out.println(getRobotWalkWaysNumber(4,3,3,2));
        System.out.println(dpWay(4,3,3,2));
    }
}
