package com.interviewbit.dp.mcmvariation;

import java.util.Arrays;

public class EvaluateExpressionToTrue {
    private int MOD = 1003;
    private int[][] dpT;
    private int[][] dpF;

    public static void main(String[] args) {

        EvaluateExpressionToTrue obj = new EvaluateExpressionToTrue();
        String str = "T^T^T^F|F&F^F|T^F^T";
        int result = obj.countNumberOfWays(str, true);
        System.out.println(result);

    }

    private int countNumberOfWays(String str, boolean b) {

        int n = str.length();
        this.dpF = new int[n][n];
        this.dpT = new int[n][n];

        for(int[] a : dpT) Arrays.fill(a,-1);
        for(int[] a : dpF) Arrays.fill(a,-1);

        int result = solve(str, 0, n - 1, true);
        return result;
    }

    private int solve(String str, int i, int j, boolean toEvaluate) {

        if( i > j) return 0;

        if(i == j){
            char currentChar = str.charAt(i);
            int value = toEvaluate ^ currentChar == 'T' ? 0 : 1;
             if(toEvaluate) return dpT[i][j] = value;
             else return dpF[i][j] = value;
        }
        if(toEvaluate && dpT[i][j] != -1) return dpT[i][j];
        if(!toEvaluate && dpF[i][j] != -1) return dpF[i][j];

        int ans = 0;
        for (int k = i + 1; k < j; k += 2) {
            String operator = str.substring(k, k + 1);
            int leftTrue = solve(str, i, k-1, true);
            int leftFalse = solve(str, i, k-1, false);
            int rightTrue = solve(str, k + 1, j, true);
            int rightFalse = solve(str, k + 1, j, false);

            switch (operator) {
                case "&":
                    if(toEvaluate) ans +=  (leftTrue * rightTrue) % MOD;
                    else ans +=  (leftFalse * rightFalse + leftFalse * rightTrue + leftTrue * rightFalse) % MOD;
                    break;
                case "|":
                    if(toEvaluate) ans += (leftTrue * rightTrue + leftFalse * rightTrue + leftTrue * rightFalse) % MOD;
                    else ans += (leftFalse * rightFalse) % MOD;
                    break;
                case "^":
                    if(toEvaluate) ans += (leftTrue * rightFalse + leftFalse * rightTrue) % MOD;
                    else ans += (leftFalse * rightFalse + leftTrue * rightTrue) % MOD;
                    break;
            }
        }
        if(toEvaluate) return dpT[i][j] = ans % MOD;
        else return dpF[i][j] = ans % MOD;
    }

}
