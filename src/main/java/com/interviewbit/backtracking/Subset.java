package com.interviewbit.backtracking;

import com.interviewbit.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class Subset {

    public static void main(String[] args) {
        int[] ints = ArrayUtils.asArrays(15, 20, 12, 19, 4);
        Subset obj = new Subset();
//        ArrayUtils.printArray(obj.subsets(ints));

        ArrayList<Integer> integers = ArrayUtils.asArrayList(12, 13);
        System.out.println(obj.subsets(integers));

    }

    public int[][] subsets(int[] A) {

        Arrays.sort(A);
        int n = A.length;
        int[][] arr = new int[(int)Math.pow(2,n)][];
        arr[0] = new int[0];
        int k = 1;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                arr[k] = new int[j - i + 1];
                for(int p = i,q = 0; p <= j; p++){
                    arr[k][q++] = A[p];
                }
                k++;
            }
        }
        return arr;
    }

    ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        answer = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        answer.add(new ArrayList<Integer>());
        recursive(0,A,curr);
        return answer;
    }

    public void recursive(int index, ArrayList<Integer> A, ArrayList<Integer> curr){
        if(index == A.size())
            return;

        ArrayList<Integer> newCurr = new ArrayList<>(curr);
        newCurr.add(A.get(index));
        answer.add(newCurr);
        recursive(index + 1,A,newCurr);
        recursive(index + 1,A,curr);
    }
}
