package com.visitamaresh.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyHeap1<T extends Comparable> {
    List<T> heap = new ArrayList<>();

    int getParentId(int id) {
        return (id - 1) / 2;
    }

    int getLeftId(int id) {
        return (2 * id) + 1;
    }

    int getRightId(int id) {
        return (2 * id) + 2;
    }

    void fixHeapUp(int id) {
        while (id > 0) {
            T node = this.heap.get(id);
            T parentNode = this.heap.get(getParentId(id));
            if(node.compareTo(parentNode) <= 0) {
                break;
            }
            Collections.swap(this.heap, id, getParentId(id));
            id = getParentId(id);
        }
    }

    void fixHeapDown(int id) {
        while (id < this.heap.size()) {
            if(getLeftId(id) >= this.heap.size() && getRightId(id) >= this.heap.size()) {
                break;
            } else if(getLeftId(id) < this.heap.size() && getRightId(id) < this.heap.size()) {
                T left = this.heap.get(getLeftId(id));
                T right = this.heap.get(getRightId(id));
                int biggerId = (left.compareTo(right) > 0) ? getLeftId(id) : getRightId(id);
                if(this.heap.get(id).compareTo(this.heap.get(biggerId)) > 0) break;
                Collections.swap(this.heap, id, biggerId);
                id = biggerId;
            } else if(getLeftId(id) < this.heap.size() && getRightId(id) >= this.heap.size()) {
                if(this.heap.get(id).compareTo(this.heap.get(getLeftId(id))) >= 0) break;
                Collections.swap(this.heap, id, getLeftId(id));
                id = getLeftId(id);
            } else if(getLeftId(id) >= this.heap.size() && getRightId(id) < this.heap.size()) {
                if(this.heap.get(id).compareTo(getRightId(id)) >= 0) break;
                Collections.swap(this.heap, id, getRightId(id));
                id = getRightId(id);
            }
        }
    }

    void add(T data) {
        int id = this.heap.size();
        this.heap.add(data);
        fixHeapUp(id);
    }

    T poll() throws Exception {
        if(this.heap.size() == 0) throw new Exception("heap is empty");
        T result = this.heap.get(0);
        T last = this.heap.get(this.heap.size() - 1);
        this.heap.set(0, last);
        this.heap.remove(this.heap.size() - 1);
        this.fixHeapDown(0);

        return result;
    }
}
