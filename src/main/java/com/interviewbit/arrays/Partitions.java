package com.interviewbit.arrays;

/*
Problem Description

You are given a 1D integer array B containing A integers.

Count the number of ways to split all the elements of the array into 3 contiguous parts so that the sum of elements in each part is the same.

Such that : sum(B[1],..B[i]) = sum(B[i+1],...B[j]) = sum(B[j+1],...B[n])



Problem Constraints
1 <= A <= 105

-109 <= B[i] <= 109



Input Format
First argument is an integer A.

Second argument is an 1D integer array B of size A.



Output Format
Return a single integer denoting the number of ways to split the array B into three parts with the same sum.



Example Input
Input 1:

 A = 5
 B = [1, 2, 3, 0, 3]
Input 2:

 A = 4
 B = [0, 1, -1, 0]


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 There are no 2 ways to make partitions -
 1. (1,2)+(3)+(0,3).
 2. (1,2)+(3,0)+(3).
Explanation 2:

 There is only 1 way to make partition -
 1. (0)+(-1,1)+(0).



 */
public class Partitions {

    public static void main(String[] args) {

        Partitions obj = new Partitions();
        int[] ints = {1, 2, 3, 0, 3};
        int result = obj.solve(5,ints);
        System.out.println(result);


    }

    public int solve(int A, int[] B) {
        int sum = 0;
        for(int i = 0; i < A; i++){
            sum += B[i];
        }
        if( sum % 3 != 0) return 0;
        int requiredSum = sum / 3;

        int[] suffixArray = new int[A];
        suffixArray[A - 1] = B[A - 1];

        for(int i = A - 2; i >= 0; i--){
            suffixArray[i] = suffixArray[i + 1] + B[i];
        }

        if(suffixArray[A - 1] == requiredSum)
            suffixArray[A - 1] = 1;
        else
            suffixArray[A - 1] = 0;

        for(int i = A - 2; i >= 0; i--){
            if( suffixArray[i] == requiredSum)
                suffixArray[i] = 1 + suffixArray[i + 1];
            else
                suffixArray[i] = suffixArray[i + 1];
        }

        int count = 0;
        int currentSum = 0;
        for(int i = 0; i < A; i++){
            currentSum += B[i];
            if( currentSum == requiredSum){
                if( i + 2 < A)
                    count += suffixArray[i + 2];
            }
        }
        return count;
    }
}

/*
    =============================================================================================================================================
    You are given a 1D integer array B containing A integers.
    Count the number of ways to split all the elements of the array into 3 contiguous parts so that the sum of elements in each part is the same.
    Such that : sum(B[1],..B[i]) = sum(B[i+1],...B[j]) = sum(B[j+1],...B[n])
    ============================================================================================================================================

    I was not able to solve tshis problem
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
    whose sum is equal to totalSum/3.

    no to find the number of sub-array whose sum will be equal to totalSum/3 we find the cumulative sum of from end of the array.
    This will tell us nothing just the number of subArray that can have the sum of totalSum/3 from a particular array.

    Eg.
    Original Array A = {1 ,2 ,3 ,0 ,3}
    tempArray = { 0, 0, 0, 1, 1} ----> Only sum from 4th adn 3rd index to nth index is equal to totalSum/3.


    After Cumulative sum we have tempArray = {2,2,2,2,1}
    What this array says is that if we start from the end of the array we can have have tempArray[i] number of sub arrays
    at ith positions.

    Well this is very important.
    If we start counting the sum from the starting and once the sum hits totalSum/3 let's say at i then
    we can find the total number of sub arrays that can be formed from i+2 index to end of the array fom this tempArray.

    counting such subArrays over all the possible i will yield to solution.
    Below is the Solution


    ======================================================================================================================================

    This Answer is Second version and I was just able to do this without any help.
    It was So Nice.


     */
