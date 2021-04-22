package com.interviewbit.dp.lcsvariation;

public class MinimumNumberOfDeletionsAndInsertions {

    public static void main(String[] args) {

        MinimumNumberOfDeletionsAndInsertions obj = new MinimumNumberOfDeletionsAndInsertions();
        String str1 = "heap";
        String str2 = "pea";
        obj.printMinDelAndInsert(str1,str2);

    }

    public void printMinDelAndInsert(String A, String B) {

        LongestCommonSubSequence obj = new LongestCommonSubSequence();
        int n = A.length();
        int m = B.length();

        int lcs = obj.solveIterative(A, B);

        System.out.println("Insertion = " + (m - lcs));
        System.out.println("Deletion = " + (n - lcs));

    }
}
