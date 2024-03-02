package com.practice.algorithmanddatastructure.implementDataStructures.tree.binarysearchtree;

public class AVLTree {
    Node root;

    Node search(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        }
        if (key < root.key) {
            return search(root.left, key);
        }
        return search(root.right, key);
    }

    public int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    int balanceFactor(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    public int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    public Node leftRotate(Node root) {
        Node rightChildOfRoot = root.right;
        Node leftChildOfRightChildOfRoot = rightChildOfRoot.left;

        rightChildOfRoot.left = root;
        root.right = leftChildOfRightChildOfRoot;

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        rightChildOfRoot.height = Math.max(height(rightChildOfRoot.left), height(rightChildOfRoot.right)) + 1;

        return rightChildOfRoot;
    }

    public Node rightRotate(Node root) {
        Node leftChildOfRoot = root.left;
        Node rightChildOfLeftChildOfRoot = leftChildOfRoot.right;

        leftChildOfRoot.right = root;
        root.left = rightChildOfLeftChildOfRoot;

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        leftChildOfRoot.height = Math.max(height(leftChildOfRoot.left), height(leftChildOfRoot.right)) + 1;

        return leftChildOfRoot;
    }

    public Node insert(Node node, int key) {
        //if there is no root
        if (node == null) {
            return new Node(key);
        }
        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            return node;
        }
        //height of a node is 1 plus the maximum height of its children.
        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balanceFactor = balanceFactor(node);

        if (balanceFactor > 1 && key < node.left.key) {
            return rightRotate(node);
        }

        if (balanceFactor < -1 && key > node.right.key) {
            return leftRotate(node);
        }

        if (balanceFactor > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balanceFactor < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }
}
