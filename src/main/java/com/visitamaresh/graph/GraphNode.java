package com.visitamaresh.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by apatta2 on 7/27/16.
 */
public class GraphNode {
    Character data;
    Set<GraphNode> neighbours = new HashSet<GraphNode>();

    public GraphNode(Character data) {
        this.data = data;
    }

    public void addNeighbour(GraphNode neighbour) {
        this.neighbours.add(neighbour);
    }

}
