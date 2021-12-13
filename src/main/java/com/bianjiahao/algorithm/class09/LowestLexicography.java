package com.bianjiahao.algorithm.class09;

import java.util.*;

/**
 * 一个字符串数组组合起来的最小字典序
 * @author Obito
 */
public class LowestLexicography {

    public static String getLowest(String[] strs){
        if (strs == null || strs.length == 0){
            return "";
        }
        ArrayList<String> all = new ArrayList<>();
        HashSet<Integer> use = new HashSet<>();
        violenceProcess(strs,use,"",all);
        String lowest = all.get(0);
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).compareTo(lowest) < 0){
                lowest = all.get(i);
            }
        }
        return lowest;
    }

    private static void violenceProcess(String[] strs, HashSet<Integer> use, String path, ArrayList<String> all) {
        if (use.size() == strs.length){
            all.add(path);
        }else {
            for (int i = 0; i < strs.length; i++) {
                if (!use.contains(i)){
                    use.add(i);
                    violenceProcess(strs,use,path + strs[i],all);
                    use.remove(i);
                }
            }
        }
    }

    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return (a + b).compareTo(b + a);
        }
    }

    public static String greedProcess(String[] strings){
        if (strings == null || strings.length == 0){
            return "";
        }
        Arrays.sort(strings,new MyComparator());
        StringBuilder ans = new StringBuilder();
        for (String string : strings) {
            ans.append(ans).append(string);
        }
        return ans.toString();
    }
}
