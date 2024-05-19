package com.practice.algorithmanddatastructure.implementDataStructures.graph.tree.trie;

import java.util.HashMap;

public class TrieNode {
    private char character;
    private HashMap<Character, TrieNode> children = new HashMap<>();
    private boolean isLeaf;

    public TrieNode() {
    }

    public TrieNode(char character) {
        this.character = character;
    }

    public HashMap<Character, TrieNode> getChildren() {
        return this.children;
    }

    public void setChildren(HashMap<Character, TrieNode> children) {
        this.children = children;
    }

    public boolean isLeaf() {
        return this.isLeaf;
    }

    public void setIsLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }
}
