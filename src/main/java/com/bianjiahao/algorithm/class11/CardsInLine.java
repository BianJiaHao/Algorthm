package com.bianjiahao.algorithm.class11;

/**
 * 博弈问题
 * @Author Obito
 * @Date 2021/12/28 9:14 下午
 */
public class CardsInLine {

    /**
     * 暴力递归过程
     * @param arr 卡牌的集合
     * @return 获胜者的分数
     */
    public static int whoIsWinner (int[] arr) {
        if (arr == null){
            return 0;
        }
        return Math.max(first(arr,0,arr.length - 1),second(arr,0,arr.length - 1));
    }

    public static int second(int[] arr, int L, int R) {
        if (L == R){
            return 0;
        }
        return Math.min(first(arr,L + 1,R),first(arr,L,R - 1));
    }

    public static int first(int[] arr, int L, int R) {
        if (L == R){
            return arr[L];
        }
        return Math.max(arr[L] + second(arr,L + 1,R),arr[R] + second(arr,L,R - 1));
    }

    /**
     * 动态规划
     * @param arr 卡牌的集合
     * @return 获胜者的分数
     */
    public static int dpWay(int[] arr) {
        if (arr == null) {
            return 0;
        }
        int length = arr.length;
        int[][] first = new int[length][length];
        int[][] second = new int[length][length];
        for (int i = 0; i < length; i++) {
            first[i][i] = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                first[j][i] = Math.max(arr[j] + second[j + 1][i],arr[i] + second[j][i - 1]);
                second[j][i] = Math.min(first[j + 1][i],first[j][i - 1]);
            }
        }
        return Math.max(first[0][length - 1],second[0][length - 1]);
    }

    public static void main(String[] args) {
        int[] cards = new int[]{3,20,5,7};
        System.out.println(first(cards,0,cards.length - 1));
        System.out.println(second(cards,0,cards.length - 1));
        System.out.println(whoIsWinner(cards));
        System.out.println(dpWay(cards));
    }
}
