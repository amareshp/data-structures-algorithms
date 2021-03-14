package com.visitamaresh.ds;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class MyGraph1<T> {
    AtomicInteger maxId = new AtomicInteger(1);
    Map<Integer, MyGraphNode1> nodes;
    public class MyGraphNode1 {
        Integer id;
        T data;
        Set<MyGraphNode1> neighbors;
        public MyGraphNode1(T value) {
            this.id = maxId.getAndIncrement();
            this.data = value;
        }

        @Override
        public int hashCode() {
            return this.id.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if(!(MyGraphNode1.class.isAssignableFrom(o.getClass()))) {
                return false;
            }
            MyGraphNode1 other = (MyGraphNode1) o;
            boolean result = this.id.equals(other.id);
            return result;
        }
    }

    class MyNodeInfo {
        Integer inDegree;
        Integer distance;
        Integer last;
        MyGraphNode1 node;
        public MyNodeInfo(Integer inDegree, MyGraphNode1 node) {
            this.inDegree = inDegree;
            this.distance = distance;
            this.node = node;
        }
    }

    Map<Integer, MyNodeInfo> getNodeInfos() {
        Map<Integer, MyNodeInfo> infos = new HashMap<>();
        for(MyGraphNode1 node : nodes.values()) {
            for(MyGraphNode1 neighbor : node.neighbors) {
                if(infos.containsKey(neighbor.id)) {
                    MyNodeInfo info = infos.get(neighbor);
                    info.inDegree += 1;
                } else {
                    infos.put(neighbor.id, new MyNodeInfo(1, neighbor));
                }
            }
        }
        return infos;
    }

    void addNode(T value) {
        MyGraphNode1 node1 = new MyGraphNode1(value);
        nodes.put(node1.id, node1);
    }

    void addEdge(Integer id1, Integer id2) {
        Set<MyGraphNode1> id1Neighbors = nodes.get(id1).neighbors;
        id1Neighbors.add(nodes.get(id2));
    }
}
