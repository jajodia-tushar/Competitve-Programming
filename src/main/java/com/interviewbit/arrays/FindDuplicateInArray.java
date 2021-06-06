package com.interviewbit.arrays;

/*
Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.

Sample Input:

[3 4 1 4 1]
Sample Output:

1
If there are multiple possible answers ( like in the sample case above ), output any one.

If there is no duplicate, output -1
 */
public class FindDuplicateInArray {

    public static void main(String[] args) {
        FindDuplicateInArray obj = new FindDuplicateInArray();
        int[] ints = new int[]{1, 2, 3, 4, 4};
        int result = obj.repeatedNumber(ints);
        System.out.println(result);
    }

    public int repeatedNumber(final int[] A) {

        int n = A.length;
        for (int i = 0; i < n; i++) {
            int currNumber = Math.abs(A[i]);

            if (A[currNumber] > 0) {
                A[currNumber] = -A[currNumber];
            } else {
                return currNumber;
            }
        }

        return -1;

    }
}

/*
    There is nothing much in this question as well.
    Just we are taking the current Number and in the index of this current Number
    we are multiplying it with -1.
    so if before multiplying we get negative number it means some other number has
    already made this negative and only currNumber can do this so that is our answer.
    Look the code you will understand.



 */
