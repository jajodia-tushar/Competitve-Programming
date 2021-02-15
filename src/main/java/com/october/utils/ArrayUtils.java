package com.october.utils;

public class ArrayUtils {
    public static void printArray(int[] arr) {
        System.out.print("[ ");
        for( int x : arr){
            System.out.print(x + ", ");
        }
        System.out.println("]");
    }

    public static void printArray(int[][] arr){
        for(int i = 0 ; i < arr.length; i++){
            System.out.print("[ ");
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("] ");
        }
    }
}
