package com.interviewbit.bitmanipulation;


/*
Problem Description

Reverse the bits of an 32 bit unsigned integer A.



Problem Constraints
0 <= A <= 232



Input Format
First and only argument of input contains an integer A.



Output Format
Return a single unsigned integer denoting the decimal value of reversed bits.



Example Input
Input 1:

 0
Input 2:

 3


Example Output
Output 1:

 0
Output 2:

 3221225472


Example Explanation
Explanation 1:

        00000000000000000000000000000000

=>      00000000000000000000000000000000
Explanation 2:

        00000000000000000000000000000011
=>      11000000000000000000000000000000


 */
public class ReverseBits {

    public static void main(String[] args) {
        ReverseBits obj = new ReverseBits();
        System.out.println(obj.reverse(2147483647));
    }

    public long reverse(long a) {

        int num = 32;
        int i = 0;
        long finalAns = 0;

        while (i <= num) {

            long temp = 1L << i;
            if ((temp & a) >= 1) {
                finalAns = finalAns | (1L << (num - i));
            }
            i++;
        }
        return finalAns;
    }
}
/*
        This question is being very Confusing.
        See it seems to be easy.
        But there was a lot of confusion when using the
        bit and trying to understand the requirement.
        But the Expected Output terminal seems to be broken.


        But the idea shown above works and solves this problem.
 */