package com.practice.algorithmanddatastructure.implementDataStructures.tree.binarysearchtree;

public class Node {
    int key;
    int height;
    Node left;
    Node right;

    public Node(int key) {
        this.key = key;
        height=1;
    }
}