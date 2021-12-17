package com.bianjiahao.algorithm.class10;

import java.util.*;

/**
 * K算法
 * @author Obito
 */
public class Kruskal {

    public static class UnionSet {
        public HashMap<Node,Node> fatherMap;
        public HashMap<Node,Integer> sizeMap;

        public UnionSet() {
            fatherMap = new HashMap<Node,Node>();
            sizeMap = new HashMap<Node,Integer>();
        }

        public void makeSet(Collection<Node> nodes){
            fatherMap.clear();
            sizeMap.clear();
            for (Node node : nodes) {
                fatherMap.put(node,node);
                sizeMap.put(node,1);
            }
        }

        public Node findFather(Node node) {
            Stack<Node> path = new Stack<>();
            while (node != fatherMap.get(node)){
                path.add(node);
                node = fatherMap.get(node);
            }
            while (!path.isEmpty()){
                fatherMap.put(path.pop(),node);
            }
            return node;
        }

        public boolean isSameSet(Node a,Node b){
            return findFather(a) == findFather(b);
        }

        public void union(Node a,Node b) {
            if (a == null || b == null){
                return;
            }
            Node fatherOfa = findFather(a);
            Node fatherOfb = findFather(b);
            if (fatherOfa != fatherOfa){
                Integer sizeOfa = sizeMap.get(a);
                Integer sizeOfb = sizeMap.get(b);
                if (sizeOfa <= sizeOfb){
                    fatherMap.put(fatherOfa, fatherOfb);
                    sizeMap.remove(fatherOfa);
                    sizeMap.put(fatherOfb, sizeOfb + sizeOfa);
                }else {
                    fatherMap.put(fatherOfb, fatherOfa);
                    sizeMap.remove(sizeOfb);
                    sizeMap.put(fatherOfa, sizeOfb + sizeOfa);
                }
            }
        }
    }

    public static class MyCompartor implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge> kruskal(Graph graph) {
        UnionSet unionSet = new UnionSet();
        unionSet.makeSet(graph.nodes.values());
        PriorityQueue<Edge> edges = new PriorityQueue<>(new MyCompartor());
        for (Edge edge : graph.edges) {
            edges.add(edge);
        }
        HashSet<Edge> result = new HashSet<>();
        while (!edges.isEmpty()){
            Edge edge = edges.poll();
            if (!unionSet.isSameSet(edge.from,edge.to)){
                result.add(edge);
                unionSet.union(edge.from,edge.to);
            }
        }
        return result;
    }
}
