package com.practice.algorithmanddatastructure.implementDataStructures.LinkedList;

import java.util.Objects;

public class LinkedList {
    private Node head;

    public void insert(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }
        Node current = head;
        while (current.nextNode != null) {
            current = current.nextNode;
        }
        current.nextNode = node;
    }

    public void delete(int data) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            head = head.nextNode;
            return;
        }
        Node current = head;
        while (current.nextNode != null) {
            if (current.nextNode.data == data) {
                current.nextNode = current.nextNode.nextNode;
                return;
            }
            current = current.nextNode;
        }
    }

    public void display() {
        if (head == null) {
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.nextNode;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);

        list.display();
        System.out.println("---------------------------------");
        list.delete(2);

        list.display();
    }
}
