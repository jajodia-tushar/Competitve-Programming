package com.interviewbit.utils;

public interface Heap {


    void insert(int item);
    int getTopItem();
    void printHeapArray();
    void heapify(int index);

    default int getParent(int index) {
        return (index - 1) / 2;
    }

    default int getLeftChild(int index) {
        return (index * 2) + 1;
    }

    default int getRightChild(int index) {
        return (index * 2) + 2;
    }
}
