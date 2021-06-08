package com.interviewbit.math;

public class PowerIterative {

    public static void main(String[] args) {

        PowerIterative obj = new PowerIterative();
        int result = obj.power(5, 4);
        System.out.println(result);
    }

    public int power(int A, int B) {

        int res = 1;
        while (B > 0) {
            if (B % 2 == 1) {
                res = res * A;
            }
            B = B / 2;
            A = A * A;
        }

        return res;
    }
}
