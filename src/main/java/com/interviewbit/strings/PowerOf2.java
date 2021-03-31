package com.interviewbit.strings;


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
