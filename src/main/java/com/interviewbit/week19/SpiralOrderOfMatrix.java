package com.interviewbit.week19;

public class SpiralOrderOfMatrix {

    public static void main(String[] args) {

        SpiralOrderOfMatrix obj = new SpiralOrderOfMatrix();

        int[][] ints = obj.generateMatrix(6);

        for(int i = 0; i < ints.length; i ++){
            for(int j = 0; j < ints.length; j++){
                System.out.print(ints[i][j]+"  ");
            }
            System.out.println();
        }
    }
    public int[][] generateMatrix(int A) {
        int[][] arr = new int[A][A];

        int i = 0;
        int j = 0;
        int count = 0;
        double power = Math.pow(A,2);

        while( count < power){
            while(j < A && arr[i][j] == 0){
                arr[i][j] = ++count;
                j++;
            }
            j--;
            i++;

            while(i < A && arr[i][j] == 0){
                arr[i][j] = ++count;
                i++;
            }
            i--;
            j--;

            while(j >= 0 && arr[i][j] == 0){
                arr[i][j] = ++count;
                j--;
            }
            j++;
            i--;

            while(i >= 0 && arr[i][j] == 0){
                arr[i][j] = ++count;
                i--;
            }
            i++;
            j++;
        }
        return arr;



    }
}
