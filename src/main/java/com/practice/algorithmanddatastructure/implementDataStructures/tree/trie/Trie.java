package com.practice.algorithmanddatastructure.implementDataStructures.tree.trie;

public class Trie {
    private final Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node current = root;

        for (char l: word.toCharArray()) {
            //the c is passed to the function invocation(there is none here for new Node() though)
            current = current.getChildren().computeIfAbsent(l, c -> new Node());
        }
        current.setIsWord(true);
    }

    /*public boolean search(String word){
        Node currentNode=root;
        for (Character c:word.toCharArray()){
            Node node=currentNode.children.get(c);
            if (node==null){
                return false;
            }
            currentNode=node;
        }
        return currentNode.isEndOfWord;
    }

    public boolean delete(String word ){
        return deleteHelper(word,root,0);
    }

    private boolean deleteHelper(String word, Node currentNode, int index) {
        //if we parsed each character and there is nothing left in the word that we didnt check
        if (index==word.length()){
            //if it is not the end of the word even though we checked all characters
            if (!currentNode.isEndOfWord){
                return false;
            }
        }
    }*/
}
