package com.visitamaresh.tree;

/**
 * Created by apatta2 on 7/27/16.
 */

/**
 * Tree has only one Root node.
 * Each Node has only one parent.
 * Binary tree node can have at most two child nodes.
 * Lower most node is called a leaf node.
 * Binary search tree (BST) - left child is smaller, right child is greater for all nodes.
 */
public class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree(TreeNode root) {
        this.root = root;
    }

    public TreeNode find(Integer data) {
        return this.root.find(data);
    }

    public void insert(Integer data) {
        this.root.insert(data);
    }
}
