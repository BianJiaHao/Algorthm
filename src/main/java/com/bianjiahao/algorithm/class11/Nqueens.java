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

    public static int getNumbersOptimization(int n){
        if (n < 1){
            return 0;
        }
        // 如果n = 8的话，limit 00……0011111111
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process2(limit,0,0,0);
    }

    private static int process2(int limit, int colLimit, int leftLimit, int rightLimit) {
        if (colLimit == limit){
            return 1;
        }
        int pos = limit & (~(colLimit | rightLimit | leftLimit));
        int mostRightOne = 0;
        int res = 0;
        while (pos != 0){
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;
            res += process2(limit,colLimit | mostRightOne,(leftLimit | mostRightOne) << 1,(rightLimit | mostRightOne) >>> 1);
        }
        return res;
    }

    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        System.out.println(getNumbers(14));
        long time2 = System.currentTimeMillis();
        System.out.println("常规方法用时：" + (time2 - time1) + "ms");

        long time3 = System.currentTimeMillis();
        System.out.println(getNumbersOptimization(14));
        long time4 = System.currentTimeMillis();
        System.out.println("位运算方法用时：" + (time4 - time3) + "ms");
    }
}
