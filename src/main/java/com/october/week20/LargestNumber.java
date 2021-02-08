package com.october.week20;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

            /*
        Largest Number
        Asked in:
        Amazon
        Goldman Sachs
        Microsoft
        Given a list of non negative integers, arrange them such that they form the largest number.

        For example:

        Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

        Note: The result may be very large, so you need to return a string instead of an integer.
         */

    public static void main(String[] args) {
        LargestNumber obj = new LargestNumber();
        System.out.println(obj.largestNumber(new int[]{ 1}));

    }

    public String largestNumber(final int[] A) {

        String[] res = new String[A.length];

        for(int i = 0; i < A.length; i++){
            res[i] = String.valueOf(A[i]);
        }

        Arrays.sort(res, (a,b) -> (b+a).compareTo((a+b)));

        StringBuilder result = new StringBuilder("");

        for(int i = 0; i < res.length; i++){
            if( i == 0 && res[i].equals("0"))
                return "0";
            result.append(res[i]);
        }

        return result.toString();
    }
}
