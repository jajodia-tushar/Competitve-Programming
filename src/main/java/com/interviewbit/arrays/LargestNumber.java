package com.interviewbit.arrays;

import java.util.Arrays;

/*
Given a list of non negative integers, arrange them such that they form the largest number.
For example:
Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
Note: The result may be very large, so you need to return a string instead of an integer.

 */
public class LargestNumber {

    public static void main(String[] args) {

    }

    public String largestNumber(final int[] A) {

        int n = A.length;
        String[] strArray = new String[n];
        for (int i = 0; i < n; i++) {
            strArray[i] = String.valueOf(A[i]);
        }

        Arrays.sort(strArray, (a, b) -> (b + a).compareTo(a + b));
        if (strArray[0].equals("0")) return "0";

        StringBuilder result = new StringBuilder();
        for (String str : strArray) {
            result.append(str);
        }
        return result.toString();
    }
}
/*
    Seems easy in the first but it is not really that easy.
    So the Idea is to use comparator it self.
    do A + B and Do B + A so you will know
    which way the string will make greater number.

    Things that won't work.
    Simple sorting [ Because 548 is greater than 60 but in output 60 should come before 548]
    Comparator which takes in account of length as well [ cases like 27 271, 12, 121 will fail because you will place 271 before 27 if
        you even consider length;




 */
