package com.bianjiahao.algorithm.class01;

public class TwoPoints {

    public static int existNumber(int[] arr,int num) {
        if (arr == null) {
            return -1;
        }
        if (arr.length < 2 && arr[0] == num) {
            return 0;
        }
        int l = 0;
        int r = arr.length - 1;
        int middle = 0;
        while (l <= r) {
            middle = l +  ((r - l) >> 1);
            if (num > arr[middle]) {
                l = middle + 1;
            }else if (num == arr[middle]) {
                return middle;
            }else {
                r = middle - 1;
            }
        }

        return -1;
    }

    public static int leftIndex(int[] arr,int num) {
        if (arr == null) {
            return -1;
        }
        if (arr.length < 2 && arr[0] < num) {
            return -1;
        }
        int l = 0;
        int r = arr.length - 1;
        int index = -1;
        while (l <= r) {
            int middle = l + ((r -l) >> 1);
            if (arr[middle] >= num) {
                index = middle;
                r = middle - 1;
            }else {
                l = middle + 1;
            }
        }
        return index;
    }

    public static int rightIndex(int[] arr,int num) {
        if (arr == null) {
            return -1;
        }
        if (arr.length < 2 && arr[0] > num) {
            return -1;
        }
        int l = 0;
        int r = arr.length - 1;
        int index = -1;
        while (l <= r) {
            int middle = l + ((r - l) >> 1);
            if (arr[middle] <= num) {
                index = middle;
                l = middle + 1;
            }else {
                r = middle - 1;
            }
        }
        return index;
    }

    public static int localMin(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int l = 0;
        int r = arr.length - 1;
        int middle = 0;
        while (l < r) {
            middle = l + ((r - l) >> 1);
            if (arr[middle] > arr[middle - 1]) {
                r = middle - 1;
            }else if (arr[middle] > arr[middle + 1]) {
                l = middle + 1;
            }else {
                return middle;
            }
        }

        return l;
    }

    public static void main(String[] args) {
       int[] arr = new int[]{1,7,9,12,14};
       //System.out.println(existNumber(arr,7));
       //System.out.println(leftIndex(arr,-5));
        System.out.println(rightIndex(arr,10));
    }
}
