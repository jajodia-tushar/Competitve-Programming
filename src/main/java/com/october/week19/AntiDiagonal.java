package com.october.week19;

public class AntiDiagonal {

    public static void main(String[] args) {

        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        AntiDiagonal obj = new AntiDiagonal();
        int[][] diagonal = obj.diagonal(arr);

        for(int i = 0; i < diagonal.length; i++){
            for(int j = 0; j < diagonal[i].length; j++){
                System.out.print(diagonal[i][j]+" ");
            }
            System.out.println();
        }

    }

    public int[][] diagonal(int[][] arr) {

        int n = arr.length;
        int size = n + n - 1;
        int[][] res = new int[size][];

        for(int k = 0; k < n; k++){
            int row = 0;
            res[k] = new int[(k+1)];
            for(int column = k; column >= 0; column--){
                res[k][row] = arr[row][column];
                row++;
            }
        }

        for(int k = 0; k < n - 1; k++){
            res[n+k] = new int[(n - k - 1)];
            int b = 0;
            int row = k + 1;
            for(int column = (n - 1); column > k; column--,b++){
                res[n+k][b] = arr[row][column];
                row++;
            }
        }
        return res;
    }
}
