package com.interviewbit.twopointer;

import com.interviewbit.utils.ArrayUtils;

import java.util.ArrayList;

public class IntersectionOfSortedArrays {

    public static void main(String[] args) {
        int[] a = ArrayUtils.asArrays(1, 2, 3, 3, 4, 5, 6);
        int[] b = ArrayUtils.asArrays(3, 3, 5);
        IntersectionOfSortedArrays obj = new IntersectionOfSortedArrays();
        int[] intersect = obj.intersect(a, b);
        ArrayUtils.printArray(intersect);
    }

    public int[] intersect(final int[] A, final int[] B) {

        int i = 0;
        int j = 0;

        ArrayList<Integer> arr = new ArrayList<>();

        while(i < A.length && j < B.length){
            if( A[i] == B[j]){
                arr.add(A[i]);
                i++;
                j++;
            }
            else if(A[i] < B[j]){
                i++;
            }
            else{
                j++;
            }
        }

        return arr.stream().mapToInt(x -> x).toArray();
    }
}
