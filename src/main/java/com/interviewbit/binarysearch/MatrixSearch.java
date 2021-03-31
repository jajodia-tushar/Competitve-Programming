package com.interviewbit.binarysearch;

public class MatrixSearch {

    public static void main(String[] args) {
        int arr[][] = {{22, 32, 67}};

        MatrixSearch obj = new MatrixSearch();
        System.out.println(obj.searchMatrix(arr,93));
    }

    public int searchMatrix(int[][] A, int B) {

        int n = A.length;
        int m = A[0].length;

        int low = 0;
        int high = n * m - 1;

        while(high >= low){
            int mid = (high + low) / 2;

            int midI = mid / m;
            int midJ = mid % m;

            int midItem = A[midI][midJ];


            if(midItem > B){
                high = mid - 1;
            }
            else if( midItem < B){
                low = mid + 1;
            }
            else{
                return 1;
            }
        }
        return 0;
    }
}

