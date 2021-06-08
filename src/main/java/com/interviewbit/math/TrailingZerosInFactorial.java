package com.interviewbit.math;

public class TrailingZerosInFactorial {

    public static void main(String[] args) {
        TrailingZerosInFactorial obj = new TrailingZerosInFactorial();
        int result = obj.trailingZeroes(589);
        System.out.println(result);
    }

    public int trailingZeroes(int A) { //8559680
        int count = 0;
        while (A > 0) {
            A = A / 5;
            count += A;
        }
        return count;
    }
}
