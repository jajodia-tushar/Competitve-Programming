package com.java;

public class BinarySearchImplementation {
    private int[] arr;

    BinarySearchImplementation() {
        this.arr = new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21};
    }

    public static void main(String[] args) {

        BinarySearchImplementation obj = new BinarySearchImplementation();
        int result = obj.normalImplementation(2);
        System.out.println(result);
    }

    public int normalImplementation(int item) {

        int start = 0;
        int end = arr.length;
        int midValue = -1;

        while (start < end) {

            int mid = start + (end - start) / 2;
            midValue = this.arr[mid];

            if (midValue == item) {
                return mid;
            } else if (midValue > item) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return midValue;
    }
}
