package com.bianjiahao.algorithm.class01;

/**
 * 用位运算实现加减乘除
 * @author admin
 */
public class BitAddMinusMultiDiv {

    public static int add(int a,int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    public static int minus(int a,int b) {
        return add(a,negNum(b));
    }

    private static int negNum(int num) {
        return add(~num,1);
    }

    public static int multi(int a,int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(res,a);
            }

            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(multi(2,6));
    }
}
