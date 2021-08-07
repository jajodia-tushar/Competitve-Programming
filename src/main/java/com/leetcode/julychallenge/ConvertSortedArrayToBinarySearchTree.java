package com.leetcode.julychallenge;

import com.interviewbit.utils.TreeNode;

/*

Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.



Example 1:


Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:


Input: nums = [1,3]
Output: [3,1]
Explanation: [1,3] and [3,1] are both a height-balanced BSTs.


Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in a strictly increasing order.


 */
public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree obj = new ConvertSortedArrayToBinarySearchTree();
        int[] ints = {-10, -3, 0, 5, 9};
        TreeNode result = obj.sortedArrayToBST(ints);
        TreeNode.inOrderPrint(result);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return createTree(nums, 0, n - 1);
    }

    public TreeNode createTree(int[] nums, int start, int end) {

        if (start > end || start < 0 || end >= nums.length) return null;
        if (start == end) return new TreeNode(nums[start]);

        int mid = getMiddle(start, end);
        System.out.println("Middle Element " + mid + "start -- End " + start + " - " + end);
        int midItem = nums[mid];

        TreeNode root = new TreeNode(midItem);
        root.left = createTree(nums, start, mid - 1);
        root.right = createTree(nums, mid + 1, end);
        return root;
    }

    public int getMiddle(int i, int j) {
        return i + (j - i) / 2;
    }
}
