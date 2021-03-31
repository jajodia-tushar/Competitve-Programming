package com.interviewbit.bitmanipulation;

public class ReverseBits {

    public static void main(String[] args) {
        ReverseBits obj = new ReverseBits();
        System.out.println(obj.reverse(3));
    }

    public long reverse(long a) {

        int num = 32;
        int i = 0;
        long finalAns = 0;

        while(i <= num){

            long temp = 1L << i;
            if((temp & a) >= 1){
                finalAns = finalAns | (1L << (num - i));
            }
            i++;
        }
        return finalAns;
    }
}