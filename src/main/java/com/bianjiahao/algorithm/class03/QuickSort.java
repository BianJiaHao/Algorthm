package com.bianjiahao.algorithm.class03;

/**
 * 快速排序
 * @author admin
 * @date 2021-9-26
 */
public class QuickSort {

    public void swap(int[] arr,int i,int j){
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
    public int partition(int[] arr,int l,int r){
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
            }else {
                index++;
            }
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
    public int[] netherlandsFlag(int[] arr,int l,int r){
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
        while (index < r){
            if (arr[index] < arr[r]){
                swap(arr,++lessEqual,index++);
            }else if (arr[index] == arr[r]){
                index++;
            }else {
                swap(arr,index,--more);
            }
        }
        // 因为最后一个数一直没有动，最后将最后一个数和大于区域的第一位进行交换
        swap(arr,r,more);
        return new int[] {lessEqual + 1,more};
    }
}
