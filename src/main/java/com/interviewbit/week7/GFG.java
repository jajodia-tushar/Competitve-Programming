package com.interviewbit.week7;

import java.util.*;

class GFG {

    public static void main(String[] args) {
        int arr[] = {0, 1, -1, 0};
        int n = arr.length;
        System.out.println(solve(n, arr));

//        String[] arr = new String[]{"2.671613", "1.239175", "2.575260", "0.021242", "1.894100", "0.148016", "0.341571" };
//        System.out.println(solve(arr));
//
//        int arr[] = { 4, -9, 8, 5, -1, 7, 5, 3};
//        System.out.println(solve(arr));
    }

    public static int solve(int A, int[] B) {

        int sum = 0;
        for (int i = 0; i < A; i++) {
            sum += B[i];
        }

        if ((sum % 3) == 0) {
            int requiredSum = sum / 3;
            int suffixArray[] = new int[A];
            int tempSum = 0;

            //Finding the Temporary Sum.
            for (int i = (A - 1); i >= 0; i--) {
                tempSum += B[i];
                if (tempSum == requiredSum)
                    suffixArray[i] = 1;
            }

            // Finding the cumulative Sum of temporary Array.
            for (int i = (A - 2); i >= 0; i--) {
                suffixArray[i] += suffixArray[i + 1];
            }

            tempSum = 0;
            int count = 0;

            for (int i = 0; i < A - 2; i++) {
                tempSum += B[i];
                if (tempSum == requiredSum) {
                    count += suffixArray[i + 2];
                }
            }

            return count;
        } else {
            return 0;
        }
    }

    /*
    =============================================================================================================================================
    You are given a 1D integer array B containing A integers.
    Count the number of ways to split all the elements of the array into 3 contiguous parts so that the sum of elements in each part is the same.
    Such that : sum(B[1],..B[i]) = sum(B[i+1],...B[j]) = sum(B[j+1],...B[n])
    ============================================================================================================================================
    
    I was not able to solve this problem
    this solved
    https://medium.com/@abhi1kush/count-the-number-of-ways-to-divide-an-array-into-three-contiguous-parts-having-equal-sum-873a8cfb9c85

    and has properly explained the concept how you have to use it.
    Basically think like this.


    Try to take the minimum step and start thinking logically.
    Look if the sum of all the numbers in the array is not divisible by 3 then sorry the solution doesn't exist.
    Secondly if it is divisible by 3 then each continuous sub array will have the the sum equal to (totalSum / 3)  ----> Logical Right ?

    As we need to find the continuous array so there is no question of re-arranging the array to solve the problem.

    The Idea is simple to solve the problem.
    Divide the array in three parts based on sum.

   1. If we somehow know the sum of (array[0].....array[i]) = totalSum/3 and
   2. sum of (array[j]....array[n]) = totalSum/3 and there is some gap in between i and j.
   3. then we can be sure that the sum of (arr[i+1].....arr[j-1]) = totalSum/3                            -------------> Logical Right ?

    See calculating the sum of the middle part is difficult and it is easy to calculate the sum of items in the
    edges.

    Second trick is this.

    We start from end of the array and then come till the beginning of the array. We take a temporary array.
    and assign a value 1 at the ith index in the temporary array if the sum from ith index to nth index in the original
    array is equal to totalSum/3 and for other scenarios we assign 0.

    In the above trick we are not doing any fancy things, we are just assigning 1 at the index which will form a  the sub arrays
    whose sum is equal to totalSum/3 but we just start from the end.

    now to find the number of sub-array whose sum will be equal to totalSum/3 we find the cumulative sum of from end of the array.
    This will tell us nothing just the number of subArray that can have the sum of totalSum/3 from a particular array.

    Eg.
    Original Array A = {1 ,2 ,3 ,0 ,3}
    tempArray = { 0, 0, 0, 1, 1} ----> Only sum from 4th adn 3rd index to nth index is equal to totalSum/3.


    After Cumulative sum we have tempArray = {2,2,2,2,1}
    What this array says is that if we start from the end of the array we can have have tempArray[i] number of sub arrays
    at ith positions.
    or.
    At any index i we can easily know how many continuous sub array we can form from the remaining elements.

    Well this is very important.
    If we start counting the sum from the starting and once the sum hits totalSum/3 let's say at i then
    we can find the total number of sub arrays that can be formed from i+2 index to end of the array fom this tempArray.

    counting such subArrays over all the possible i will yield to solution.

     */




