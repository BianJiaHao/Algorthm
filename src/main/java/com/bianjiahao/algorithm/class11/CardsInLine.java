package com.bianjiahao.algorithm.class11;

/**
 * 博弈问题
 * @Author Obito
 * @Date 2021/12/28 9:14 下午
 */
public class CardsInLine {

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

    public static void main(String[] args) {
        int[] cards = new int[]{3,20,5,7};
        System.out.println(first(cards,0,cards.length - 1));
        System.out.println(second(cards,0,cards.length - 1));
    }
}
