package com.bianjiahao.algorithm.class10;

/**
 * 图边类
 * @author Obito
 */
public class Edge {
    public int weight;
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
