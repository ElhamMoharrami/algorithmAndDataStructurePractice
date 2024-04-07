package com.practice.algorithmanddatastructure.implementDataStructures.tree.binarysearchtree.avl;

public class AVLTree {
    //search
    public Node search(Node root, int key) {
        if (root.key == key || root == null) {
            return root;
        }
        if (key < root.key) {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    private int height(Node node) {
        return node != null ? node.height : -1;
    }

    //max height of both children+1
    private void updateHeight(Node node) {
        int leftOfNodeHeight = height(node.left);
        int rightOfNodeHeight = height(node.right);
        node.height = Math.max(leftOfNodeHeight, rightOfNodeHeight) + 1;
    }

    //get balance factor

    public int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    //rotate left:returns new root
    public Node rotateLeft(Node root) {
        Node rightOfRoot = root.right;
        Node leftOfRight = root.right.left;

        rightOfRoot.left = root;
        root.right = leftOfRight;

        updateHeight(root);
        updateHeight(rightOfRoot);

        return rightOfRoot;
    }

    //rotate right

    public Node rotateRight(Node root) {
        Node leftOfRoot = root.left;
        Node rightOfLeft = root.left.right;

        leftOfRoot.right = root;
        root.left = rightOfLeft;

        updateHeight(root);
        updateHeight(leftOfRoot);

        return leftOfRoot;
    }

    //insert
    public Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.key) {
            root.left = insert(root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        } else {
            return root;
        }
        //fix after insertion
        int balanceFactor = getBalance(root);
        //right
        if (balanceFactor > 1 && key < root.left.key) {
            return rotateRight(root);
        }
        //left-right
        if (balanceFactor > 1 && key > root.left.key) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }
        //left
        if (balanceFactor < -1 && key > root.right.key) {
            return rotateLeft(root);
        }
        //right-left
        if (balanceFactor < -1 && key < root.right.key) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        updateHeight(root);
        return root;
    }

    //delete
    public Node delete(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null || root.right == null) {
                // replace the current node with its child or null.
                Node temp;

                if (root.left != null) {
                    temp = root.left;
                } else {
                    temp = root.right;
                }
                if (temp == null) {
                    temp = root;
                    root = null;
                } else {
                    root = temp;
                }
            } else {
                //f both the left and right children exist
                Node temp = minValueNode(root.right);
                root.key = temp.key;
                root.right = delete(root.right, temp.key);
            }
        }
        if (root == null) {
            return root;
        }

        updateHeight(root);

        int balanceFactor = getBalance(root);

        if (balanceFactor > 1 && getBalance(root.left) >= 0) {
            return rotateRight(root);
        }

        if (balanceFactor > 1 && getBalance(root.left) < 0) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }

        if (balanceFactor < -1 && getBalance(root.right) <= 0) {
            return rotateLeft(root);
        }

        if (balanceFactor < -1 && getBalance(root.right) > 0) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }

    //find the minimum value node in the right subtree
    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
}
