package com.interviewbit.math;

public class PowerOfTwoIntegers {

    public static void main(String[] args) {

        PowerOfTwoIntegers obj = new PowerOfTwoIntegers();
        int result = obj.isPower(64);
        System.out.println(result);

    }

    public int isPower(int number) {

        int returnThis = 0;
        for (int A = 1; A * A <= number; A++) {
            for (int P = 2; P < 31; P++) {
                if (Math.pow(A, P) == number) {
                    returnThis = 1;
                    break;
                }
            }
        }

        return returnThis;
    }

}

/*
    No Logic.
 */