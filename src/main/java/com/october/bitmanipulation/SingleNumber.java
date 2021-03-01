package com.october.bitmanipulation;

public class SingleNumber {

    public static void main(String[] args) {
        SingleNumber obj = new SingleNumber();
        System.out.println(obj.singleNumber(new int[]{1, 2, 2, 3, 1}));
    }

    public int singleNumber(final int[] A) {
        int num = 0;
        for(int i = 0; i < A.length; i++){
            num = num ^ A[i];
        }
        return num;
    }
}
