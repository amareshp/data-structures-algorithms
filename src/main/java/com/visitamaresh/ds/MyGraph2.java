package com.visitamaresh.ds;

import java.util.*;
import java.util.stream.Collectors;

public class MyGraph2 {
    public class MyGraphNodeInfo2 {
        Integer inDegree;

        public MyGraphNodeInfo2(Integer inDegree) {
            this.inDegree = inDegree;
        }

        @Override
        public String toString() {
            return String.format("inDegree: %d", this.inDegree);
        }
    }

    public class DistanceInfo {
        Integer distance;
        Integer lastNodeId;
        public DistanceInfo(Integer distance, Integer lastNodeId) {
            this.distance = distance;
            this.lastNodeId = lastNodeId;
        }
        @Override
        public String toString() {
            return String.format("distance: %d, lastNodeId: %d", distance, lastNodeId);
        }
    }

    Map<Integer, MyGraphNode2> nodes = new HashMap<>();

    public void addNode(MyGraphNode2 node) {
        this.nodes.put(node.id, node);
    }

    public void addEdge(Integer id1, Integer id2) {
        MyGraphNode2 node1 = nodes.get(id1);
        node1.neighbors.add(nodes.get(id2));
    }

    public void bfs(MyGraphNode2 node) {
        node.bfs();
    }

    public void dfs(MyGraphNode2 node) {
        node.dfs(new HashSet<>());
    }

    public void topoSort() {
        Map<Integer, MyGraphNodeInfo2> infos = getInfos();
        LinkedList<Integer> q = new LinkedList<>();
        infos.keySet().stream().filter(x -> infos.get(x).inDegree == 0).forEach(x -> q.add(x));
        List<Integer> topoSortedList = new ArrayList<>();
        while (!q.isEmpty()) {
            Integer current = q.poll();
            topoSortedList.add(current);
            for(MyGraphNode2 neighbor : (Set<MyGraphNode2>) this.nodes.get(current).neighbors) {
                Integer newInDegree = infos.get(neighbor.id).inDegree - 1;
                if(newInDegree == 0) q.add(neighbor.id);
                infos.get(neighbor.id).inDegree = newInDegree;
            }
        }
        String sortedNodes = topoSortedList.stream().map(Object::toString).collect(Collectors.joining(", "));
        System.out.printf("topo sorted nodes: %s%n", sortedNodes);
    }

    public List<Integer> shortestPath(Integer startId, Integer endId) {
        Map<Integer, DistanceInfo> dMap = new HashMap<>();
        dMap.put(startId, new DistanceInfo(0, startId));
        LinkedList<Integer> q = new LinkedList<>();
        q.add(startId);
        while (!q.isEmpty()) {
            Integer current = q.poll();
            if(current.equals(endId)) break;
            for(MyGraphNode2 neighbor : (Set<MyGraphNode2>) this.nodes.get(current).neighbors) {
                if(dMap.keySet().contains(neighbor.id)) continue;
                DistanceInfo di = new DistanceInfo(dMap.get(current).distance + 1, current);
                dMap.put(neighbor.id, di);
                q.add(neighbor.id);
            }
        }

        List<Integer> path = new ArrayList<>();
        Integer current = endId;
        while (!current.equals(startId)) {
            path.add(current);
            current = dMap.get(current).lastNodeId;
        }
        path.add(startId);
        Collections.reverse(path);
        String pathStr = path.stream().map(Object::toString).collect(Collectors.joining(", "));
        System.out.printf("Shoartest path from: %d to %d is: %s%n", startId, endId, pathStr);

        return path;
    }

    public Map<Integer, MyGraphNodeInfo2> getInfos() {
        Map<Integer, MyGraphNodeInfo2> infos = new HashMap<>();
        MyGraphNodeInfo2 info2;
        for(MyGraphNode2 node : this.nodes.values()) {
            if(!infos.containsKey(node.id)) {
                info2 = new MyGraphNodeInfo2(0);
                infos.put(node.id, info2);
            }
            for(MyGraphNode2 neighbor : (Set<MyGraphNode2>) node.neighbors) {
                if(infos.containsKey(neighbor.id)) {
                    info2 = infos.get(neighbor.id);
                    info2.inDegree += 1;
                } else {
                    info2 = new MyGraphNodeInfo2(1);
                    infos.put(neighbor.id, info2);
                }
            }
        }
        return infos;
    }

    public static MyGraph2 populateGraph() {
        MyGraph2 graph = new MyGraph2();
        for(int i = 0; i <= 11; i++) {
            graph.addNode(new MyGraphNode2<Integer>(i, i));
        }
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);
        graph.addEdge(5, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 6);
        graph.addEdge(6, 7);
        graph.addEdge(6, 8);
        graph.addEdge(6, 9);
        graph.addEdge(7, 10);
        graph.addEdge(10, 11);
        graph.addEdge(8, 11);

        return graph;
    }

    public static void testBfs() {
        MyGraph2 g = populateGraph();
        g.bfs(g.nodes.get(0));
    }

    public static void testDfs() {
        MyGraph2 g = populateGraph();
        g.dfs(g.nodes.get(0));
    }

    public static void testTopoSort() {
        MyGraph2 g = populateGraph();
        g.topoSort();
    }

    public static void testShortestPath() {
        MyGraph2 g = populateGraph();
        g.shortestPath(0, 6);
    }

}
