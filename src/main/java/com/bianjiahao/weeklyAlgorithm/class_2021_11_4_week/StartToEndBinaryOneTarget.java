package com.bianjiahao.weeklyAlgorithm.class_2021_11_4_week;

/**
 * 来自真实面试，同学给我的问题
 * 限制：0 <= start <= end，0 <= target <= 64
 * [start,end]范围上的数字，有多少数字二进制中1的个数等于target
 * @author admin
 */
public class StartToEndBinaryOneTarget {

    public static long violence(long start,long end,int target) {
        if (start < 0 || end < 0 || end < start || target < 0) {
            return -1;
        }
        if (start == 0 && end == 0) {
            return target == 0 ? 1 : 0;
        }
        int firstOneHeight = 62;
        while ((end & (1L << firstOneHeight)) == 0) {
            firstOneHeight--;
        }
        if (start == 0) {
            return violenceProcess(firstOneHeight,0,target,end);
        }else {
            start--;
            int firstOneHeightForStart = 62;
            while (firstOneHeightForStart >= 0 && (start & (1L << firstOneHeightForStart)) == 0) {
                firstOneHeightForStart--;
            }
            return violenceProcess(firstOneHeight,0,target,end) - violenceProcess(firstOneHeightForStart,0,target,start);
        }
    }

    public static long violenceProcess(int index,int less,int rest,long num) {
        if (rest > index + 1) {
            return 0;
        }
        if (rest == 0) {
            return 1L;
        }
        if (less == 1) {
            if (rest == index + 1) {
                return 1L;
            }else {
                return violenceProcess(index - 1,1,rest - 1,num) + violenceProcess(index - 1,1,rest,num);
            }
        }else {
            if (rest == index + 1) {
                return (num & (1L << index)) == 0 ? 0 : violenceProcess(index - 1,0,rest - 1,num);
            }else {
                if ((num & (1L <<index)) == 0) {
                    return violenceProcess(index - 1,0,rest,num);
                }else {
                    return violenceProcess(index - 1,0,rest - 1,num) + violenceProcess(index - 1,1,rest,num);
                }
            }
        }
    }
}
