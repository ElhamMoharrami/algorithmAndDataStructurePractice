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
        //This means we have reached the end of the word while iterating through it.
        if (index == word.length()) {
            //we reached end of the word we were given, but is it an actual word? if it is not an actual word we
            // wont delete it
            if (!current.getIsWord()) {
                return false;
            }
            //ensure that the current node will not be considered as the end of a word in the future.
            current.setIsWord(false);
            //If there are no child nodes, it means that the current node is an appropriate place to delete the word,
            // and the function returns true
            return current.getChildren().isEmpty();
        }
        char ch = word.charAt(index);
        Node node = current.getChildren().get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.getIsWord();
        if (shouldDeleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("Programming");
        trie.insert("is");
        trie.insert("a");
        trie.insert("and");
        trie.insert("way");
        trie.insert("of");
        trie.insert("want");
        trie.insert("life");


        System.out.println(trie.delete("and"));
    }
}
