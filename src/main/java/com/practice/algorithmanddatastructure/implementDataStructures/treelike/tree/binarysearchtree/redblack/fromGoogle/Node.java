package com.practice.algorithmanddatastructure.implementDataStructures.treelike.tree.binarysearchtree.redblack.fromGoogle;

public class Node {
    int key;
    boolean color;
    Node left;
    Node right;
    Node parent;

    public Node(int key, boolean color) {
        this.key = key;
        this.color = color;
    }
}
