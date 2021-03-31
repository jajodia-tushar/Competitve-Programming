package com.interviewbit.twopointer;

import com.interviewbit.utils.ArrayUtils;

import java.util.ArrayList;

public class MergeTwoSortedListII {

    public static void main(String[] args) {

        MergeTwoSortedListII obj = new MergeTwoSortedListII();
        ArrayList<Integer> a = ArrayUtils.asArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        ArrayList<Integer> b = ArrayUtils.asArrayList(11, 111, 1111,32111 , 111111, 999999);
        obj.merge(a,b);
        System.out.println(a);
    }

    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {

        int j = 0;
        int i = a.size() - 1;
        while(j < b.size()){
            a.add(0);
            j++;
        }

        int k = a.size() - 1;
        j--;

        while(i >= 0 && j >= 0){

            int A = a.get(i);
            int B = b.get(j);

            if(A > B){
                a.set(k,A);
                i--;
            }
            else{
                a.set(k,B);
                j--;
            }
            k--;
        }

        if( i == -1){
            while( j >= 0){
                a.set(k,b.get(j));
                j--;
                k--;
            }
        }

    }
}
