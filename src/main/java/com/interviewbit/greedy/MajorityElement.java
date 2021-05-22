package com.interviewbit.greedy;

public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement obj = new MajorityElement();
        int[] ints = {2, 1, 2};

        int result = obj.majorityElement(ints);
        System.out.println(result);


    }

    public int majorityElement(final int[] A) {

        int majorityNumber = A[0];
        int count = 0;
        int n = A.length;

        for (int i = 0; i < n; i++) {

            if (A[i] == majorityNumber) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                majorityNumber = A[i];
                count++;
            }
        }

        return majorityNumber;


    }
}
