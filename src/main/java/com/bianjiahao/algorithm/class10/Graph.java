package com.bianjiahao.algorithm.class10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 图类
 * @author Obito
 */
public class Graph {
    public HashMap<Integer,Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
