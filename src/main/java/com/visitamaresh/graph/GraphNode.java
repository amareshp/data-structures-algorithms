package com.visitamaresh.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by apatta2 on 7/27/16.
 */
public class GraphNode {
    String data;
    List<GraphNode> neighbours = new ArrayList<GraphNode>();

    public GraphNode(String data) {
        this.data = data;
    }

    public void addNeighbour(GraphNode neighbour) {
        this.neighbours.add(neighbour);
    }

    public void addNeighbours(List<GraphNode> neighbours) {
        this.neighbours.addAll(neighbours);
    }

    @Override
    public String toString() {
        return data;
    }

}
