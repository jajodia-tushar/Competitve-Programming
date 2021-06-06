package com.interviewbit.arrays;

/*
Given a positive integer n and a string s consisting only of letters D or I, you have to find any permutation of first n positive integer that satisfy the given input string.
D means the next number is smaller, while I means the next number is greater.
Notes
Length of given string s will always equal to n - 1
Your solution should run in linear time and space.
Example :

Input 1:

n = 3

s = ID

Return: [1, 3, 2]



 */

import java.util.*;

public class FindPermutation {

    public static void main(String[] args) {
        FindPermutation obj = new FindPermutation();
        String operations = "IDIDID";
        ArrayList<Integer> result = obj.findPerm(operations, 7);
        System.out.println(result);
    }

    public ArrayList<Integer> findPerm(final String A, int B) {

        int start = 1;
        int end = B;
        int n = A.length();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char ch = A.charAt(i);
            if (ch == 'I') {
                result.add(start++);
            } else {
                result.add(end--);
            }
        }
        result.add(start);

        return result;
    }
}

/*
    There is nothing much in this question really.
    Just keep the range with you and you try to go greedily
    from starting.
    So initially range is 1,n
    Look Code you will understand.


 */