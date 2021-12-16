package com.bianjiahao.algorithm.class10;

import java.util.*;

/**
 * 拓补图排序
 * @author Obito
 */
public class TopologySort {

    public static List<Node> sortedTopology(Graph graph){
        HashMap<Node, Integer> inMap = new HashMap<>(16);
        Queue<Node> zeroInNode = new LinkedList<>();
        List<Node> result = new ArrayList<>();
        for (Node value : graph.nodes.values()) {
            inMap.put(value,value.in);
            if (value.in == 0){
                zeroInNode.add(value);
            }
        }
        while (!zeroInNode.isEmpty()){
            Node cur = zeroInNode.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next,inMap.get(next) - 1);
                if (inMap.get(next) == 0){
                    zeroInNode.add(next);
                }
            }
        }
        return result;
    }
}
