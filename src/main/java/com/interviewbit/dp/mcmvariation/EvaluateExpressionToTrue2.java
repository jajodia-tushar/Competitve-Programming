package com.interviewbit.dp.mcmvariation;


import java.util.Arrays;

/*
    Given an expression, A, with operands and operators (OR , AND , XOR),
    in how many ways can you evaluate the expression to true, by grouping in different ways?
    Operands are only true and false.
    Return the number of ways to evaluate the expression modulo 103 + 3.
 */
public class EvaluateExpressionToTrue2 {

    public static void main(String[] args) {
        EvaluateExpressionToTrue2 obj = new EvaluateExpressionToTrue2();
        int result = obj.countTrue("F|T^T&F");
        System.out.println(result);
    }

    public int countTrue(String A) {

        int n = A.length();

        int[][] dpT = new int[n + 1][n + 1];
        int[][] dpF = new int[n + 1][n + 1];

        for (int[] a : dpT) Arrays.fill(a, -1);
        for (int[] a : dpF) Arrays.fill(a, -1);

        return recursive(A, 0, n - 1, dpT, dpF, true);

    }

    public int recursive(String A, int i, int j, int[][] dpT, int[][] dpF, boolean toEvaluate) {

        if (i > j) return 0;
        if (i == j) {
            char ch = A.charAt(i);
            return toEvaluate ^ ch == 'T' ? 0 : 1;
        }

        if (toEvaluate && dpT[i][j] != -1) return dpT[i][j];
        if (!toEvaluate && dpF[i][j] != -1) return dpF[i][j];

        int ans = 0;
        for (int k = i + 1; k < j; k += 2) {

            char operator = A.charAt(k);
            int leftTrue = recursive(A, i, k - 1, dpT, dpF, true);
            int leftFalse = recursive(A, i, k - 1, dpT, dpF, false);
            int rightTrue = recursive(A, k + 1, j, dpT, dpF, true);
            int rightFalse = recursive(A, k + 1, j, dpT, dpF, false);

            if (operator == '&') {
                if (toEvaluate)
                    ans += leftTrue * rightTrue;
                else
                    ans += (leftFalse * rightFalse + leftFalse * rightTrue + leftTrue * rightFalse);
            } else if (operator == '|') {
                if (toEvaluate)
                    ans += (leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue);
                else
                    ans += leftFalse * rightFalse;
            } else {
                if (toEvaluate)
                    ans += (leftFalse * rightTrue + leftTrue * rightFalse);
                else
                    ans += (leftTrue * rightTrue + leftFalse * rightFalse);
            }
        }

        if (toEvaluate) {
            return dpT[i][j] = ans;
        } else {
            return dpF[i][j] = ans;
        }
    }
}
