package com.visitamaresh.ds;

import com.visitamaresh.ctci.ch04.MyGraphNode;

import java.util.*;

public class MyGraphNode2<T> {
    Integer id;
    T data;
    Set<MyGraphNode2> neighbors = new HashSet<>();

    public MyGraphNode2(Integer id, T data) {
        this.id = id;
        this.data = data;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if(!MyGraphNode2.class.isAssignableFrom(o.getClass())) return false;
        MyGraphNode2 node2 = (MyGraphNode2) o;
        return this.id.equals(node2.id);
    }

    @Override
    public String toString() {
        return this.data.toString();
    }

    public void bfs() {
        LinkedList<MyGraphNode2> q = new LinkedList<>();
        Set<MyGraphNode2> toVisit = new HashSet<>();
        q.add(this);
        toVisit.add(this);
        while (!q.isEmpty()) {
            MyGraphNode2 nodeToVisit = q.poll();
            System.out.printf("Node: %s%n", nodeToVisit.data);
            for(MyGraphNode2 neighbor : (Set<MyGraphNode2>) nodeToVisit.neighbors) {
                if(!toVisit.contains(neighbor)) {
                    q.add(neighbor);
                    toVisit.add(neighbor);
                }
            }
        }
    }

    public void dfs(Set<MyGraphNode2> visited) {
        for(MyGraphNode2 neighbor : this.neighbors) {
            if(!visited.contains(neighbor)) {
                neighbor.dfs(visited);
            }
        }
        System.out.printf("Node: %s%n", this.data);
        visited.add(this);
    }

}
