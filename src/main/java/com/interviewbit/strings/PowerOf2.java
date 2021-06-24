package com.interviewbit.strings;

/*
Find if Given number is power of 2 or not.

More specifically, find if given number can be expressed as 2^k where k >= 1.

Input:

number length can be more than 64, which mean number can be greater than 2 ^ 64 (out of long long range)
Output:

return 1 if the number is a power of 2 else return 0

Example:

Input : 128
Output : 1
 */
public class PowerOf2 {

    public int power(String A) {
        if(A.equals("1"))
            return 0;
        java.math.BigInteger num = new java.math.BigInteger(A);
        while(num.compareTo(java.math.BigInteger.ONE) == 0 || num.compareTo(java.math.BigInteger.ZERO) == 0){
            if(num.mod((java.math.BigInteger.ONE.add(java.math.BigInteger.ONE))).equals(java.math.BigInteger.ONE))return 0;
            num = num.divide((java.math.BigInteger.ONE.add(java.math.BigInteger.ONE)));
        }
        return 1;
    }
}
/*
    You Can Do this Type of Question
 */