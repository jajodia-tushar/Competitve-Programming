package com.october.bitmanipulation;

public class SingleNumberII {

    public static void main(String[] args) {

        SingleNumberII obj = new SingleNumberII();
        System.out.println(obj.singleNumber(new int[]{1, 2, 4, 3, 3, 2, 2, 3, 1, 1}));
    }

    public int singleNumber(final int[] A) {

        long[] count = new long[32];
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < 32; j++){
                if((A[i] & (1L << j)) >= 1){
                    count[j]++;
                }

                count[j] = count[j] % 3;
            }
        }
        long num = 0;
        for(int i = 31; i >= 0; i--){
            if( count[i] == 1){
                num = num + ( 1L << i);
            }
        }
        return (int)num;
    }
}
