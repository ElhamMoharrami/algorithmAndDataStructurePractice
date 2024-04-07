package com.practice.algorithmanddatastructure.implementDataStructures.tree.binarysearchtree.redblack.myOwn;

public class RedBlack {
    private static final boolean BLACK = false;
    private static final boolean RED = true;
    Node root;

    //________________Helpers___________________

    private void rotateLeft(Node node) {
        Node parent = node.parent;
        Node rightChild = node.right;

        node.right = rightChild.left;
        if (rightChild.left != null) {
            rightChild.left.parent = node;
        }
        node.parent = rightChild;
        rightChild.left = node;

        replaceParentChild(parent, node, rightChild);
    }

    private void rotateRight(Node node) {
        Node parent = node.parent;
        Node leftChild = node.left;

        node.left = leftChild.right;
        if (leftChild.right != null) {
            leftChild.right.parent = node;
        }

        node.parent = leftChild;
        leftChild.right = node;

        replaceParentChild(parent, node, leftChild);
    }

    private void replaceParentChild(Node parent, Node oldChild, Node newChild) {
        if (parent == null) {
            root = newChild;
        } else if (parent.left == oldChild) {
            parent.left = newChild;
        } else if (parent.right == oldChild) {
            parent.right = newChild;
        } else {
            throw new IllegalStateException("Node is not a child of its parent");
        }

        if (newChild != null) {
            newChild.parent = parent;
        }
    }

    //________________SEARCH_____________________
    private Node search(int key) {
        Node node = root;
        while (node != null) {
            if (node.key == key) {
                return node;
            }
            if (key < node.key) {
                node = node.left;
            }
            if (key > node.key) {
                node = node.right;
            }
        }
        return null;
    }

}
