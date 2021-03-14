package com.visitamaresh.ctci.ch04;

import java.util.*;

public class MyBTreeNode<T> {
    T data;
    public MyBTreeNode left;
    public MyBTreeNode right;

    public MyBTreeNode(T data) {
        this.data = data;
    }

    public void addLeftChild(T cData) {
        MyBTreeNode node = new MyBTreeNode(cData);
        this.left = node;
    }
    public void addRightChild(T cData) {
        MyBTreeNode node = new MyBTreeNode(cData);
        this.right = node;
    }

    public void traverseInOrder() {
        if(this.left != null) {
            this.left.traverseInOrder();
        }
        System.out.format("%s, ", this.data);
        if(this.right != null) {
            this.right.traverseInOrder();
        }
    }

    public void traversePreOrder() {
        System.out.format("%s, ", this.data);
        if(this.left != null) {
            this.left.traversePreOrder();
        }
        if(this.right != null) {
            this.right.traversePreOrder();
        }
    }

    public void traversePostOrder() {
        if(this.left != null) {
            this.left.traversePostOrder();
        }
        if(this.right != null) {
            this.right.traversePostOrder();
        }
        System.out.format("%s, ", this.data);
    }

    public int countNodes() {
        int nodeCount = countNodes(0);
        System.out.format("Node count: %d%n", nodeCount);
        return nodeCount;
    }

    private int countNodes(int count) {
        if(this.left != null) {
            count = this.left.countNodes(count);
        }
        if(this.right != null) {
            count = this.right.countNodes(count);
        }
        return count + 1;
    }

    public List<List<MyBTreeNode<T>>> getListsOfDepth() {
        List<List<MyBTreeNode<T>>> depthList = new ArrayList<>();
        Queue<List<MyBTreeNode<T>>> queue = new LinkedList<>();
        List<MyBTreeNode<T>> list = new ArrayList<>();
        list.add(this);
        queue.add(list);
        while (!queue.isEmpty()) {
            List<MyBTreeNode<T>> list1 = queue.remove();
            depthList.add(list1);
            List<MyBTreeNode<T>> list2 = new ArrayList<>();
            for(MyBTreeNode<T> node : list1) {
                if(node.left != null) {
                    list2.add(node.left);
                }
                if(node.right != null) {
                    list2.add(node.right);
                }
            }
            if(list2.size() > 0) {
                queue.add(list2);
            }
        }
        return depthList;
    }

    public static <X> MyBTreeNode<X> createFromSortedArray(X[] inputArr) {
        MyBTreeNode<X> root = createFromSortedArray(inputArr, 0, inputArr.length - 1);
        return root;
    }

    private static <X> MyBTreeNode<X> createFromSortedArray(X[] inputArr, int start, int end) {
        if(end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        MyBTreeNode<X> node = new MyBTreeNode<>(inputArr[mid]);
        node.left = createFromSortedArray(inputArr, start, mid - 1);
        node.right = createFromSortedArray(inputArr, mid + 1, end);
        return node;
    }

    public static <X> int getHeight(MyBTreeNode<X> node) {
        if(node == null) return 0;
        int height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        return height;
    }

    public static <X> int getHeightCheckBalance(MyBTreeNode<X> node) {
        if(node == null) return 0;

        int leftHeight = getHeightCheckBalance(node.left);
        if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHeight = getHeightCheckBalance(node.right);
        if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int heightDiff = Math.abs(leftHeight - rightHeight);
        if(heightDiff > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static <X> boolean isBalanced(MyBTreeNode<X> node) {
        if(node == null) return true;
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        if(Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        } else {
            return (isBalanced(node.left) && isBalanced(node.right));
        }
    }

    public static void testBTreeFromSortedArr() {
        Integer input[] = new Integer[20];
        Random random = new Random();
        for(int i = 0; i < 20; i++) {
            input[i] = random.nextInt(1000);
        }
        Arrays.sort(input);
        for(Integer x : input) {
            System.out.format("%s, ", x);
        }
        System.out.println();
        MyBTreeNode<Integer> root = MyBTreeNode.createFromSortedArray(input);
        root.traverseInOrder();
        System.out.println();

        List<List<MyBTreeNode<Integer>>> depthList = root.getListsOfDepth();
        for(int i = 0; i < depthList.size(); i++) {
            System.out.format("Depth: %d: ", i);
            for(MyBTreeNode<Integer> node : depthList.get(i)) {
                System.out.format("%d, ", node.data);
            }
            System.out.println();
        }
    }

}
