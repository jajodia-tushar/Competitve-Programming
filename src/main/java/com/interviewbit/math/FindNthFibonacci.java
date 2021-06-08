package com.interviewbit.math;

public class FindNthFibonacci {

    public static void main(String[] args) {

        FindNthFibonacci obj = new FindNthFibonacci();
        int result = obj.fibO(10);
        System.out.println(result);
    }

    int MOD = 1000000007;

    public int solve(int A) {
        return fibO(A);
    }

    public int fibO(int A) {
        long[][] base = new long[][]{{1, 1}, {1, 0}};
        power(base, A - 1);
        return (int) base[0][0];
    }

    public void power(long[][] base, int p) {

        long[][] aux = new long[][]{{1, 1}, {1, 0}};

        while (p > 0) {
            if (p % 2 == 1) {
                multiply(base, aux);
            }
            p = p / 2;
            multiply(aux, aux);
        }
    }

    public void multiply(long[][] A, long[][] B) {

        long a = (A[0][0] * B[0][0]) % MOD + (A[0][1] * B[1][0]) % MOD;
        long b = (A[0][0] * B[0][1]) % MOD + (A[0][1] * B[1][1]) % MOD;
        long c = (A[1][0] * B[0][0]) % MOD + (A[1][1] * B[1][0]) % MOD;
        long d = (A[1][0] * B[0][1]) % MOD + (A[1][1] * B[1][1]) % MOD;

        A[0][0] = a % MOD;
        A[0][1] = b % MOD;
        A[1][0] = c % MOD;
        A[1][1] = d % MOD;
    }
}

/*
    Matrix [ 1 1 ]
           [ 1 0 ]
    Is a special matrix such that nth power of the matrix gives n + 1th Fibonacci number.
    So we are multiplying and using this technique.






 */
