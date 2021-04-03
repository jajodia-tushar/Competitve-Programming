package com.interviewbit.backtracking;

import java.util.ArrayList;

public class KthPermutationSequence {

    public static void main(String[] args) {
        KthPermutationSequence obj = new KthPermutationSequence();
        System.out.println(obj.getPermutation(4,8));
    }

    public String getPermutation(int A, int B) {
        ArrayList<Integer> array = new ArrayList<>();
        for(int i = 1; i <= A; i++){
            array.add(i);
        }
        return findOrder(array,B-1);
    }


    public String findOrder(ArrayList<Integer> array, int k){

        int size = array.size();
        if(size == 0) {
            return "";
        }
        int factN = factorial(size - 1,k);
        int indexValue = k / factN;
        k = k % factN;
        String firstNumber = array.get(indexValue) + "";
        array.remove(indexValue);
        return firstNumber +
                findOrder(array, k);
    }

    public int factorial(long n, long k){
        long result = 1;
        for(int i = 2; i <= n; i++){
            result = result * i;
            if(result > k){
                return (int) result;
            }
        }
        return (int) result;
    }
}

