package com.bianjiahao.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 三树之和
 * @author Obito
 */
public class Topic15SumOfThreeNumber {

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return null;
        }
        List<List<Integer>> help = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(nums[0] + nums[1]);
        first.add(nums[0]);
        first.add(nums[1]);
        help.add(first);
        for (int i = 2; i < nums.length; i++) {
            for (List<Integer> integers : help) {
                if (nums[i] + integers.get(0) == 0) {
                    List<Integer> oneAns = new ArrayList<>();
                    oneAns.add(integers.get(1));
                    oneAns.add(integers.get(2));
                    oneAns.add(nums[i]);
                    ans.add(oneAns);
                }
            }
            List<Integer> oneHelp = new ArrayList<>();
            oneHelp.add(help.get(help.size() - 1).get(2) + nums[i]);
            oneHelp.add(help.get(help.size() - 1).get(2));
            oneHelp.add(nums[i]);
            help.add(oneHelp);
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
