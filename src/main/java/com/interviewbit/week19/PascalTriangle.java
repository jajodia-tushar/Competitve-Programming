package com.interviewbit.week19;

public class PascalTriangle {

    public static void main(String[] args) {

        PascalTriangle obj = new PascalTriangle();
        int[] row = obj.getRow(5);

        for(int i = 0; i < row.length; i++){
            System.out.print(row[i]+" ");
        }

    }
    // This Question is to get kth Row of the Pascal Triangle.
    // Here we use the Simplified form of the Binomial Expression.
    public int[] getRow(int A) {

        int[] res = new int[A + 1];
        res[0] = 1;
        res[A] = 1;

        int x = A;
        for(int i = 1; i < A; i ++){
            res[i] = x;
            x = x * (A - i) / (i + 1);
        }
        return res;
    }


    // This Question is to get the Pascal Triangle
    public int[][] solve(int A) {

        int[][] res = new int[A][];

        for(int i = 0; i < A; i++){
            res[i] = new int[i+1];
            res[i][0] = 1;
            res[i][i] = 1;
        }

        for(int i = 2; i < A; i++){
            for(int j = 1;j < i ;j++){
                res[i][j] = res[i - 1][ j - 1] + res[i - 1][j];
            }
        }

        return res;
    }
}
