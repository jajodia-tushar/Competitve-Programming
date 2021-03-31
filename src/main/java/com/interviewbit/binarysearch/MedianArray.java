package com.interviewbit.binarysearch;

public class MedianArray {

    public static void main(String[] args) {
        MedianArray obj = new MedianArray();
        int[][] arr = {{1,1,1,1,1,1,1,1,1,2,10,10,10,10,10,10,10,10,10,10}};
        System.out.println(obj.findMedian(arr));
    }

    public int findMedian(int[][] A) {

        int row = A.length;
        int column = A[0].length;
        int req = (row * column + 1) / 2;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < row; i++) {
            min = Math.min(min, A[i][0]);
            max = Math.max(max, A[i][column - 1]);
        }

        while (min < max) {
            int mid = min + (max - min) / 2;
            int place = 0;
            int get = 0;

            for (int i = 0; i < row; ++i) {
                get = binarySearch(A[i], mid);

                while (get < A[i].length && A[i][get] == mid)
                    get += 1;

                place = place + get;
            }
            if (place < req)
                min = mid + 1;
            else
                max = mid;
        }
        return min;
    }

    public int binarySearch(int[] A, int item) {

        int low = 0;
        int high = A.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (A[mid] > item) {
                high = mid - 1;
            } else if (A[mid] < item) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return low;
    }
}


