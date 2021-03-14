package com.visitamaresh.ctci.ch04;

import java.util.List;
import java.util.Objects;

public class MyBSTreeNode2<T> {
    T data;
    MyBSTreeNode2<T> left;
    MyBSTreeNode2<T> right;

    public MyBSTreeNode2(T val) {
        this.data = val;
    }

    public void addChild(T ele) {

        if(Comparable.class.isAssignableFrom(ele.getClass())) {
            Comparable eleComp = (Comparable) ele;
            Comparable dataComp = (Comparable) data;
            if(eleComp.compareTo(dataComp) <= 0) {
                if(left == null) {
                    left = new MyBSTreeNode2<>(ele);
                } else {
                    left.addChild(ele);
                }
            } else {
                if(right == null) {
                    right = new MyBSTreeNode2<>(ele);
                } else {
                    right.addChild(ele);
                }
            }
        }
    }

    public void inOrderTraversal(List<T> values) {
        if(left != null) left.inOrderTraversal(values);
        values.add(data);
        if(right != null) right.inOrderTraversal(values);
    }

    public void preOrderTraversal(List<T> values) {
        values.add(data);
        if(left != null) left.inOrderTraversal(values);
        if(right != null) right.inOrderTraversal(values);
    }

    public void postOrderTraversal(List<T> values) {
        if(left != null) left.inOrderTraversal(values);
        if(right != null) right.inOrderTraversal(values);
        values.add(data);
    }

}
