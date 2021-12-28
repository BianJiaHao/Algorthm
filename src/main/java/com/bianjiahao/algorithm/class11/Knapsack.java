package com.bianjiahao.algorithm.class11;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 背包问题
 * @author Obito
 */
public class Knapsack {

    public static int getMaxValue(int[] weight,int[] values,int bag) {
        return process(weight,values,0,bag);
    }

    public static int process(int[] weight, int[] values, int index, int bag) {
        if (bag <= 0){
            return 0;
        }
        if (index == weight.length){
            return 0;
        }
        // 不选择
        int processOfNo = process(weight, values, index + 1, bag);
        // 选择
        int processOfYes = Integer.MIN_VALUE;
        if (bag >= weight[index]){
            processOfYes = values[index] + process(weight, values, index + 1, bag - weight[index]);
        }
        return Math.max(processOfNo,processOfYes);
    }
}
