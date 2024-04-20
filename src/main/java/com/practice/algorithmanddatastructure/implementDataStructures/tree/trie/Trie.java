package com.practice.algorithmanddatastructure.implementDataStructures.tree.trie;

public class Trie {
    private final Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node current = root;

        for (char l : word.toCharArray()) {
            //the c is passed to the function invocation(there is none here for new Node() though)
            current = current.getChildren().computeIfAbsent(l, c -> new Node());
        }
        current.setIsWord(true);
    }

    public boolean find(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            Node node = current.getChildren().get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.getIsWord();
    }

    public boolean delete(String word) {
        return delete(root, word, 0);
    }

    private boolean delete(Node current, String word, int index) {
        if (index == word.length()) {
            if (!current.getIsWord()) {
                return false;
            }
            current.setIsWord(false);
            return current.getChildren().isEmpty();
        }
        char ch = word.charAt(index);
        Node node = current.getChildren().get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.getIsWord();
        if (shouldDeleteCurrentNode) {
            //current is the node before the current ch(it's parent)
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("there");
        trie.insert("their");
        trie.insert("any");
        trie.insert("answer");
        trie.insert("bye");

        System.out.println(trie.delete("any"));
    }
}
