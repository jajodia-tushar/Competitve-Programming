package com.leetcode.julychallenge;

/*
Given an n x n matrix where each of the rows and columns are sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.



Example 1:

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
Example 2:

Input: matrix = [[-5]], k = 1
Output: -5


Constraints:

n == matrix.length
n == matrix[i].length
1 <= n <= 300
-109 <= matrix[i][j] <= 109
All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
1 <= k <= n2
Accepted
296,565
Submissions
513,877
 */
public class KthSmallestElementInASortedMatrix {

    public static void main(String[] args) {

        KthSmallestElementInASortedMatrix obj = new KthSmallestElementInASortedMatrix();
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 8;
        int result = obj.kthSmallest(matrix, k);
        System.out.println(result);
    }


    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;

        int min = matrix[0][0];
        int max = matrix[row - 1][col - 1];

        int ans = -1;

        while( min <= max){

            int mid = min + (max - min)/2;

            int count = 0;
            for(int i = 0; i < row; i++){
                count += getSmallerOrEqual(matrix[i],mid);
            }

            if( count < k){
                min = mid + 1;
            }
            else max = mid - 1;
        }
        return min;
    }

    public int getSmallerOrEqual(int[] arr, int k){

        int low = 0;
        int high = arr.length - 1;

        while( low <= high){
            int mid = low + (high - low)/2;
            int midValue = arr[mid];

            if( midValue > k ){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
}

/*
    This Question is similar to getting Median of the 2D sorted matrix


 */