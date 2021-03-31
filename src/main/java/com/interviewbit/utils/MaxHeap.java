package com.interviewbit.utils;

import static com.interviewbit.utils.ArrayUtils.printArray;

public class MaxHeap implements Heap {

    private final int[] heapArray;
    private final int capacity;
    private int currentCapacity;


    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.heapArray = new int[this.capacity];
        this.currentCapacity = 0;
    }


    @Override
    public void insert(int item) {
        if(this.currentCapacity != this.capacity){

            int i = this.currentCapacity;
            this.heapArray[i] = item;
            this.currentCapacity++;

            while(i != 0 && this.heapArray[i] > this.heapArray[this.getParent(i)]){
                this.swap(i,getParent(i));
                i = getParent(i);
            }
        }


    }

    @Override
    public int getTopItem() {

        if(this.currentCapacity <= 0){
            return Integer.MIN_VALUE;
        }

        if(this.currentCapacity == 1){
            this.currentCapacity--;
            return this.heapArray[0];
        }

        int returningValue = this.heapArray[0];
        this.heapArray[0] = this.heapArray[this.currentCapacity - 1];
        this.currentCapacity--;
        this.heapify(0);
        return returningValue;
    }

    @Override
    public void printHeapArray() {
        printArray(this.heapArray);
    }

    @Override
    public void heapify(int index) {

        int leftChild = getLeftChild(index);
        int rightChild = getRightChild(index);
        int largest = index;

        if(leftChild < this.currentCapacity && this.heapArray[leftChild] > this.heapArray[largest]){
            largest = leftChild;
        }

        // Look Properly the Following condition is not similar to above condition.
        // We are not giving priority to Right Node and leaving the Left Node untouched.
        // The idea is if left element is already greater than largest which is the current index.
        // we are storing the position in the largest.
        // Now we are comparing the right node value not with the index rather we are comparing it with
        // left value as largest now contains position of the left Node.
        // So basically this will make you choose the largest in the three node.
        if(rightChild < this.currentCapacity && this.heapArray[rightChild] > this.heapArray[largest]){
            largest = rightChild;
        }

        if(largest != index){
            this.swap(largest,index);
            this.heapify(largest);
        }
    }

    private void swap(int first, int second) {
        int temp = this.heapArray[first];
        this.heapArray[first] = this.heapArray[second];
        this.heapArray[second] = temp;
    }
}
