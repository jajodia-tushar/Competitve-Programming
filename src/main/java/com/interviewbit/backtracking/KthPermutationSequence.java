package com.interviewbit.backtracking;

import java.util.ArrayList;

/*
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3 ) :

1. "123"
2. "132"
3. "213"
4. "231"
5. "312"
6. "321"
Given n and k, return the kth permutation sequence.

For example, given n = 3, k = 4, ans = "231"

 Good questions to ask the interviewer :
What if n is greater than 10. How should multiple digit numbers be represented in string?
 In this case, just concatenate the number to the answer.
so if n = 11, k = 1, ans = "1234567891011"
Whats the maximum value of n and k?
 In this case, k will be a positive integer thats less than INT_MAX.
n is reasonable enough to make sure the answer does not bloat up a lot.
 */

public class KthPermutationSequence {

    public static void main(String[] args) {
        KthPermutationSequence obj = new KthPermutationSequence();
        System.out.println(obj.getPermutation(5, 100));
    }

    int[] fact;

    public String getPermutation(int n, int k) {

        this.fact = new int[n];
        generateFactorials(n);

        ArrayList<String> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(String.valueOf(i));
        }
        return findOrder(numbers, k - 1);
    }

    public String findOrder(ArrayList<String> numbers, int k) {

        int size = numbers.size();
        if (size == 0) return "";

        int nFact = this.fact[size - 1];
        int index = k / nFact;
        k = k % nFact;

        String currentNumber = numbers.get(index);
        numbers.remove(index);
        return currentNumber + findOrder(numbers, k);
    }

    public void generateFactorials(int n) {

        this.fact[0] = 1;
        long result = 1;

        for (int i = 1; i < n; i++) {
            result = i * this.fact[i - 1];
            if (result > Integer.MAX_VALUE) this.fact[i] = Integer.MAX_VALUE;
            else this.fact[i] = (int) result;
        }
    }
}

/*
    Go Back and Read from the Copy First.
    This question is simple one.

    You know what numbers are going to be right ? 1 till A.

    Now you are given the permutations, You know how many permutations would be there for a particular
    number,

    There will be a total of n! permutations,
    and each number in n will have (n - 1)! permutations,

    For eg, A = 5, k = 100;

    You know there will be 5! --> 120 Permutations,
       and each n i.e
       1 will have 4! ---> 24 permutations
       2 will have 4! ---> 24 permutations
       3 will have 4! ---> 24 permutations
       4 will have 4! ---> 24 permutations
       5 will have 4! ---> 24 permutations

        More over, The permutation from 1  -- 24  will have 1 in it's first Place,
                                        24 -- 48  will have 2 in it's first Place,
                                        49 -- 72  will have 3 in it's first Place,
                                        73 -- 96  will have 4 in it's first Place,
                                        97 -- 120 will have 5 in it's first Place,

        You are given to find the 100th permutation
            if you do 100 / 24 --> 4 can point to 5 [ if we have array with 1 -- 5, 4th Position will have 5]
            Similarly 100 % 24 --> 4
            Now you actually have to find 4th Permutations from 1,2,3,4 only.

            Can you solve this recursively Now ?
            You have done a similar question in Maths Section as well.
            There you were already given the array.
            and you just had to find the correct permutation.

 */