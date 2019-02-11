package com.va.ds.graph;

import org.junit.Test;

import java.util.*;

public class GraphTest {

    @Test
    public void dfsTest() {
        GraphNode node1 = new GraphNode("acc");
        GraphNode node2 = new GraphNode("acb");
        GraphNode node3 = new GraphNode("aca");

        GraphNode node4 = new GraphNode("abc");
        GraphNode node5 = new GraphNode("abb");
        GraphNode node6 = new GraphNode("aba");

        GraphNode node7 = new GraphNode("aac");
        GraphNode node8 = new GraphNode("aab");
        GraphNode node9 = new GraphNode("aaa");

        GraphNode node10 = new GraphNode("ac");
        GraphNode node11 = new GraphNode("ab");
        GraphNode node12 = new GraphNode("aa");

        GraphNode node13 = new GraphNode("a");

        List<GraphNode> list_ac = new ArrayList<GraphNode>();
        list_ac.add(node3);
        list_ac.add(node2);
        list_ac.add(node1);
        List<GraphNode> list_ab = new ArrayList<GraphNode>();
        list_ab.add(node6);
        list_ab.add(node5);
        list_ab.add(node4);
        List<GraphNode> list_aa = new ArrayList<GraphNode>();
        list_aa.add(node9);
        list_aa.add(node8);
        list_aa.add(node7);
        GraphNode aaNode = new GraphNode("aa");
        aaNode.addNeighbours(list_aa);
        GraphNode abNode = new GraphNode("ab");
        abNode.addNeighbours(list_ab);
        GraphNode acNode = new GraphNode("ac");
        acNode.addNeighbours(list_ac);

        List<GraphNode> list_a = new ArrayList<GraphNode>();
        list_a.add(aaNode);
        list_a.add(abNode);
        list_a.add(acNode);

        GraphNode aNode = new GraphNode("a");
        aNode.addNeighbours(list_a);

        List<GraphNode> graphNodes = new ArrayList<GraphNode>();
        graphNodes.add(aNode);
        Graph graph = new Graph(graphNodes);
        //graph.dfsAll();

        Map<String, Boolean> visitMap = new HashMap<String, Boolean>();
        //graph.dfsRecursive(aNode, visitMap);

        LinkedList<GraphNode> nodeQueue = new LinkedList<GraphNode>();
        graph.bfs(aNode, visitMap, nodeQueue);

    }
}
