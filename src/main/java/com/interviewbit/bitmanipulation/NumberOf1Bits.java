package com.interviewbit.bitmanipulation;

/*
Write a function that takes an unsigned integer and returns the number of 1 bits it has.

Example:

The 32-bit integer 11 has binary representation

00000000000000000000000000001011
so the function should return 3.

Note that since Java does not have unsigned int, use long for Java
 */
public class NumberOf1Bits {

    public static void main(String[] args) {
        NumberOf1Bits obj = new NumberOf1Bits();
        System.out.println(obj.numSetBits(4294967295L));
    }

    public int numSetBits(long a) {
        int count = 0;
        long i = 0;
        long x = 1;

        while (a >= x) {
            if ((a & x) >= 1)
                count++;
            i++;
            x = 1L << i;
        }

        return count;
    }
}

/*
    If you just do 1L << i for 32 bit or 64 bit and see
    if And operation of 1L << i and Number is 1 then increase the
    count and then return count

    But
    If you do And Operation of N with N - 1
    the lowest Set bit will be cleared.

    so you can do this until the n reduced to 0;
 */
