package com.practice.algorithmanddatastructure.implementDataStructures.graph.tree.trie;

import java.util.HashMap;

public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.getChildren();
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            TrieNode node;
            if (children.containsKey(character)) {
                node = children.get(character);
            } else {
                node = new TrieNode(character);
                children.put(character, node);
            }
            children = node.getChildren();

            if (i == word.length() - 1) {
                node.setIsLeaf(true);
            }
        }
    }

    //complete word search
    public boolean search(String word) {
        HashMap<Character, TrieNode> children = root.getChildren();
        TrieNode node = null;
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            if (children.containsKey(character)) {
                node = children.get(character);
                children = node.getChildren();
            } else {
                node = null;
                break;
            }
        }
        if (node != null && node.isLeaf()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean prefixSearch(String word) {
        HashMap<Character, TrieNode> children = root.getChildren();
        TrieNode node = null;
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            if (children.containsKey(character)) {
                node = children.get(character);
                children = node.getChildren();
            }
        }
        return node != null;
    }

    public void delete(String word) {
        HashMap<Character, TrieNode> children = root.getChildren();

    }
}
