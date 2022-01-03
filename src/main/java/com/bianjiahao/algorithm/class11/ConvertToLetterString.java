package com.bianjiahao.algorithm.class11;

/**
 * 将对应的数字字符串转化为字母字符串
 * @author Obito
 */
public class ConvertToLetterString {

    /**
     * 暴力递归过程
     * @param str 需要转换的数字字符串
     * @return 有多少种转换方式
     */
    public static int convertNumberToChar(String str) {
        if (str == null){
            return 0;
        }
        return process(str.toCharArray(),0);
    }

    public static int process(char[] chars, int index) {
        if (index == chars.length){
            return 1;
        }
        if (chars[index] == '0'){
            return 0;
        }
        if (chars[index] == '1'){
            int res = process(chars, index + 1);
            if (index + 1 < chars.length){
                res += process(chars,index + 2);
            }
            return res;
        }
        if (chars[index] == '2'){
            int res = process(chars, index + 1);
            if (index + 1 < chars.length && chars[index + 1] >= '0' && chars[index + 1] <= '6'){
                res += process(chars,index + 2);
            }
            return res;
        }
        return process(chars,index + 1);
    }

    /**
     * 动态规划
     * @param str 需要转换的数字字符串
     * @return 有多少种转换方法
     */
    public static int dpWay(String str) {
        if (str == null) {
            return 0;
        }
        int size = str.length();
        int[] dp = new int[size + 1];
        dp[size] = 1;
        char[] chars = str.toCharArray();
        for (int i = size - 1; i >= 0; i--) {
            if (chars[i] == '0') {
                dp[i] = 0;
            }else if (chars[i] == '1') {
                int res = dp[i + 1];
                if (i + 1 < chars.length) {
                    res += dp[i + 2];
                }
                dp[i] = res;
            }else if (chars[i] == '2') {
                int res = dp[i + 1];
                if (i + 1 < chars.length && chars[i + 1] >= '0' && chars[i + 1] <= '6') {
                    res += dp[i + 2];
                }
                dp[i] = res;
            }else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(convertNumberToChar("11111"));
        System.out.println(dpWay("11111"));
    }
}
