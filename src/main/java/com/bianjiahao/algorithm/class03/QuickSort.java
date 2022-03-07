package com.bianjiahao.algorithm.class03;

/**
 * 快速排序
 * @author Obito
 * @date 2021-9-26
 */
public class QuickSort {

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 快速排序引出问题
     * @param arr 需要进行排序的数组
     * @param l 左下标
     * @param r 右下标
     * @return <= 区域的右边界
     */
    public static int partition(int[] arr, int l, int r){
        // 如果数组左边界 > 右边界 说明无法进行排序
        if (l > r){
            return -1;
        }
        // 相等说明数组只有一个数，无需进行排序
        if (l == r){
            return l;
        }
        // 定义 <= 区域的右边界的下标
        int lessEqual = l -1;
        // 定义开始遍历的下标
        int index = l;
        // 开始遍历数组
        while (index < r){
            // 如果数 <= 数组的最后一个数，将该数和小于区域的右一位进行交换并且将小于区域右扩一位，如果数 > 数组的最后一个元素直接跳过
            if (arr[index] <= arr[r]){
                swap(arr,index,++lessEqual);
            }
            index++;
        }
        // 因为最后一个数一直没有动，最后将最后一个数和小于区域的右一位进行交换，并且将小于区域右扩一位
        swap(arr,++lessEqual,r);
        return lessEqual;
    }

    /**
     * 荷兰国旗问题
     * @param arr 需要进行排序的数组
     * @param l 数组的左下标
     * @param r 数组的右下标
     * @return 相等的数组的区间
     */
    public static int[] netherlandsFlag(int[] arr, int l, int r){
        // 如果数组左边界 > 右边界 说明无法进行排序
        if (l > r){
            return new int[] {-1,-1};
        }
        // 相等说明数组只有一个数，无需进行排序
        if (l == r){
            return new int[] {l,r};
        }
        // 定义 < 区域右边界
        int lessEqual = l - 1;
        // 定义 > 区域左边界
        int more = r;
        // 定义开始遍历的下标
        int index = l;
        while (index < more){
            if (arr[index] < arr[r]){
                swap(arr,index++,++lessEqual);
            }else if (arr[index] == arr[r]){
                index++;
            }else {
                swap(arr,index,--more);
            }
        }
        // 因为最后一个数一直没有动，最后将最后一个数和大于区域的第一位进行交换
        swap(arr,more,r);
        return new int[] {lessEqual + 1,more};
    }

    /**
     * 快速排序1.0
     * @param arr 需要进行排序的数组
     */
    public static void quickSortVersion1(int[] arr){
        int noNeedSortLength = 2;
        if (arr == null || arr.length < noNeedSortLength){
            return;
        }
        partitionOfQuickSortVersion1(arr,0,arr.length - 1);
    }

    /**
     * 快排1.0递归
     * @param arr 需要进行排序的数组
     * @param l 数组的左下标
     * @param r 数组的右下标
     */
    public static void partitionOfQuickSortVersion1(int[] arr, int l, int r){
        if (l >= r){
            return;
        }
        int middle = partition(arr, l, r);
        partitionOfQuickSortVersion1(arr,l,middle - 1);
        partitionOfQuickSortVersion1(arr,middle + 1,r);
    }

    /**
     * 快速排序2.0
     * @param arr 需要进行排序的数组
     */
    public static void quickSortVersion2(int[] arr){
        int noNeedSortLength = 2;
        if (arr == null || arr.length < noNeedSortLength){
            return;
        }
        partitionOfQuickSortVersion2(arr,0,arr.length - 1);
    }

    /**
     * 快排2.0递归
     * @param arr 需要进行排序的数组
     * @param l 数组的左下标
     * @param r 数组的右下标
     */
    public static void partitionOfQuickSortVersion2(int[] arr, int l, int r){
        if (l >= r){
            return;
        }
        int[] equalArr = netherlandsFlag(arr, l, r);
        partitionOfQuickSortVersion2(arr,l,equalArr[0] - 1);
        partitionOfQuickSortVersion2(arr,equalArr[1] +1,r);
    }

    /**
     * 快速排序3.0
     * @param arr 需要进行排序的数组
     */
    public static void quickSortVersion3(int[] arr){
        int noNeedSortLength = 2;
        if (arr == null || arr.length < noNeedSortLength){
            return;
        }
        partitionOfQuickSortVersion3(arr,0,arr.length - 1);
    }

    /**
     * 快排3.0递归
     * @param arr 需要进行排序的数组
     * @param l 数组的左下标
     * @param r 数组的右下标
     */
    public static void partitionOfQuickSortVersion3(int[] arr, int l, int r){
        if (l >= r){
            return;
        }
        swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
        int[] equalArr = netherlandsFlag(arr, l, r);
        partitionOfQuickSortVersion3(arr,l,equalArr[0] - 1);
        partitionOfQuickSortVersion3(arr,equalArr[1] +1,r);
    }

    /**
     * 生成一个随机数组
     * @param maxSize 最大长度
     * @param maxValue 最大值
     * @return 一个随机数组
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    /**
     * 复制一个数组
     * @param arr 原数组
     * @return 复制的数组
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        System.arraycopy(arr, 0, res, 0, arr.length);
        return res;
    }

    /**
     * 判断两个数组是否相等
     * @param arr1 第一个数组
     * @param arr2 第二个数组
     * @return 是否相等
     */
    public static boolean arrIsEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return true;
        }
        if (arr1 == null) {
            return false;
        }
        if (arr1.length != arr2.length) {
            return true;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int testTime = 500000;
//        int maxSize = 100;
//        int maxValue = 100;
//        boolean succeed = true;
//        for (int i = 0; i < testTime; i++) {
//            int[] arr1 = generateRandomArray(maxSize, maxValue);
//            int[] arr2 = copyArray(arr1);
//            int[] arr3 = copyArray(arr1);
//            quickSortVersion1(arr1);
//            quickSortVersion2(arr2);
//            quickSortVersion3(arr3);
//            if (arrIsEqual(arr1, arr2) || arrIsEqual(arr2, arr3)) {
//                succeed = false;
//                break;
//            }
//        }
//        System.out.println(succeed ? "Nice!" : "Oops!");


        try {

            Class<?> aClass = QuickSort.class.getClassLoader().loadClass("com.bianjiahao.algorithm.class04.Heap01");
            System.out.println(aClass.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
