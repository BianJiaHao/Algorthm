package com.bianjiahao.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 最长子串
 * @author Obito
 */
public class Topic03LongestSubstring {

    public static int violenceWay(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int slowPointer = 0;
        int fasterPointer = 0;
        int ans = Integer.MIN_VALUE;
        while (slowPointer < chars.length) {
            HashSet<Character> set = new HashSet<>();
            set.add(chars[slowPointer]);
            while (fasterPointer + 1 < chars.length) {
                fasterPointer = fasterPointer + 1;
                if (set.contains(chars[fasterPointer])) {
                    ans = Math.max(ans,set.size());
                    break;
                }else {
                    set.add(chars[fasterPointer]);
                }
            }
            ans = Math.max(ans,set.size());
            slowPointer++;
            fasterPointer = slowPointer;

        }
        return ans;
    }

    public static int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        char[] chars = " ".toCharArray();
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }


}
