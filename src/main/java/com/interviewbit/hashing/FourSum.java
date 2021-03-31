package com.interviewbit.hashing;

import com.interviewbit.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class FourSum {

    public static void main(String[] args) {
//        int[] ints = ArrayUtils.asArrays(9, -8, -10, -7, 7, -8, 2, -7, 4, 7, 0, -3, -4, -5, -1, -4, 5, 8, 1, 9, -2, 5, 10, -5, -7, -1, -6, 4, 1, -5, 3, 8, -4, -10, -9, -3, 10, 0, 7, 9, -8, 10, -9, 7, 8, 0, 6, -6, -7, 6, -4, 2, 0, 10, 1, -2, 5, -2);
        int[] ints = ArrayUtils.asArrays(10, 20, 30, 40, 1, 2);
        FourSum obj = new FourSum();
        int[][] result = obj.fourSum(ints, 91);
        ArrayUtils.printArray(result);
    }

    public int[][] fourSum(int[] A, int B) {

        int n = A.length;
        int size = (n * (n - 1) )/ 2;
        Pair[] pairs = new Pair[size];

        int k  = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                pairs[k++] = new Pair(i,j,A[i]+A[j]);
            }
        }
        Arrays.sort(pairs, Comparator.comparing(x -> x.sum));

        int i = 0;
        int j = size - 1;

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        while( i < n && j >= 0) {

            Pair first = pairs[i];
            Pair second = pairs[j];

            if (first.sum + second.sum == B && !isCommon(first, second)) {
                ArrayList<Integer> r = new ArrayList<>();
                r.add(first.first);
                r.add(first.second);
                r.add(second.first);
                r.add(second.second);
                result.add(r);
                i++;
                j--;
            } else if (first.sum + second.sum < B) {
                i++;
            } else {
                j--;
            }
        }

        int[][] resultInt = new int[result.size()][4];

        for(int l = 0; l < result.size(); l++){
            resultInt[l] = new int[4];
            for(int m = 0; m < 4; m++){
                resultInt[l][m] = A[result.get(l).get(m)];
            }
        }

        return resultInt;
    }

    public boolean isCommon(Pair a, Pair b){
        return a.first == b.first && a.first == b.second
                && a.second == b.first && a.second == b.second;
    }
}

class Pair {
    public int first;
    public int second;
    public int sum;

    Pair(int first, int second, int sum) {
        this.first = first;
        this.second = second;
        this.sum = sum;
    }
}