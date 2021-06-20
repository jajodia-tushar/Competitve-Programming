package com.interviewbit.binarysearch;

/*
Implement pow(x, n) % d.

In other words, given x, n and d,

find   (xn  % d)

Note that remainders on division cannot be negative.

In other words, make sure the answer you return is non negative.

Input : x = 2, n = 3, d = 3
Output : 2

2^3 % 3 = 8 % 3 = 2.
 */
public class ImplementPowerFunction {

    public static void main(String[] args) {
        ImplementPowerFunction obj = new ImplementPowerFunction();
        System.out.println(obj.powX(-1, 1, 20));
    }

    public long pow(long x, long n, int p) {
        if (x == 0)
            return 0;

        long res = 1;
        long sum = x;

        while (n > 0) {
            if (n % 2 != 0)
                res = (res * sum) % p;
            sum = (sum * sum) % p;
            n = n / 2;
        }
        return res;
    }


    public int pow(int x, int n, int p) {
        int ans = (int) powR(x, n, p);
        return ans < 0 ? ans + p : ans;
    }

    public long powR(long x, long n, int p) {
        if (x == 0)
            return 0;

        if (n == 0)
            return 1;

        long res = powR(x, n / 2, p);
        res = (res * res) % p;

        if (n % 2 != 0)
            res = (x * res) % p;

        return res;
    }

    public int powX(int x, int n, int mod) {

        if( x == 0) return 0;
        if( n == 0) return 1;

        long res = 1;

        while( n > 0){

            if( n % 2 != 0){
                res = (res * x) % mod;
            }

            long temp = (int)((long)x * (long)x % mod);
            n = n / 2;
        }

        int ans = (int) res;
        return ans < 0 ? ans + mod : ans;
    }
}

/*
    You have done this question number of time now You know this one.

 */