package com.bianjiahao.algorithm.class12;

/**
 * 最长公共子序列
 * @author Obito
 */
public class LongestCommonSubsequence {

    public static int dpWay(char[] str1,char[] str2) {
        if (str1 == null || str2 == null) {
            return 0;
        }
        int[][] dp = new int[str1.length][str2.length];
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        for (int i = 1; i < str2.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1],str1[0] == str2[i] ? 1 : 0);
        }
        for (int i = 1; i < str1.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0],str1[i] == str2[0] ? 1 : 0);
        }
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                if (str1[i] == str2[j]){
                    dp[i][j] = Math.max(dp[i][j],dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[str1.length - 1][str2.length - 1];
    }


    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";
        System.out.println(dpWay(str1.toCharArray(),str2.toCharArray()));
    }
}
