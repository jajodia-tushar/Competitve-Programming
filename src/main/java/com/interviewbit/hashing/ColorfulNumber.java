package com.interviewbit.hashing;

import java.util.HashSet;

/*
For Given Number N find if its COLORFUL number or not

Return 0/1

COLORFUL number:

A number can be broken into different contiguous sub-subsequence parts.
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
Example:

N = 23
2 3 23
2 -> 2
3 -> 3
23 -> 6
this number is a COLORFUL number since product of every digit of a sub-sequence are different.

Output : 1
 */
public class ColorfulNumber {

    public static void main(String[] args) {
        ColorfulNumber obj = new ColorfulNumber();
        System.out.println(obj.colorful(3245));
    }


    public int colorful(int str) {

        HashSet<Integer> set = new HashSet<>();
        String A = str + "";
        for (int i = 0; i < A.length(); i++) {
            int num = A.charAt(i) - '0';

            if (set.contains(num)) return 0;
            else set.add(num);

            for (int j = i + 1; j < A.length(); j++) {
                num = num * (A.charAt(j) - '0');
                if (set.contains(num)) return 0;
                else set.add(num);
            }
        }
        return 1;
    }
}

/*
    Very Basic Question.
    Use Two loops and HashSet to do what you want.

 */
