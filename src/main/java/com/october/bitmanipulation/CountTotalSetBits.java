package com.october.bitmanipulation;

public class CountTotalSetBits {

    public static void main(String[] args) {
        CountTotalSetBits obj = new CountTotalSetBits();
        System.out.println(obj.solve(2147483645));
    }

    public int solve(int A) {
        if(A == 1){
            return 1;
        }
        A++;
        int MOD = 1000000007;
        int count = 0;
        int i = 2;

        while( A/(i/2) > 0){
            int tempCount = A / i;
            count = (count + (tempCount * i / 2) % MOD) % MOD;
            int rem = ((A % i) > i/2) ? ((A % i) %(i/2)) : 0;
            count = (count + rem) % MOD;
            i = i * 2;
        }
        return (int)(count % MOD);
    }
}