    /*
    ===============================================================================================================
    This is very Interesting Question.
    Given an array of real numbers greater than zero in form of strings.
    Find if there exists a triplet (a,b,c) such that 1 < a+b+c < 2 .
    Return 1 for true or 0 for false.
    ================================================================================================================

    The Naive solution would be to use three for-loops and then iterate over the the array
    to find all the possible combination in the given range.
    But this is very inefficient.
    Think about the solution, We don't need the items, we just need to tell if it exists.


    So this is a kind of bucketing problem.
    We create buckets which will yield to solutions.

    We will create Buckets,

    Lets create two buckets A and B.
    A = (0,1]
    B = (1,2)

    Three Numbers in the Can be in following Combinations
    A A A
    A A B
    A B B
    B B B

    Now fourth and third group elements will now be counted in the solutions as the minimum value in the B
    will be at least 1.
    so B B will be 2 so it will now account.
    But in the first and second group we cannot tell 100 % so what we can do is further divide the group in
    smaller buckets.

    Lets make three Buckets
    A = (0, 2/3)
    B = [2/3, 1)
    C = (1,2)

    The three Number can Fall like this

    1. A A A       ------> Max1A, Max2A, Max3A  can make the Solution. Can't be overflow
    2. A A B       ------> Max1A, Max2A, Max1B or Min1A, Min2A, Min1B  can make the Solution.
    3. A A C       ------> Min1A, Min2A, Min1C  can make the Solution. Can't be Underflow
    4. A B B       ------> Min1A, Min1B, Min2B  can make the Solution. Can't be Underflow
    5. A B C       ------> Min1A, Min1B, Min1C  can Make the Solution. Can't be Underflow.
    6. A C C       ------> X Two C will be more than 2 so Excluded
    7. B B B       ------> X 2/3 * 3 will be 2 so Excluded.
    8. B B C       ------> X 2B will be 4/3 and C will be 1 at Minimum so this group will also be Excluded
    9. B C C       ------> X As two C is greater than 2 so Excluded
   10. C C C       ------> X As Min in C is 1 so Sum will be Greater than 3 so Excluded


    MaxA can be little less than 2/3 so adding A A A Can be in required range so We need
    Can check for the three Maximum number in group A to see if it is in our required range. (It cannot also be that's why we check)
    Something to note here is that even the Min1A, Min2A, Min3A can also make but the point here is that
    if the above sequence makes in the required range then the Max1A, Max2A, Max3A will definitely make.
    The question says if it exists not to find all the possible combinations.
    Keep in mind.

     Similarly if any of the Case is satisfied. We are good to go.
     */

    public static int solve(String[] A) {

        double max1a = Integer.MIN_VALUE,
                max2a = Integer.MIN_VALUE,
                max3a = Integer.MIN_VALUE,
                max1b = Integer.MIN_VALUE;

        double min1a = Integer.MAX_VALUE,
                min2a = Integer.MAX_VALUE,
                min1b = Integer.MAX_VALUE,
                min2b = Integer.MAX_VALUE,
                min1c = Integer.MAX_VALUE;


        for(int i = 0; i < A.length; i++) {
            double num = Double.parseDouble(A[i]);
            if (isInA(num)) {
                if (num > max1a) {
                    max3a = max2a;
                    max2a = max1a;
                    max1a = num;
                } else if (num > max2a) {
                    max3a = max2a;
                    max2a = num;
                } else if (num > max3a) max3a = num;
                if (num < min1a) {
                    min2a = min1a;
                    min1a = num;
                } else if (num < min2a) min2a = num;
            } else if (isInB(num)) {
                if (num > max1b)
                    max1b = num;

                if (num < min1b) {
                    min2b = min1b;
                    min1b = num;
                } else if (num < min2b) min2b = num;
            } else if (isInC(num)) {

                if (num < min1c) min1c = num;
            }
        }
                if((max1a + max2a + max3a) > 1.0)
                    return 1;
                else if((max1a + max2a + min1b) > 1.0 && (max1a + max2a + min1b) < 2.0)
                    return 1;
                else if((min1a + min2a + max1b) > 1.0 && (min1a + min2a + max1b) < 2.0)
                    return 1;
                else if((min1a + min2a + min1c) < 2.0)
                    return 1;
                else if((min1a + min1b + min2b) < 2.0)
                    return 1;
                else if((min1a + min1b + min1c) < 2.0)
                        return 1;

        return 0;
    }

    public static boolean isInA(double num){
        return num > 0.0 && num < 2.0/3.0;
    }

    public static boolean isInB(double num){
        return num >= 2.0/3.0 && num < 1;
    }

    public static boolean isInC(double num){
        return num >= 1 && num < 2.0;
    }

    /*
    ===========================================================================================================================================
    Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p.
    The naive solution is easy and simple.
    Check the required statement for all.
    ============================================================================================================================================

    but Sorting will help.

    Sort the array and then you will be able to predict how many numbers are exactly greater than given number.
    However you will have to handle just the case where the number start to repeat


     */

    public static int solve(int[] A) {
        Arrays.sort(A);

        for(int i = 0; i < A.length - 1; i++){
            if(A[i] == A[i+1])
                continue;

            if(A[i] == (A.length - 1 - i))
                return 1;
        }
        return -1;
    }

    /*
    =======================================================================================================
    Given an array of integers, sort the array into a wave like array and return it,
    In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....

    Given [1, 2, 3, 4]
    One possible answer : [2, 1, 4, 3]
    Another possible answer : [4, 1, 3, 2]
        NOTE : If there are multiple answers possible, return the one thats lexicographically smallest.
        So, in example case, you will return [2, 1, 4, 3]
    =======================================================================================================
    Solution

    */



}