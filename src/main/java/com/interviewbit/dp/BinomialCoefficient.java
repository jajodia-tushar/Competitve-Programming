package com.interviewbit.dp;

/*
    Get NcR.


 */
public class BinomialCoefficient {

    public static void main(String[] args) {

        BinomialCoefficient obj = new BinomialCoefficient();
        int result = obj.nCr(20, 18);
        System.out.println(result);
    }

    int nCr(int n, int r) {
        long ans = 1;
        int MOD = 1000000007;
        for (int i = 1; i <= r; i++) {
            long newAnswer =
                    (((ans % MOD * (n - i + 1) % MOD) % MOD) * power(i, MOD - 2, MOD) % MOD) % MOD;
            ans = newAnswer % MOD;
        }
        return (int) (ans % MOD);
    }

    long power(int a, int b, int MOD) {

        if (a == 0) return 0;
        if (b == 0) return 1;

        long result = power(a, b / 2, MOD);

        result = (result % MOD * result % MOD) % MOD;

        if (b % 2 != 0) {
            result = (result % MOD * a % MOD) % MOD;
        }

        return result % MOD;
    }
}
/*
        nCr can be calculated
        as nCr = nC(r - 1) * (n - r + 1)/r;
        Use this formula.
        Now since you need modulus as well and you have to divide as well,
        So You will need to do inversion.
 */