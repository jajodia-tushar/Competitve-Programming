package com.interviewbit.arrays;

import com.interviewbit.utils.ArrayUtils;

public class AddOneToNumber {

    public static void main(String[] args) {

        AddOneToNumber obj = new AddOneToNumber();
        int[] ints = {1, 2, 3};
        int[] result = obj.plusOne(ints);
        ArrayUtils.printArray(result);
    }

    public int[] plusOne(int[] A) {

        int carry = 1;
        int n = A.length;

        for(int i = n - 1; i >= 0; i--){
            int sum = A[i] + carry;
            carry = sum / 10;
            A[i] = sum % 10;
        }

        // For Over Flow Case eg 999
        if( carry == 1){
            int[] newArray = new int[n + 1];
            newArray[0] = carry;
            for(int i = 0; i < n; i++){
                newArray[i + 1] = A[i];
            }
            return newArray;
        }

        int i = 0;
        while( A[i] == 0){
            i++;
        }

        // For Removing Leading Zeroes
        if( i != 0){
            int[] newArray = new int[n - i];
            for(int j = 0; j < newArray.length; j++){
                newArray[j] = A[i++];
            }
            return newArray;
        }

        return A;
    }


}
