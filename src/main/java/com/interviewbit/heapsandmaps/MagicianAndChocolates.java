package com.interviewbit.heapsandmaps;

import com.interviewbit.utils.ArrayUtils;

import java.util.Collections;
import java.util.PriorityQueue;

public class MagicianAndChocolates {

    public static int MOD = 1000000007;
    public static void main(String[] args) {

        MagicianAndChocolates obj = new MagicianAndChocolates();
        int[] ints = ArrayUtils.asArrays(2, 4, 6, 8, 10);
        System.out.println(obj.nchoc(5,ints));
    }

    public int nchoc(int A, int[] B) {

        int n = B.length;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++){
            heap.add(B[i]);
        }

        long count = 0;
        while( A-- > 0){
            int number = heap.poll();
            count = (count + number ) % MOD;
            heap.add(number/2);
        }

        return (int)(count % MOD);
    }
}

