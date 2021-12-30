package com.bianjiahao.algorithm.class11;

/**
 * N皇后问题
 * @author Obito
 */
public class Nqueens {

    public static int getNumbers(int n){
        if (n < 1){
            return 0;
        }
        int[] records = new int[n];
        return process(0,records,n);
    }

    private static int process(int index, int[] records, int n) {
        if (index == n){
            return 1;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (isVaild(records,index,i)){
                records[index] = i;
                res += process(index + 1,records,n);
            }
        }
        return res;
    }

    private static boolean isVaild(int[] records, int index, int i) {
        for (int j = 0; j < index; j++) {
            if (records[j] == i || Math.abs(records[j] - i) == Math.abs(j - index)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(getNumbers(5));
    }
}
