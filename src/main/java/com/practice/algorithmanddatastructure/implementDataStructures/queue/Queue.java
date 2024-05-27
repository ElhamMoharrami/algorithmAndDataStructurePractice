package com.practice.algorithmanddatastructure.implementDataStructures.queue;

public class Queue {
    private final int size;
    private final int[] items;
    private int front;
    private int rear;

    public Queue(int size, int[] items) {
        this.size = size;
        this.items = items;
        this.front = -1;
        this.rear = -1;
    }

    public boolean isFull() {
        return front == 0 && rear == size - 1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public void enQueue(int x) {
        if (isFull()) {
            System.out.println("queue is full");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear++;
            items[rear] = x;
            System.out.println("inserted " + x);
        }
    }

    public int deQueue() {
        int x;
        if (isEmpty()) {
            System.out.println("queue is empty");
            return (-1);
        }else {
            x=items[front];
            // if the queue has only one element
            if (front >= rear) {
                front = -1;
                rear = -1;
            }
            else {
                // mark next element as the front
                front++;
            }
            System.out.println( x + " Deleted");
            return (x);
        }
    }

}
