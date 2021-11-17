package com.bianjiahao.algorithm.class05;

/**
 * 基数排序
 * @author admin
 */
public class RadixSort {

    /**
     * 基数排序
     * @param arr 需要进行排序的数组
     */
    public static void radixSort(int[] arr){
        // 如果数组为空或者数组的长度小于2直接返回
        if (arr == null || arr.length < 2){
            return;
        }
        radisSort(arr,0,arr.length - 1,maxBits(arr));
    }

    /**
     * 求出一个数组中最大数的位数
     * @param arr 传入的数组
     * @return 数组中最大数的位数
     */
    public static int maxBits(int[] arr){
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max,arr[i]);
        }
        int res = 0;
        while (max != 0){
            res++;
            max /= 10;
        }
        return res;
    }

    /**
     * 基数排序过程
     * @param arr 要排序的数组
     * @param l 数组的开始位置
     * @param r 数组的结束位置
     * @param mix 数组中最大数的位数
     */
    public static void radisSort(int[] arr,int l,int r,int mix){
        // 准备一个长度为10的桶
        final int radix = 10;
        // 准备一个help数组
        int[] help = new int[r - l + 1];
        // 开始遍历位数
        int i = 0, j = 0;
        for (int d = 1; d <= mix; d++) {
            int[] count = new int[radix];
            for (i = l;l < r;i++){
                j = getDigit(arr[i], d);
                count[j]++;
            }
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }
            for (i = r; i >= l; i--) {
                j = getDigit(arr[i], d);
                help[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (i = l, j = 0; i <= r; i++, j++) {
                arr[i] = help[j];
            }
        }
    }

    public static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }
}
