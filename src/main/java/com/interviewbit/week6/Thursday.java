package com.interviewbit.week6;

import static com.interviewbit.utils.ArrayUtils.printArray;

public class Thursday {


    public static void main(String[] args) {
        Thursday obj = new Thursday();
        System.out.println(obj.maximumAbsoluteDifference(new int[]{3, -2, 5, -4}));
        System.out.println(obj.maximumAbsoluteDifference(new int[]{1, 3, -1}));
        System.out.println(obj.maximumAbsoluteDifference(new int[]{-70, -64, -6, -56, 64, 61, -57, 16, 48, -98}));

        printArray(obj.flip("010"));
        printArray(obj.flip("1101"));
        printArray(obj.flip("000000000000"));
        printArray(obj.flip("0100110"));
    }

    /*

    Maximum absolute difference of value and index sums
    find f(i,j) where f(i, j) is defined as |A[i] - A[j]| + |i - j|.



    Quickly giving the Brute force approach we can find all the values of f(i, j) and then
    get the maximum out of it and return.
    However this solution can take n^2.
    Optimizing the applied solution we can skip the pairs where i,j are equal as it is going to produce the f(i,j) of 0.


    Thinking little bit more about the question what we can do is use the feature of the Absolute value.
    i.e.

    |x| =  x  for x >= 0
    |x| = -x  for x <  0


    So the above equation can be

     A[i] - A[j] + i - j ------>  ( A[i] + i ) - (A[j] + j)
    -A[i] + A[j] - i + j ------> -( A[i] + i ) + (A[j] + j)
     A[i] - A[j] - i + j ------>  ( A[i] - i ) - (A[j] - j)
    -A[i] + A[j] + i - j ------> -( A[i] - i ) + (A[j] - j)

    Now the real intuitive part comes here.

    These four equations will give you the required values.
    now from all the possible values of i and j and A[i] and A[j]
    you will be able to get the maximum highest value required only if the negative part in the equation is minimum
    and the positive is maximum.
    i.e. Maximum  ( A[i] + i ) and Minimum (A[j] + j) in ------------ 1
         Minimum -( A[i] + i ) and Maximum (A[j] + j) in ------------ 2
         Maximum  ( A[i] - i ) and Minimum (A[j] - j) in ------------ 3
         Minimum  ( A[i] - i ) and Maximum (A[j] - j) in ------------ 4

         you will need Maximum and Minimum Values of
         ( A[i] + i ) and ( A[i] - i ) for all the i in Array.

         And then you will need to subtract the Maximum of the ( A[i] - i ) with minimum of ( A[i] - i )
         or the Maximum of ( A[i] + i ) with Minimum of ( A[i] + i )
     */


    public int maximumAbsoluteDifference(int[] arr) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            min1 = Math.min(min1, arr[i] + i);
            min2 = Math.min(min2, arr[i] - i);
            max1 = Math.max(max1, arr[i] + i);
            max2 = Math.max(max2, arr[i] - i);

            max1 = Math.max(max1,arr[i] + i);
            max2 = Math.max(max2,arr[i] - i);
            min1 = Math.min(min1,arr[i] + 1);
            min2 = Math.min(min2,arr[i] - 1);
        }

        return Math.max(max1 - min1, max2 - min2);
    }


    /*
    Flipping the Bit.
        You are given a binary string(i.e. with characters 0 and 1) S consisting of characters
        S1, S2, …, SN. In a single operation, you can choose two indices L and R such that
        1 ≤ L ≤ R ≤ N and flip the characters SL, SL+1, …, SR. By flipping, we mean change character 0 to 1 and vice-versa.

        Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised.
        If you don’t want to perform the operation, return an empty array.
        Else, return an array consisting of two elements denoting L and R.
        If there are multiple solutions, return the lexicographically smallest pair of L and R.

        =========================================================================================

        This is a very amazing problem. That I was not able to solve.
        Looking at this problem we come to know that the real problem is to find the max sum sub array, you know the algorithm to be used
        is the kadene's algorithm. but then how you have to implement is the real tough part.
        See if we have more 0s in the sub array it is nice and if we have more 1s it is not good.
        So the net benefit is always equal to the number of 0s minus the number of 1s.
        So to make things easy in kadene's algorithm what we can do is that
        we substitute all 0s with 1 and all 1s with -1. so that when we all the number of 0s and number of 1s and
        subtract then we get the net effect.
        Read that again. Let it go inside you.


        Now again when using Kadene's algorithms we didn't maintain the actual array index and we only maintained the
        maximum sum.
        So here is the trick.
        Keep four variables left, right, tempLeft, tempRight.
        Every time you update( tempSum to zero )what you are doing is you are ignoring the previous index and you want to
        start fresh. So what you do is put your tempLeft to next Index.
        Every time you update the maxValue to tempSum you mean that the subArrays sum that is inside the temSum seems to be
        highest till now which means you have got your original left and right indexes.
        And if your tempSum increases by adding the current item value you can say that the tempRight = current index because
        the tempSum is from tempLeft to tempRight.
        Try to think you will understand.


     */


    public int[] flip(String A){


        char[] chars = A.toCharArray();
        int tempSum = 0,tempLeft = 0, tempRight = 0, maxSum = 0, left = 0, right = 0;
        boolean isUpdateRequired = false;

        for(int i = 0; i < chars.length; i++){
            int current = chars[i] == '1' ? -1 : 1;

            if(!isUpdateRequired && (current == 1)){
                isUpdateRequired = true;
            }

            if((tempSum + current) >= 0){
                tempRight = i;
                tempSum += current;
            }
            else{
                tempSum = 0;
                tempLeft = i + 1;
            }

            if(tempSum > maxSum){
                maxSum = tempSum;
                left = tempLeft;
                right = tempRight;
            }
        }

        if(isUpdateRequired)
            return new int[]{left + 1, right + 1};
        else
            return new int[0];
    }
}
