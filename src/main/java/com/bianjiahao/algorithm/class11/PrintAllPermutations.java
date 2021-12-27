package com.bianjiahao.algorithm.class11;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印字符串的所有排列
 * @author Obito
 */
public class PrintAllPermutations {

    public static List<String> getAllPermutations(String str) {
        if (str == null){
            return null;
        }
        char[] chars = str.toCharArray();
        List<String> ans = new ArrayList<>();
        process1(chars,0,ans);
        return ans;
    }

    public static void process1(char[] chars, int index, List<String> ans) {
        if (index == chars.length){
            ans.add(String.valueOf(chars));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars,i,index);
            process1(chars,index + 1,ans);
            swap(chars,i,index);
        }
    }

    public static List<String> getNoRepeat(String str) {
        if (str == null){
            return null;
        }
        char[] chars = str.toCharArray();
        List<String> ans = new ArrayList<>();
        process2(chars,0,ans);
        return ans;
    }

    public static void process2(char[] chars, int index, List<String> ans) {
        if (index == chars.length){
            ans.add(String.valueOf(chars));
        }
        boolean[] visit = new boolean[26];
        for (int i = index; i < chars.length; i++) {
            if (!visit[i - 'a']){
                visit[i - 'a'] = true;
                swap(chars,i,index);
                process2(chars,index + 1,ans);
                swap(chars,i,index);
            }
        }
    }

    public static void swap(char[] chars, int i, int index) {
        char tmp = chars[i];
        chars[i] = chars[index];
        chars[index] = tmp;
    }

    public static void main(String[] args) {
        List<String> abcd = getAllPermutations("abcd");
        for (String s : abcd) {
            System.out.println(s);
        }
    }
}
