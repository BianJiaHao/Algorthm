package com.bianjiahao.algorithm.class05;


import java.util.HashMap;

/**
 * 前缀数
 * @author BianJiaHao
 */
public class TrieTree {

    /**
     * 使用数组的方式实现
     */
    public static class Node1{
        public int pass;
        public int end;
        public Node1[] nexts;

        public Node1() {
            pass = 0;
            end = 0;
            nexts = new Node1[26];
        }
    }

    public static class Trie1{
        // 定义root节点
        private Node1 root;
        // 定义构造器
        public Trie1() {
            root = new Node1();
        }
        // 插入字符串
        public void insert(String word){
            // 如果传入的字符串为空，直接返回
            if (word == null){
                return;
            }
            // 将字符串转为字符数组
            char[] chars = word.toCharArray();
            Node1 node  = root;
            node.pass++;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.nexts[index] == null){
                    node.nexts[index] = new Node1();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }
        // 删除字符串
        public void delete(String word){
            if (search(word) != 0){
                char[] chars = word.toCharArray();
                Node1 node = root;
                int index = 0;
                for (int i = 0; i < chars.length; i++) {
                    index = chars[i] - 'a';
                    if (--node.nexts[index].pass == 0){
                        return;
                    }
                    node = node.nexts[index];
                }
            }
        }
        // 查询字符串在前缀数中加入过几次
        public int search(String word){
            if (word == null){
                return 0;
            }
            char[] chars = word.toCharArray();
            Node1 node = root;
            int index = 0;
            for (char aChar : chars) {
                index = aChar - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }
        // 查询以pre为前缀的字符串有几个
        public int prefixNumber(String pre){
            if (pre == null){
                return 0;
            }
            char[] chars = pre.toCharArray();
            Node1 node = root;
            int index = 0;
            for (char aChar : chars) {
                index = aChar - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }
    }

    /**
     * 使用HashMap实现
     */
    public static class Node2{
        public int pass;
        public int end;
        public HashMap<Integer, Node2> nexts;

        public Node2() {
            pass = 0;
            end = 0;
            nexts = new HashMap<>();
        }
    }

    public static class Tire2{
        private Node2 root;

        public Tire2() {
            root = new Node2();
        }

        public void insert(String word){
            if (word == null){
                return;
            }
            char[] chars = word.toCharArray();
            int index = 0;
            Node2 node = root;
            node.pass++;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i];
                if (!node.nexts.containsKey(index)){
                    node.nexts.put(index,new Node2());
                }
                node = node.nexts.get(index);
                node.pass++;
            }
            node.end++;
        }

        public void delete(String word){
            if (search(word) != 0){
                char[] chars = word.toCharArray();
                int index = 0;
                Node2 node = root;
                node.pass--;
                for (int i = 0; i < chars.length; i++) {
                    index = chars[i];
                    if (--node.nexts.get(index).pass == 0){
                        node.nexts.remove(index);
                        return;
                    }
                    node = node.nexts.get(index);
                }
                node.end--;
            }
        }

        public int search(String word){
            if (word == null){
                return 0;
            }
            char[] chars = word.toCharArray();
            int index = 0;
            Node2 node = root;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i];
                if (!node.nexts.containsKey(index)){
                    return 0;
                }
                node = node.nexts.get(index);
            }
            return node.end;
        }

        public int prefixNumber(String pre){
            if (pre == null){
                return 0;
            }
            char[] chars = pre.toCharArray();
            int index = 0;
            Node2 node = root;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i];
                if (!node.nexts.containsKey(index)){
                    return 0;
                }
                node = node.nexts.get(index);
            }
            return node.pass;
        }
    }
}
