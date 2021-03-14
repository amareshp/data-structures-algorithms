package com.visitamaresh.ctci.ch04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyGraphNode<T> {
    T data;
    List<MyGraphNode<T>> neighbors;

    MyGraphNode(T data) {
        this.data = data;
        neighbors = new ArrayList<MyGraphNode<T>>();
    }

    public void addNeighbor(T data) {
        boolean found = false;
        for(int i = 0; i < this.neighbors.size(); i++) {
            MyGraphNode<T> node = this.neighbors.get(i);
            if(node.data.equals(data)) {
                found = true;
                break;
            }
        }
        if(!found) {
            MyGraphNode<T> newNode = new MyGraphNode<T>(data);
            this.neighbors.add(newNode);
        }
    }

    public MyGraphNode<T> getNeighbor(T data) {
        for(int i = 0; i < this.neighbors.size(); i++) {
            MyGraphNode<T> node = this.neighbors.get(i);
            if(node.data.equals(data)) {
                return node;
            }
        }
        return null;
    }

    public void dfs() {
        List<MyGraphNode<T>> parts = new ArrayList<>();
        parts.add(this);
        dfs(parts);
    }

    private void dfs(List<MyGraphNode<T>> parts) {
        MyGraphNode<T> current = parts.get(parts.size()-1);
        if(current.neighbors.size() == 0) {
            printNodes(parts);
        }
        for(int i = 0; i < current.neighbors.size(); i++) {
            MyGraphNode<T> node = current.neighbors.get(i);
            parts.add(node);
            dfs(parts);
            parts.remove(parts.size() - 1);
        }
    }

    private void bfs() {
        Queue<MyGraphNode<T>> queue = new LinkedList<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            MyGraphNode<T> node = queue.remove();
            System.out.println(node.data);
            for(MyGraphNode<T> qNode : node.neighbors) {
                queue.add(qNode);
            }
        }
    }

    private void printNodes(List<MyGraphNode<T>> parts) {
        for(MyGraphNode<T> node : parts) {
            System.out.format("%s, ", node.data);
        }
        System.out.println();
    }

    public boolean isReachable(T target) {
        Queue<MyGraphNode<T>> queue = new LinkedList<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            MyGraphNode<T> node = queue.remove();
            if(node.data.equals(target)) {
                return true;
            }
            for(MyGraphNode<T> neighbor : node.neighbors) {
                queue.add(neighbor);
            }
        }
        return false;
    }

    public static void testMyGraphNode() {
        /*
            A - B - C - D - E
           / \           \
          X   G - H - I   F
          |    \
          Y     M
        */
        MyGraphNode<String> nodeA = new MyGraphNode<>("A");
        nodeA.addNeighbor("B");
        nodeA.getNeighbor("B").addNeighbor("C");
        nodeA.getNeighbor("B").getNeighbor("C").addNeighbor("D");
        nodeA.getNeighbor("B").getNeighbor("C").getNeighbor("D").addNeighbor("E");
        nodeA.getNeighbor("B").getNeighbor("C").getNeighbor("D").addNeighbor("F");
        nodeA.addNeighbor("G");
        nodeA.getNeighbor("G").addNeighbor("H");
        nodeA.getNeighbor("G").getNeighbor("H").addNeighbor("I");
        nodeA.getNeighbor("G").addNeighbor("M");
        nodeA.addNeighbor("X");
        nodeA.getNeighbor("X").addNeighbor("Y");

        nodeA.dfs();
        nodeA.bfs();

        System.out.format("Z reachable from A: %s%n", nodeA.isReachable("Z"));
        System.out.format("Y reachable from A: %s%n", nodeA.isReachable("Y"));
    }
}
