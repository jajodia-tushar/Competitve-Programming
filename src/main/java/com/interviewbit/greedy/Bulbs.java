package com.interviewbit.greedy;

public class Bulbs {

    public static void main(String[] args) {
        Bulbs obj = new Bulbs();
        int[] arr = {0, 1, 0, 1};
        int result = obj.bulbs(arr);
        System.out.println(result);
    }

    public int bulbs(int[] A) {

        int n = A.length;
        int count = 0;
        boolean lookForZero = true;

        for (int i = 0; i < n; i++) {

            if (A[i] == 0 && lookForZero) {
                count++;
                lookForZero = false;
            }

            if (A[i] == 1 && !lookForZero) {
                count++;
                lookForZero = true;
            }
        }
        return count;
    }
}
