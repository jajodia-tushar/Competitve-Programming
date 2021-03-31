package com.interviewbit.utils;

import static com.interviewbit.utils.ArrayUtils.printArray;

public class MinHeap implements Heap {

    private final int[] heapArray;
    private final int capacity;
    private int currentCapacity;


    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.heapArray = new int[this.capacity];
        this.currentCapacity = 0;
    }

    @Override
    public void insert(int item) {
        if (this.currentCapacity != this.capacity) {
            int i = this.currentCapacity;
            this.heapArray[i] = item;
            this.currentCapacity++;

            while (i != 0 && this.heapArray[i] < this.heapArray[this.getParent(i)]) {
                this.swap(i, this.getParent(i));
                i = this.getParent(i);
            }
        }
    }


    @Override
    public void heapify(int index) {

        int leftChild = getLeftChild(index);
        int rightChild = getRightChild(index);

        int smallest = index;

        if (leftChild < this.currentCapacity &&
                this.heapArray[leftChild] < this.heapArray[smallest])
            smallest = leftChild;

        if (rightChild < this.currentCapacity &&
                this.heapArray[rightChild] < this.heapArray[smallest])
            smallest = rightChild;

        if (smallest != index) {
            this.swap(smallest, index);
            this.heapify(smallest);
        }

    }
    @Override
    public int getTopItem() {
        if (this.currentCapacity <= 0) {
            return Integer.MAX_VALUE;
        }

        if (this.currentCapacity == 1) {
            this.currentCapacity--;
            return this.heapArray[0];
        }

        int returningValue = this.heapArray[0];
        this.heapArray[0] = this.heapArray[currentCapacity - 1];
        this.currentCapacity--;
        this.heapify(0);
        return returningValue;

    }
    @Override
    public void printHeapArray() {
        printArray(this.heapArray);
    }

    private void swap(int first, int second) {
        int temp = this.heapArray[first];
        this.heapArray[first] = this.heapArray[second];
        this.heapArray[second] = temp;
    }

}
