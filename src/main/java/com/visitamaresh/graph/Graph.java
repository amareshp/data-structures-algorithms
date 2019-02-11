package com.visitamaresh.graph;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by apatta2 on 7/27/16.
 */
public class Graph {
    private static final Logger logger = LoggerFactory.getLogger( new Exception().getStackTrace()[0].getClassName() );
    Map<String, Boolean> visitedMap = new HashMap<String, Boolean>();

    List<GraphNode> graphNodes;

    public Graph(List<GraphNode> graphNodes) {
        this.graphNodes = graphNodes;
    }

    public void dfsAll() {
        for(GraphNode node : graphNodes) {
            dfs(node);
        }
    }

    public void dfs(GraphNode startNode) {
        Stack<GraphNode> stack = new Stack<GraphNode>();
        visitedMap.put(startNode.data, true);
        logger.info("pushing to stack: " + startNode.data);
        stack.push(startNode);

        while ( !stack.isEmpty() ) {
            GraphNode currentNode = stack.peek();

            int unVisitedChildNodes = 0;
            for(GraphNode childNode : currentNode.neighbours) {
                if( visitedMap.get(childNode.data) == null ) {
                    visitedMap.put(childNode.data, Boolean.TRUE);
                    logger.info("pushing to stack: " + childNode.data);
                    stack.push(childNode);
                    unVisitedChildNodes++;
                }
            }
            if(unVisitedChildNodes == 0) {
                GraphNode node = stack.pop();
                System.out.println(node.data);
            }

        }
    }

    public void dfsRecursive(GraphNode startNode, Map<String, Boolean> visitedMap) {
        for(GraphNode node : startNode.neighbours) {
            if(visitedMap.get(node.data) == null) {
                visitedMap.put(node.data, Boolean.TRUE);
                dfsRecursive(node, visitedMap);
            }
        }
        System.out.println(startNode);
    }

    public void bfs(GraphNode startNode, Map<String, Boolean> visitedMap, LinkedList<GraphNode> nodeQueue) {
        nodeQueue.offer(startNode);

        while ( !nodeQueue.isEmpty() ) {
            GraphNode node = nodeQueue.poll();
            if(visitedMap.get(node.data) == null) {
                System.out.println(node);
                visitedMap.put(node.data, Boolean.TRUE);
                for(GraphNode childNode : node.neighbours) {
                    nodeQueue.offer(childNode);
                }
            }

        }
    }
}
