package com.bianjiahao.algorithm.class01;

import org.springframework.core.annotation.AnnotationUtils;

import java.util.Arrays;

public class InsertSort {

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr,j,j + 1);
            }
        }
    }

    public static void swap(int[] arr,int a,int b) {
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }

    public static void main(String[] args) {
        int maxTime = 500000;
        int maxLength = 1000;
        int max = 1000;
        boolean success = true;
        for (int i = 0; i < maxTime; i++) {
            int[] arr = generateRandomArray(maxLength,max);
            int[] arrCopy = copyArray(arr);
            Arrays.sort(arr);
            insertSort(arrCopy);
            if (!isEqual(arr,arrCopy)) {
                success = false;
            }
        }

        System.out.println(success ? "ok" : "false");


    }

    private static boolean isEqual(int[] arr, int[] arrCopy) {
        if (arr == null || arrCopy == null || arr.length != arrCopy.length) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arrCopy[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        System.arraycopy(arr,0,res,0,arr.length);
        return res;
    }

    private static int[] generateRandomArray(int maxLength, int max) {
        int[] res = new int[(int)((maxLength + 1) * Math.random())];
        for (int i = 0; i < res.length; i++) {
            res[i] = (int) ((max + 1) * Math.random()) - (int)(max * Math.random());
        }
        return res;
    }
}
