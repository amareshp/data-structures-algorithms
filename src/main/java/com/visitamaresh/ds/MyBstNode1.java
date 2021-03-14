package com.visitamaresh.ds;

import com.visitamaresh.ctci.ch02.Chapter02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyBstNode1<T extends Comparable<T>> {
    T data;
    MyBstNode1<T> left;
    MyBstNode1<T> right;

    MyBstNode1(T data) {
        this.data = data;
    }

    public void insert(T value) {
        if(value.compareTo(data) < 0) {
            if(left == null) {
                left = new MyBstNode1<>(value);
            } else {
                left.insert(value);
            }
        } else {
            if(right == null) {
                right = new MyBstNode1<>(value);
            } else {
                right.insert(value);
            }
        }
    }

    public void insertIterative(T value) {
        MyBstNode1<T> current = this, previous = this;
        boolean left = true;
        while (current != null) {
            previous = current;
            if(value.compareTo(current.data) < 0) {
                current = current.left;
                left = true;
            } else {
                current = current.right;
                left = false;
            }
        }
        if(left) {
            previous.left = new MyBstNode1<>(value);
        } else {
            previous.right = new MyBstNode1<>(value);
        }
    }

    public MyBstNode1<T> find(T value) {
        if(value == this.data) return this;
        if(value.compareTo(this.data) < 0 && this.left != null) return this.left.find(value);
        if(this.right != null) return this.right.find(value);
        return null;
    }

    public MyBstNode1<T> findIterative(T value) {
        MyBstNode1<T> current = this;
        while (current != null) {
            if(current.data.compareTo(value) == 0) {
                return current;
            } else {
                if(value.compareTo(current.data) < 0) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
        }
        return null;
    }

    public MyBstNode1<T> findParentIterative(T value) {
        if(this.data.compareTo(value) == 0) throw new IllegalArgumentException("Cannon find parent of root.");

        MyBstNode1<T> current = this, previous = this;
        while (current != null) {
            if(current.data.compareTo(value) == 0) {
                return previous;
            } else {
                previous = current;
                if(value.compareTo(current.data) < 0) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
        }
        return null;
    }

    void delete(T value) {
        MyBstNode1<T> parent = this.findParentIterative(value);
        MyBstNode1<T> node = null;
        if(parent == null) return;

        if(value.compareTo(parent.data) < 0) {
            //left node
            node = parent.left;
            //node to be deleted is a leaf node
            if(node.left == null && node.right == null) {
                parent.left = null;
            } else if(node.left == null) {
                parent.right = node.right;
            } else if(node.right == null) {
                parent.left = node.left;
            } else {
                //
            }

        } else {
            //right node
            node = parent.right;
            //node to be deleted is a leaf node
            if(node.left == null && node.right == null) {
                parent.right = null;
            } else if(node.left == null) {
                parent.right = node.right;
            } else if(node.right == null) {
                parent.left = node.left;
            } else {
                //
            }
        }

    }

    @Override
    public String toString() {
        return data.toString();
    }


    public static void testMyBst() {
        MyBstNode1<Integer> root = new MyBstNode1<>(50);
        List<Integer> values = new ArrayList<>();
        int nodeCount = 20;
        Random random = new Random();
        for(int i = 0; i < nodeCount; i++) {
            int value = random.nextInt(101);
            values.add(value);
            root.insert(value);
        }

        Integer findVal = values.get(random.nextInt(nodeCount));
        MyBstNode1<Integer> found = root.find(findVal);
        MyBstNode1<Integer> found2 = root.findIterative(findVal);
        System.out.printf("found node: %s%n", found);
        System.out.printf("found nodeIterative: %s%n", found2);
    }
}
