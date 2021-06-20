package com.leetcode.segmenttree;


/*
Given an integer array nums, handle multiple queries of the following types:

Update the value of an element in nums.
Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
void update(int index, int val) Updates the value of nums[index] to be val.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).


Example 1:

Input
["NumArray", "sumRange", "update", "sumRange"]
[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
Output
[null, 9, null, 8]

Explanation
NumArray numArray = new NumArray([1, 3, 5]);
numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
numArray.update(1, 2);   // nums = [1, 2, 5]
numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8


Constraints:

1 <= nums.length <= 3 * 104
-100 <= nums[i] <= 100
0 <= index < nums.length
-100 <= val <= 100
0 <= left <= right < nums.length
At most 3 * 104 calls will be made to update and sumRange
 */
public class RangeSumQueryMutable {

    private int[] segmentArray;
    private int[] originalArray;

    public static void main(String[] args) {

        int[] ints = {0,9,5,7,3};
        RangeSumQueryMutable obj = new RangeSumQueryMutable(ints);
        int result = obj.sumRange(0, 2);
        System.out.println(result);
        obj.update(1, 2);
        result = obj.sumRange(0, 2);
        System.out.println(result);

    }

    public RangeSumQueryMutable(int[] nums) {

        int n = nums.length;
        int size = getSize(n);
        this.segmentArray = new int[size];
        this.originalArray = nums;
        constructSegmentTree(nums, 0, n - 1, 0);
        for (int i = 0; i < size; i++) {
            System.out.print(this.segmentArray[i] + " ");
        }
        System.out.println();
    }

    public void update(int index, int val) {
        int n = this.originalArray.length;
        int diff = val - this.originalArray[index];
        this.originalArray[index] = val;
        updateSegmentTree(0, n - 1, index, diff, 0);
        for (int i = 0; i < this.segmentArray.length; i++) {
            System.out.print(this.segmentArray[i] + " ");
        }
        System.out.println();
    }

    public int sumRange(int left, int right) {
        int n = this.originalArray.length;
        return calculateSum(left, right, 0, n - 1, 0);
    }

    private int getSize(int n) {

        int x = (int) Math.ceil(Math.log(n) / Math.log(2));
        return 2 * (int) Math.pow(2, x) - 1;

    }

    private int getMid(int start, int end) {
        return start + (end - start) / 2;
    }

    private int constructSegmentTree(int[] arr, int start, int end, int currentIndexInSegment) {

        if (start == end) {
            return this.segmentArray[currentIndexInSegment] = arr[start];
        }

        int mid = getMid(start, end);

        this.segmentArray[currentIndexInSegment] = constructSegmentTree(arr, start, mid, currentIndexInSegment * 2 + 1)
                + constructSegmentTree(arr, mid + 1, end, currentIndexInSegment * 2 + 2);

        return this.segmentArray[currentIndexInSegment];
    }

    private int calculateSum(int start, int end, int segmentStart, int segmentEnd, int currentIndexInSegment) {


        if (start <= segmentStart && segmentEnd <= end)
            return this.segmentArray[currentIndexInSegment];

        if (segmentEnd < start || end < segmentStart) return 0;

        int mid = getMid(segmentStart, segmentEnd);

        return calculateSum(start, end, segmentStart, mid, currentIndexInSegment * 2 + 1)
                + calculateSum(start, end, mid + 1, segmentEnd, currentIndexInSegment * 2 + 2);
    }


    private void updateSegmentTree(int segmentStart, int segmentEnd, int index, int diff, int currentSegmentIndex) {

        if (index < segmentStart || segmentEnd < index) return;


        this.segmentArray[currentSegmentIndex] += diff;

        if (segmentStart != segmentEnd) {

            int mid = getMid(segmentStart, segmentEnd);
            updateSegmentTree(segmentStart, mid, index, diff, currentSegmentIndex * 2 + 1);
            updateSegmentTree(mid + 1, segmentEnd, index, diff, currentSegmentIndex * 2 + 2);
        }
    }
}
