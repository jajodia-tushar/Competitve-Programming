package com.interviewbit.week20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateMatrix {

    /*
    You are given an n x n 2D matrix representing an image.

    Rotate the image by 90 degrees (clockwise).

    You need to do this in place.

    Note that if you end up using an additional array, you will only receive partial score.

     */

    /*
    This Question Could have been easily solved using Transpose first and then Reverse. Think and Try out some examples.
     */

    public static void main(String[] args) {
        RotateMatrix obj = new RotateMatrix();
        int arr[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        ArrayList<List<Integer>> A = new ArrayList<>();

        A.add(Arrays.asList(1,2,3,4));
        A.add(Arrays.asList(5,6,7,8));
        A.add(Arrays.asList(9,10,11,12));
        A.add(Arrays.asList(13,14,15,16));

        obj.rotate(A);
        System.out.println(A);
    }

    public void rotate(int[][] A) {

        int size = A.length;

        for(int i = 0; i < size/2; i++){
            for(int j = i; j < size - i - 1; j++){
                int temp = A[i][j];
                A[i][j] = A[size - 1 - j][i];
                A[size - 1 - j][i] = A[size - 1 - i][size - 1 - j];
                A[size - 1 - i][size - 1 - j] = A[j][size - 1 - i];
                A[j][size - 1 - i] = temp;
            }
        }

    }

    public void rotate(ArrayList<List<Integer>> A) {

        int size = A.size();

        for(int i = 0; i < size/2; i++){
            for(int j = i; j < size - i - 1; j++){
                int temp = A.get(i).get(j);
                A.get(i).set(j,A.get(size - 1 - j).get(i));
                A.get(size - 1 - j).set(i,A.get(size - 1 - i).get(size - 1 - j));
                A.get(size - 1 - i).set(size - 1 - j,A.get(j).get(size - 1 - i));
                A.get(j).set(size - 1 - i,temp);
            }
        }
    }
}
