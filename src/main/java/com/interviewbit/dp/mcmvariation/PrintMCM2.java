package com.interviewbit.dp.mcmvariation;

public class PrintMCM2 {

    private char name = 'A';

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        PrintMCM2 obj = new PrintMCM2();
        obj.printMCM(arr);

    }

    public void printMCM(int[] arr){

        MCM2 obj = new MCM2();
        int[][] mcmArray = obj.getMCMPartitionArray(arr);

        recursive(mcmArray,1,arr.length - 1);
    }

    private void recursive(int[][] mcmArray, int i, int j) {

        if(i == j){
            System.out.print(name++);
            return;
        }
        System.out.print("(");
        recursive(mcmArray,i,mcmArray[i][j]);
        recursive(mcmArray,mcmArray[i][j]+1,j);
        System.out.print(")");
    }


}
