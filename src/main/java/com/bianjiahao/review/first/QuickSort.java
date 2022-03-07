package com.bianjiahao.review.first;

import java.util.Random;

public class QuickSort {

    public static void quickSortVersion1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        partitionOfVersion1(arr,0,arr.length - 1);
    }

    public static void partitionOfVersion1(int[] arr,int l,int r) {
        if (l >= r) {
            return;
        }
        int mid = partition(arr,l,r);
        partitionOfVersion1(arr,l,mid - 1);
        partitionOfVersion1(arr,mid + 1,r);
    }

    public static void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int partition(int[] arr,int l,int r) {
        int lessEqual = l - 1;
        int index = l;
        while (index < r) {
            if (arr[index] < arr[r]) {
                swap(arr,index,++lessEqual);
            }
            index++;
        }
        swap(arr,++lessEqual,r);
        return lessEqual;
    }

    public static void quickSortVersion2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        partitionOfVersion2(arr,0,arr.length - 1);
    }

    public static void partitionOfVersion2(int[] arr,int l,int r) {
        if (l >= r) {
            return;
        }
        int[] equalArr = netherLandFlag(arr,l,r);
        partitionOfVersion2(arr,l,equalArr[0] - 1);
        partitionOfVersion2(arr,equalArr[1] + 1,r);
    }

    public static int[] netherLandFlag(int[] arr,int l,int r) {
        if (l > r) {
            return new int[]{-1,-1};
        }
        if (l == r) {
            return new int[]{l,r};
        }
        int lessEqual = l - 1;
        int more = r;
        int index = l;
        while (index < r){
            if (arr[index] < arr[r]) {
                swap(arr,index,++lessEqual);
            }else if (arr[index] == arr[r]) {
                index++;
            }else {
                swap(arr,index,--more);
            }
        }
        swap(arr,more,r);
        return new int[]{lessEqual + 1,more};
    }

    public static void quickSortVersion3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        partitionOfVersion3(arr,0,arr.length - 1);
    }

    public static void partitionOfVersion3(int[] arr,int l,int r) {
        if (l >= r) {
            return;
        }
        swap(arr,l + (int) (Math.random() * (r - l + 1)),r);
        int[] equalArr = netherLandFlag(arr, l, r);
        partitionOfVersion3(arr,l,equalArr[0] - 1);
        partitionOfVersion3(arr,equalArr[1] + 1,r);
    }
}
