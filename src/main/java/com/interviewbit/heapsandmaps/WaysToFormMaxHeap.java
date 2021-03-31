package com.interviewbit.heapsandmaps;

public class WaysToFormMaxHeap {

    public static int MOD = 1000000007;

    public static void main(String[] args) {
        WaysToFormMaxHeap obj = new WaysToFormMaxHeap();
        System.out.println(obj.solve(20));
    }


    public long[][] calculateNCR(int N, int R) {
        long[][] ncr = new long[N + 1][R + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= R; j++) {
                if (i == 0) {
                    ncr[i][j] = 0;
                } else if (i == j || j == 0) {
                    ncr[i][j] = 1;
                } else if (j > i) {
                    ncr[i][j] = 0;
                } else {
                    ncr[i][j] = ncr[i - 1][j - 1] % MOD + ncr[i - 1][j] % MOD;
                }
            }
        }

        return ncr;
    }

    public int calculate(int A, long[][] ncr) {

        if (A <= 1)
            return 1;
        int numberOfNodesInLeft = getNumberOfNodesInLeft(A);
        return (int)
                ((((((ncr[A - 1][numberOfNodesInLeft] % MOD)
                        * (calculate(numberOfNodesInLeft, ncr) % MOD)) % MOD))
                        * (calculate(A - numberOfNodesInLeft - 1, ncr) % MOD)) % MOD);
    }

    public int solve(int A) {

        if (A <= 1)
            return 1;
        long[][] ncr = calculateNCR(A, A);
        return calculate(A, ncr);
    }

    public int getNumberOfNodesInLeft(int A) {
        int h = getHeight(A);
        int maximumNumberOfNodesInHthLevel = 1 << h;
        int numberOfNodesInLastLevel = A - (maximumNumberOfNodesInHthLevel - 1);

        if (numberOfNodesInLastLevel >= (maximumNumberOfNodesInHthLevel / 2))
            return maximumNumberOfNodesInHthLevel - 1;
        else
            return (maximumNumberOfNodesInHthLevel - 1)
                    - ((maximumNumberOfNodesInHthLevel / 2) - numberOfNodesInLastLevel);
    }


    public int getHeight(int A) {
        return (int) (Math.log(A) / Math.log(2));
    }

//    int[] fact = new int[500];
//
//    public int solve(int A) {
//
//        if(A <= 1)
//            return 1;
//
//        int numberOfNodesInLeft = getNumberOfNodesInLeft(A);
//        return calculateCombination(A - 1,numberOfNodesInLeft) * solve(numberOfNodesInLeft)
//                * solve(A - numberOfNodesInLeft - 1);
//    }
//
//    public int factorialModulus(int number){
//        long result = 1;
//        for(int i = 2; i <= number; i++){
//            result = (result * i ) % MOD;
//        }
//        return (int) result;
//    }
//
//    public int calculateCombination(int N, int R){
//        long n = factorialModulus(N);
//        int r = factorialModulus(R);
//        int nr = factorialModulus(N - R);
//
//        long rI = power(r, MOD - 2);
//        long nrI = power(nr, MOD - 2);
//
//        return (int)(((( n * rI ) % MOD ) * nrI ) % MOD);
//    }
//
//    public int power(int number, int power){
//
//        if(power == 0)
//            return 1;
//        if(number == 1)
//            return 1;
//
//
//        long r = power(number,power/2);
//        r = ( r * r ) % MOD;
//
//        if( power % 2 == 0)
//            return (int) r;
//        else
//            return (int)(( r * number) % MOD);
//    }
}
