package com.practice.algorithmanddatastructure.implementDataStructures.treelike.tree.binarysearchtree.redblack.myOwn;

public class Node {
    int key;
    Node parent;
    Node left;
    Node right;
    boolean color;

    public Node(int key, boolean color) {
        this.key = key;
        this.color = color;
    }
}
