package com.visitamaresh.ctci.ch04;

import java.util.ArrayList;
import java.util.List;

public class MyTrieNode<T> {
    T data;
    boolean isEnd;
    List<MyTrieNode<T>> children;

    MyTrieNode(T data) {
        this.data = data;
        this.children = new ArrayList<MyTrieNode<T>>();
    }

    public void insert(T[] input) {
        MyTrieNode<T> current = this;
        for(int i = 0; i < input.length; i++) {
            T value = input[i];
            boolean found = false;
            for(int j = 0; j < current.children.size(); j++) {
                MyTrieNode<T> node = current.children.get(j);
                if(node.data.equals(value)) {
                    current = node;
                    found = true;
                    break;
                }
            }
            if(!found) {
                MyTrieNode<T> newNode = new MyTrieNode<T>(value);
                current.children.add(newNode);
                current = newNode;
            }

        }
        current.isEnd = true;
    }

    public boolean delete(T[] input) {
        MyTrieNode<T> current = this;
        for(int i = 0; i < input.length; i++) {
            T value = input[i];
            boolean found = false;
            for(int j = 0; j < current.children.size(); j++) {
                MyTrieNode<T> node = current.children.get(j);
                if(node.data.equals(value)) {
                    found = true;
                    current = node;
                    break;
                }
            }
            if(!found) {
                return false;
            }
        }
        current.isEnd = false;
        return true;
    }

    public void print() {
        List<MyTrieNode<T>> part = new ArrayList<>();
        print(this, part);
    }

    private void print(MyTrieNode<T> current, List<MyTrieNode<T>> part) {
        for(int i = 0; i < current.children.size(); i++) {
            MyTrieNode<T> node = current.children.get(i);
            part.add(node);
            if(node.isEnd) {
                printNodes(part);
            }
            print(node, part);
            part.remove(part.size() - 1);
        }
    }

    private void printNodes(List<MyTrieNode<T>> list) {
        for(MyTrieNode<T> node : list) {
            System.out.format("%s, ", node.data);
        }
        System.out.println();
    }

    public static void testMyTrieNode() {
        MyTrieNode<Character> dictionary = new MyTrieNode<>(null);
        String word = "ant";
        Character[] charObjArr = word.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        dictionary.insert(charObjArr);
        word = "art";
        charObjArr = word.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        dictionary.insert(charObjArr);
        word = "artist";
        charObjArr = word.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        dictionary.insert(charObjArr);
        word = "antibody";
        charObjArr = word.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        dictionary.insert(charObjArr);
        word = "antigen";
        charObjArr = word.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        dictionary.insert(charObjArr);
        word = "antibiotics";
        charObjArr = word.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        dictionary.insert(charObjArr);
        word = "article";
        charObjArr = word.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        dictionary.insert(charObjArr);
        word = "artery";
        charObjArr = word.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        dictionary.insert(charObjArr);

        dictionary.print();

        word = "art";
        charObjArr = word.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        dictionary.delete(charObjArr);

        dictionary.print();
    }

}
