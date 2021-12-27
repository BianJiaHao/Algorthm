package com.bianjiahao.algorithm.class11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 打印字符串的所有子序列
 * @author Obtio
 */
public class PrintAllSubSquence {

    public static List<String> getAllSubSquence(String str) {
        if (str == null){
            return null;
        }
        List<String> ans = new ArrayList<>();
        char[] chars = str.toCharArray();
        process1(chars,0,"",ans);
        return ans;
    }

    private static void process1(char[] chars, int index, String path,List<String> ans) {
        if (index == chars.length){
            ans.add(path);
            return;
        }
        process1(chars,index + 1, path,ans);
        String yes = path + String.valueOf(chars[index]);
        process1(chars,index + 1,yes,ans);
    }

    public static List<String> getNoRepeat(String str) {
        if (str == null){
            return null;
        }
        HashSet<String> result = new HashSet<>();
        char[] chars = str.toCharArray();
        process2(chars,0,"",result);
        List<String> ans = new ArrayList<>();
        ans.addAll(result);
        return ans;
    }

    private static void process2(char[] chars, int index, String path, HashSet<String> result) {
        if (index == chars.length){
            result.add(path);
        }
        process2(chars,index + 1,path,result);
        String yes = path + chars[index];
        process2(chars,index + 1,yes,result);
    }

    public static void main(String[] args) {
        List<String> abcd = getAllSubSquence("abcd");
        for (String s : abcd) {
            System.out.println(s);
        }
    }
}
