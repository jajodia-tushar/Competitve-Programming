package com.interviewbit.math;

public class LargestCoprimeDivisor {

    public static void main(String[] args) {
        LargestCoprimeDivisor obj = new LargestCoprimeDivisor();
        int result = obj.cpFact(50, 12);
        System.out.println(result);
    }

    public int cpFact(int A, int B) {

        int x = gcd(A, B);
        if (x == 1)
            return A;
        return cpFact(A / x, B);


    }

    public int gcd(int A, int B) {
        if (B == 0) return A;
        return gcd(B, A % B);
    }
}

/*
    There are some question that you will have to look how it works.
    There is no way out.
 */