package com.interviewbit.dp.dptricky;

public class WaysToColorA3xNBoard {
    public int MOD = 1000000007;

    public static void main(String[] args) {

        WaysToColorA3xNBoard obj = new WaysToColorA3xNBoard();
        int result = obj.solve(2);
        System.out.println(result);

    }

    public int solve(int A) {
        long color3 = 24;
        long color2 = 12;
        long temp = 0;
        for (int i = 2; i <= A; i++) {
            temp = color3;
            color3 = (11 * color3 + 10 * color2) % MOD;
            color2 = (5 * temp + 7 * color2) % MOD;
        }
        return (int)((color3 + color2) % MOD);
    }
}
