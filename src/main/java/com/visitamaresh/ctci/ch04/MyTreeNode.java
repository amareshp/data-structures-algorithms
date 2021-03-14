package com.visitamaresh.ctci.ch04;

import java.util.ArrayList;
import java.util.List;

public class MyTreeNode<T> {
    T data;
    List<MyTreeNode<T>> children = new ArrayList<>();

    public MyTreeNode(T data) {
        this.data = data;
    }

    public void addChild(T cData) {
        MyTreeNode<T> childNode = new MyTreeNode<>(cData);
        this.children.add(childNode);
    }
}
