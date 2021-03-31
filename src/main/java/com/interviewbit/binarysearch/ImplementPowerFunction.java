package com.interviewbit.binarysearch;

public class ImplementPowerFunction {

    public static void main(String[] args) {
        ImplementPowerFunction obj = new ImplementPowerFunction();
        System.out.println(obj.pow(2000,300,86));
    }

    public long pow(long x, long n, int p){
        if( x == 0)
            return 0;

        long res = 1;
        long sum = x;

        while(n > 0){
            if( n % 2 != 0)
                res = (res * sum) % p;
            sum = (sum * sum) % p;
            n = n / 2;
        }
        return res;
    }


    public int pow(int x, int n, int p) {
        int ans = (int) powR(x*1l,n*1l,p);
        return ans < 0 ? ans + p : ans;
    }

    public long powR(long x, long n, int p){
        if( x == 0)
            return 0;

        if( n == 0)
            return 1;

        long res = powR(x,n/2,p);
        res = (res * res ) % p;

        if(n % 2 != 0)
                res = ( x * res ) % p;

        return res;
    }


}
