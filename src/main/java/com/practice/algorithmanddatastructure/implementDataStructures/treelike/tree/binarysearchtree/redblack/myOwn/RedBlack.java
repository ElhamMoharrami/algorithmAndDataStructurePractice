package com.practice.algorithmanddatastructure.implementDataStructures.treelike.tree.binarysearchtree.redblack.myOwn;

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

    private Node getUncle(Node parent) {
        Node grandParent = parent.parent;
        if (grandParent.left == parent) {
            return grandParent.right;
        } else if (grandParent.right == parent) {
            return grandParent.left;
        } else {
            throw new IllegalStateException("Parent is not a child of its grandparent");
        }
    }

    private static class NilNode extends Node {
        private NilNode() {
            super(0, BLACK);
        }
    }

    private Node findMinimum(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private Node getSibling(Node node) {
        Node parent = node.parent;
        if (node == parent.left) {
            return parent.right;
        } else if (node == parent.right) {
            return parent.left;
        } else {
            throw new IllegalStateException("Parent is not a child of its grandparent");
        }
    }

    private boolean isBlack(Node node) {
        return node == null || node.color == BLACK;
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

    //________________Insert_____________________

    public void insert(int key) {
        Node node = root;
        Node parent = null;

        while (node != null) {
            parent = node;
            if (key < node.key) {
                node = node.left;
            } else if (key > node.key) {
                node = node.right;
            } else {
                throw new IllegalArgumentException("BST already contains a node with key " + key);
            }
        }

        Node newNode = new Node(key, RED);
        if (parent == null) {
            root = newNode;
        } else if (key < parent.key) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        newNode.parent = parent;
        fixRedBlackPropertiesAfterInsert(newNode);
    }

    private void fixRedBlackPropertiesAfterInsert(Node node) {
        Node parent = node.parent;
        Node grandParent = parent.parent;
        Node uncle = getUncle(parent);

        //case 1: new node is the root
        if (parent == null) {
            node.color = BLACK;
            return;
        }

        if (parent.color == BLACK) {
            return;
        }

        //case 2:we enforced black root so case 2 never happens

        //case 3:parent and uncle nodes are red
        if (uncle != null && uncle.color == RED) {
            parent.color = BLACK;
            uncle.color = BLACK;
            grandParent.color = RED;
            fixRedBlackPropertiesAfterInsert(grandParent);
        }

        //case 4
        //parent is left child
        else if (parent == grandParent.left) {
            //for inner grand-child handling
            if (node == parent.right) {
                rotateLeft(parent);
                parent = node;
            }
            //for outer-grandchild handling
            rotateRight(grandParent);
            parent.color = BLACK;
            grandParent.color = RED;
        }
        //parent is right child
        else {
            //for inner grand-child handling
            if (node == parent.left) {
                rotateRight(parent);
                parent = node;
            }
            //for outer-grandchild handling
            rotateLeft(grandParent);
            parent.color = BLACK;
            grandParent.color = RED;
        }
    }
//________________Delete_____________________

    public void delete(int key) {
        Node node = root;

        while (node != null && node.key != key) {
            if (key < node.key) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        if (node == null) {
            return;
        }

        //the node at which we're going to start to fix the R-B
        Node movedUpNode;
        boolean deletedNodeColor;

        //node has zero or one child
        if (node.left == null || node.right == null) {
            movedUpNode = deleteWithZeroOrOneChild(node);
            deletedNodeColor = node.color;
        }

        //node has two children
        else {
            //find min of right subtree of the node
            Node inOrderSuccessor = findMinimum(node.right);
            node.key = inOrderSuccessor.key;
            movedUpNode = deleteWithZeroOrOneChild(inOrderSuccessor);
            deletedNodeColor = inOrderSuccessor.color;
        }

        if (deletedNodeColor == BLACK) {
            fixRedBlackPropertiesAfterDelete(movedUpNode);
        }
    }


    private Node deleteWithZeroOrOneChild(Node node) {
        //only one left child---replace the node with the left child
        if (node.left != null) {
            replaceParentChild(node.parent, node, node.left);
            return node.left;
        }

        //only one right child---replace the node with right child
        if (node.right != null) {
            replaceParentChild(node.parent, node, node.right);
            return node.right;
        }

        //has no child
        //node is red--------just remove it
        //node is black--------replace by a Nil
        else {
            Node newChild = node.color == BLACK ? new NilNode() : null;
            replaceParentChild(node.parent, node, newChild);
            return newChild;
        }
    }

    private void fixRedBlackPropertiesAfterDelete(Node node) {
        //case 1:node is root
        if (node == root) {
            return;
        }
        Node sibling = getSibling(node);

        //case 2: red sibling
        if (sibling.color == RED) {
            handleRedSibling(node, sibling);
            sibling = getSibling(node);//// Get new sibling for fall-through to cases 3-6
        }

        //case 3+4:black sibling with two black children
        if (isBlack(sibling.left) && isBlack(sibling.right)) {
            sibling.color = RED;
            //case 3
            if (node.parent.color == RED) {
                node.parent.color = BLACK;
            }
            //case 4
            else {
                fixRedBlackPropertiesAfterDelete(node.parent);
            }
        }

        //case 5+6
        else {
            handleBlackSiblingWithAtLeastOneRedChild(node, sibling);
        }
    }

    private void handleBlackSiblingWithAtLeastOneRedChild(Node node, Node sibling) {
        boolean nodeIsLeftChild = node == node.parent.left;

        //case 5:sibling is black with at least one red child,outer nephew is black -->recolor sibling+inner nephew
        //rotate around the sibling opposite direction of deleted node
        if (nodeIsLeftChild && isBlack(sibling.right)) {
            //recolor inner nephew
            sibling.left.color = BLACK;
            sibling.color = RED;
            rotateRight(sibling);
            sibling = node.parent.right;
        } else if (!nodeIsLeftChild && isBlack(sibling.left)) {
            sibling.right.color = BLACK;
            sibling.color = RED;
            rotateLeft(sibling);
            sibling = node.parent.left;
        }

        //case 6:sibling is black with at least one red child,outer nephew is red--recolor sibling+outer
        // nephew+parent and rotate around parent
        sibling.color = sibling.parent.color;
        node.parent.color = BLACK;
        if (nodeIsLeftChild) {
            sibling.right.color = BLACK;
            rotateLeft(node.parent);
        } else {
            sibling.left.color = BLACK;
            rotateRight(node.parent);
        }
    }

    private void handleRedSibling(Node node, Node sibling) {
        sibling.color = BLACK;
        node.parent.color = RED;
        if (node == node.parent.left) {
            rotateLeft(node.parent);
        } else {
            rotateRight(node.parent);
        }
    }


}
