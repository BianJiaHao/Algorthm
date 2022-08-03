package com.bianjiahao.algorithm.class01;

public class Yihuo {

    public static int getOddNumber(int[] arr) {
        int ans = 0;
        for (int j : arr) {
            ans ^= j;
        }
        return ans;
    }

    public static void getTwoOddNumber(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        int rightOne = eor & (~eor + 1);
        int newEor = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                newEor ^= arr[i];
            }
        }
        System.out.println(newEor);
        System.out.println(newEor ^ eor);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,2,2,4,4,4,4,3,3,7,7,7,7,9,9,9};
        getTwoOddNumber(arr);
    }
}
