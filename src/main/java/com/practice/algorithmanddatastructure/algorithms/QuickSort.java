package com.practice.algorithmanddatastructure.algorithms;

import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }
        System.out.println("before:");
        printArray(numbers);
        quickSort(numbers, 0, numbers.length - 1);
        System.out.println("\nAfter");
        printArray(numbers);
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    private static void quickSort(int[] array, int lowIndex, int highIndex) {
        //when you partinioned until you only have one element left
        if (lowIndex >= highIndex) {
            return;
        }
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = array[pivotIndex];
        swap(array,pivotIndex,highIndex);

        int leftPointer = partition(array, lowIndex, highIndex, pivot);

        //now swap leftpointer with the pivot

        swap(array, leftPointer, highIndex);

        //now recursively
        quickSort(array, lowIndex, leftPointer - 1);
        quickSort(array, leftPointer + 1, highIndex);
    }

    private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;
        while (leftPointer < rightPointer) {

            //goes until it finds an element larger than the pivot
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            //goes until it finds an element smaller than the pivot
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            //now it is time to swap
            swap(array, leftPointer, rightPointer);
        }
        return leftPointer;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
/*
in our code, first we ignore the pivot(aka the high element) and focus on the rest of the array, we'll have two pointers, one that
starts at the begining of the array and one that is at the end of the array. we start walking through our array a single elemnt at a time until
we find an element that is larger than the pivot. we keep that pointer there.
then we focus on the right pointer, keeps walking through until it finds an elemnt less than our pivot.
then we swap those values.
you keep doing that until both pointers are pointing to the exact same element. now swap that element at that index with your pivot.
now all the elements less than pivot are on its left and all elements greater are on its right.
*/

/*
choosing the pivot randomly is said to be better, just choose an elemnt and swap it with the last elemnt everything else is the same
* */