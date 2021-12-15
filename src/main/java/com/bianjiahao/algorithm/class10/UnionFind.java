package com.bianjiahao.algorithm.class10;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 并查集
 * @author Obito
 */
public class UnionFind {

    public static class Node<V> {
        V value;

        public Node(V v) {
            value = v;
        }
    }

    public static class UnionSet<V> {
        public HashMap<V, Node<V>> nodes;
        public HashMap<Node<V>,Node<V>> parants;
        public HashMap<Node<V>,Integer> sizeMap;

        public UnionSet(List<V> values) {
            for (V value : values) {
                Node<V> node = new Node<V>(value);
                nodes.put(value,node);
                parants.put(node,node);
                sizeMap.put(node,1);
            }
        }

        public Node<V> findFather(Node<V> node) {
            Stack<Node<V>> stack = new Stack<>();
            while (node != parants.get(node)){
                node = parants.get(node);
                stack.add(node);
            }
            while (!stack.isEmpty()){
                parants.put(stack.pop(),node);
            }
            return node;
        }

        public boolean isSameSet(V a, V b){
            if (!nodes.containsKey(a) || !nodes.containsKey(b)){
                return false;
            }
            return findFather(nodes.get(a)) == findFather(nodes.get(b));
        }

        public void union(V a,V b){
            if (!nodes.containsKey(a) || !nodes.containsKey(b)){
                return;
            }
            Node<V> fatherOfa = findFather(nodes.get(a));
            Node<V> fatherOfb = findFather(nodes.get(b));
            if (fatherOfa != fatherOfb){
                Integer sizeOfa = sizeMap.get(fatherOfa);
                Integer sizeOfb = sizeMap.get(fatherOfb);
                Node<V> smallHead = sizeOfa > sizeOfb ? fatherOfb : fatherOfa;
                Node<V> bigHead = smallHead == fatherOfa ? fatherOfb : fatherOfa;
                parants.put(smallHead, bigHead);
                sizeMap.put(bigHead, sizeOfb + sizeOfa);
                sizeMap.remove(smallHead);
            }
        }
    }
}
