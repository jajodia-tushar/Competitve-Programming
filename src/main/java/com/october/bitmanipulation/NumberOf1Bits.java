package com.october.bitmanipulation;

public class NumberOf1Bits {

    public static void main(String[] args) {
        NumberOf1Bits obj = new NumberOf1Bits();
        System.out.println(obj.numSetBits(4294967295L));
    }

    public int numSetBits(long a) {
        int count = 0;
        long i = 0;
        long x = 1;

        while( a >= x){
            if((a & x) >= 1)
                count++;
            i++;
            x = 1L << i;
        }

        return count;
    }
}
