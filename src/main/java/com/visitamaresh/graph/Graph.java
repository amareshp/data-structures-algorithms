package com.visitamaresh.graph;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by apatta2 on 7/27/16.
 */
public class Graph {
    private static final Logger logger = LoggerFactory.getLogger( new Exception().getStackTrace()[0].getClassName() );
    Map<Character, Boolean> visitedMap = new HashMap<Character, Boolean>();

    Set<GraphNode> graphNodes;

    public Graph(Set<GraphNode> graphNodes) {
        this.graphNodes = graphNodes;
    }

    public void dfs(GraphNode startNode) {
        Stack<GraphNode> stack = new Stack<GraphNode>();
        visitedMap.put(startNode.data, true);
        logger.info("" + startNode.data);
        stack.push(startNode);

        while ( !stack.isEmpty() ) {
            GraphNode currentNode = stack.peek();

            int unVisitedChildNodes = 0;
            for(GraphNode childNode : currentNode.neighbours) {
                if( visitedMap.get(childNode.data) == null ) {
                    visitedMap.put(childNode.data, Boolean.TRUE);
                    logger.info("" + childNode.data);
                    stack.push(childNode);
                    unVisitedChildNodes++;
                }
            }
            if(unVisitedChildNodes == 0) {
                stack.pop();
            }

        }
    }
}
