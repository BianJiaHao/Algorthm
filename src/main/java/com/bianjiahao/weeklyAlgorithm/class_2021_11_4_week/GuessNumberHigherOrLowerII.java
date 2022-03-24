package com.bianjiahao.weeklyAlgorithm.class_2021_11_4_week;

/**
 * 我们正在玩一个猜数游戏，游戏规则如下：
 * 我从 1 到 n 之间选择一个数字。 15             1 2 3 4 5 6 7 8 9 10 11 *12* 13 14 15
 * 你来猜我选了哪个数字。
 * 如果你猜到正确的数字，就会 赢得游戏 。
 * 如果你猜错了，那么我会告诉你，我选的数字比你的 更大或者更小 ，并且你需要继续猜数。
 * 每当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。如果你花光了钱，就会 输掉游戏 。
 * 给你一个特定的数字 n ，返回能够 确保你获胜 的最小现金数，不管我选择那个数字 。
 * @author admin
 */
public class GuessNumberHigherOrLowerII {

    public static int violenceProcess(int n) {
        return violence(1,n);
    }

    public static int violence(int l,int r) {
        if (l == r) {
            return 0;
        }
        if (l == r - 1) {
            return l;
        }
        int min = Math.min(l + violence(l + 1,r),r + violence(l,r - 1));
        for (int i = l + 1; i < r; i++) {
            min = Math.min(min,i + Math.max(violence(l,i - 1),violence(i + 1,r)));
        }
        return min;
    }

    public static int dpWay(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i < n; i++) {
            dp[i][i + 1] = i;
        }
        for (int i = n - 2; i >= 1; i--) {
            for (int j = i + 2; j <= n; j++) {
                dp[i][j] = Math.min(i + dp[i + 1][j],j + dp[i][j - 1]);
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j],k + Math.max(dp[i][k - 1],dp[k + 1][j]));
                }
            }
        }
        return dp[1][n];
    }


    public static void main(String[] args) {

        long dpStartTime = System.currentTimeMillis();
        int dpAns = dpWay(25);
        long dpEndTime = System.currentTimeMillis();
        System.out.println("动态规划的结果为：" + " " + dpAns +" " + "用时：" + (dpEndTime - dpStartTime) + " " + "ms");

        long violenceStartTime = System.currentTimeMillis();
        int violenceAns = violenceProcess(25);
        long violenceEndTime = System.currentTimeMillis();
        System.out.println("暴力递归的结果为：" + " " + violenceAns +" " + "用时：" + (violenceEndTime - violenceStartTime) + " " + "ms");

    }

}
