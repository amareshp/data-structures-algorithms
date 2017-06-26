package com.visitamaresh.tree;

import apple.laf.JRSUIUtils;

/**
 * Created by apatta2 on 7/27/16.
 */
public class TreeNode {
    Integer data;
    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode(Integer data) {
        this.data = data;
    }

    public TreeNode find(Integer data) {
        if(this.data == data) {
            return this;
        }
        if(data < this.data && this.leftChild != null) {
            return this.leftChild.find(data);
        } else if(this.rightChild != null) {
            return this.rightChild.find(data);
        }
        return null;
    }

    public void insert(Integer data) {
        if(data < this.data) {
            if(this.leftChild == null) {
                this.leftChild = new TreeNode(data);
            } else {
                this.leftChild.insert(data);
            }
        } else {
            if(this.rightChild == null) {
                this.rightChild = new TreeNode(data);
            } else {
                this.rightChild.insert(data);
            }
        }
    }
}
