package com.leetcode.segmenttree;

import com.interviewbit.utils.ArrayUtils;

public class SegmentTree {

    int[] segmentArray;

    public SegmentTree(int[] arr) {
        int n = arr.length;
        int size = calculateSize(n);
        this.segmentArray = new int[size];
        constructSegmentTree(arr, 0, n - 1, 0);
    }

    private int calculateSize(int n) {
        int x = (int) Math.ceil(Math.log(n) / Math.log(2));
        return 2 * (int) Math.pow(2, x) - 1;
    }

    private int getMid(int start, int end) {
        return start + (end - start) / 2;
    }

//    private int constructSegmentTree(int[] arr, int start, int end, int segmentTreeArrayIndex) {
//
//        if (start == end) {
//            return this.segmentArray[segmentTreeArrayIndex] = arr[start];
//        }
//
//        int mid = getMid(start, end);
//        this.segmentArray[segmentTreeArrayIndex] = constructSegmentTree(arr, start, mid, 2 * segmentTreeArrayIndex + 1)
//                + constructSegmentTree(arr, mid + 1, end, 2 * segmentTreeArrayIndex + 2);
//
//        return this.segmentArray[segmentTreeArrayIndex];
//    }

    private int constructSegmentTree(int[] arr, int start, int end, int currentIndexInSegment){

        if(start == end){
            this.segmentArray[currentIndexInSegment] = arr[start];
        }

        int mid = getMid(start,end);

        this.segmentArray[currentIndexInSegment] = constructSegmentTree(arr,start,mid,currentIndexInSegment * 2 + 1)
                + constructSegmentTree(arr,mid + 1,end,currentIndexInSegment * 2 + 2);

        return this.segmentArray[currentIndexInSegment];
    }

    public int getSum(int n, int start, int end) {
        return calculateSum(start, end, 0, n - 1, 0);
    }

    private int calculateSum(int start, int end, int segmentStart, int segmentEnd, int currentSegmentIndex) {

        if (start <= segmentStart && end >= segmentEnd)
            return this.segmentArray[currentSegmentIndex];
        if (end < segmentStart || segmentEnd < start)
            return 0;
        int mid = getMid(segmentStart, segmentEnd);
        return calculateSum(start, end, segmentStart, mid, 2 * currentSegmentIndex + 1)
                + calculateSum(start, end, mid + 1, segmentEnd, 2 * currentSegmentIndex + 2);
    }

    public void update(int[] arr, int index, int newValue) {
        int n = arr.length;
        int diff = newValue - arr[index];
        arr[index] = newValue;
        updateUtil(0, n - 1, index, diff, 0);
    }

    private void updateUtil(int segmentStart, int segmentEnd, int updateIndex, int diff, int currentSegmentIndex) {

        if (updateIndex < segmentStart || updateIndex > segmentEnd) return;

        this.segmentArray[currentSegmentIndex] = this.segmentArray[currentSegmentIndex] + diff;

        if (segmentStart != segmentEnd) {
            int mid = getMid(segmentStart, segmentEnd);
            updateUtil(segmentStart, mid, updateIndex, diff, currentSegmentIndex * 2 + 1);
            updateUtil(mid + 1, segmentEnd, updateIndex, diff, currentSegmentIndex * 2 + 2);
        }

    }


    public static void main(String[] args) {

        int[] ints = {1, 3, 5, 7, 9, 11,100};
        int n = ints.length;
        SegmentTree obj = new SegmentTree(ints);
        int sum = obj.getSum(n, 1, 4);
        System.out.println(sum);
        obj.update(ints, 1, 9);
        sum = obj.getSum(n, 1, 4);
        System.out.println(sum);

    }

}
