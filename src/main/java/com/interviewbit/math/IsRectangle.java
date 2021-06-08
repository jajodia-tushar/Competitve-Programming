package com.interviewbit.math;


/*
Given four positive integers A, B, C, D, determine if there’s a rectangle such that the lengths of its sides are A, B, C and D (in any order).

If any such rectangle exist return 1 else return 0.



Problem Constraints
1 <= A, B, C, D <= 100



Input Format
First argument is an interger A.

Second argument is an interger B.

Third argument is an interger C.

Fourth argument is an interger D.



Output Format
If any such rectangle exist whose sides are A, B, C, D in any orde then return 1 else return 0.



Example Input
Input 1:

 A = 1
 B = 1
 C = 2
 D = 2
Input 2:

 A = 1
 B = 2
 C = 3
 D = 4


Example Output
Output 1:

 1
Output 2:

 0
 */
public class IsRectangle {

    public static void main(String[] args) {

        IsRectangle obj = new IsRectangle();
        int result = obj.solve(10, 10, 5, 5);
        System.out.println(result);
    }

    public int solve(int A, int B, int C, int D) {

        if (((A - B) == 0) && ((C - D) == 0)) return 1;
        else if (((A - C) == 0) && ((B - D) == 0)) return 1;
        else if (((A - D) == 0) && ((B - C) == 0)) return 1;
        else return 0;
    }

}

/*
    No Explanation needed.

 */