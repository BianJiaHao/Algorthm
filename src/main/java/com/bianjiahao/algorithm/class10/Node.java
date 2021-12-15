package com.bianjiahao.algorithm.class10;

import java.util.ArrayList;
import java.util.List;

/**
 * 图节点类
 * @author Obito
 */
public class Node {

    public int value;
    public int in;
    public int out;
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<Node>();
        edges = new ArrayList<Edge>();
    }
}
