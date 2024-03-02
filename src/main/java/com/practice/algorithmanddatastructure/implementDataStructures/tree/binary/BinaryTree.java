package com.practice.algorithmanddatastructure.implementDataStructures.tree.binary;

public class BinaryTree {
    // Function to create a new BST node
    static Node newNode(int item) {
        Node temp = new Node();
        temp.key = item;
        temp.left = temp.right = null;
        return temp;
    }

    static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println("the value is" + root.key);
            inOrder(root.right);
        }
    }

    //used to create a copy of the tree
    static void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.key + " ");
        preorder(node.left);
        preorder(node.right);
    }

    //used to delete a tree
    static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.key + " ");
    }

    static Node insert(Node node, int key) {
        if (node == null) {
            return newNode(key);
        }
        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        }
        return node;
    }

    Node search(Node root, int key) {
        if (root == null || root.key == key)
            return root;

        if (key < root.key)
            return search(root.left, key);

        return search(root.right, key);
    }


}
