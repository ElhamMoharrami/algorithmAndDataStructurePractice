package com.practice.algorithmanddatastructure.implementDataStructures.tree.trie;

import java.util.HashMap;

public class Node {
    private HashMap<Character, Node> children;
    private String content;
    private boolean isWord;


    public Node() {
        this.children = new HashMap<>();
    }

    public HashMap<Character, Node> getChildren() {
        return children;
    }

    public void setChildren(HashMap<Character, Node> children) {
        this.children = children;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean getIsWord() {
        return isWord;
    }

    public void setIsWord(boolean word) {
        isWord = word;
    }
}
