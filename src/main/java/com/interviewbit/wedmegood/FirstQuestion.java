package com.interviewbit.wedmegood;

import java.util.Arrays;

public class FirstQuestion {

    public static void main(String[] args) {
        FirstQuestion obj = new FirstQuestion();
        int[] ints = {-1, -3};
        int result = obj.getFirstMissingInteger(ints);
        System.out.println(result);
    }

    public int getFirstMissingInteger(int[] arr) {

        int n = arr.length;
        Arrays.sort(arr);
        int numberExpected = 1;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                if (arr[i] == numberExpected) {
                    numberExpected++;
                } else {
                    break;
                }
            }
        }

        if (numberExpected == arr[n - 1]) return numberExpected + 1;
        else return numberExpected;
    }
}
