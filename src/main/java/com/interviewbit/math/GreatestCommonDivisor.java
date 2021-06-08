package com.interviewbit.math;

public class GreatestCommonDivisor {

    public static void main(String[] args) {

        GreatestCommonDivisor obj = new GreatestCommonDivisor();
        int result = obj.gcd(15, 25);
        System.out.println(result);
    }


    public int gcd(int A, int B) {
        if (B == 0) return A;
        return gcd(B, A % B);
    }
}
