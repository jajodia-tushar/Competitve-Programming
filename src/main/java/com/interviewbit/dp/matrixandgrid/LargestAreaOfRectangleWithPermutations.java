package com.interviewbit.dp.matrixandgrid;

public class LargestAreaOfRectangleWithPermutations {

    public static void main(String[] args) {

        LargestAreaOfRectangleWithPermutations obj = new LargestAreaOfRectangleWithPermutations();
        int mat[][] = {{0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1},
                {1, 1, 0, 1, 0}};
        System.out.println("Area of the largest rectangle is " + obj.maxArea(mat));

    }

    int maxArea(int mat[][]) {
        int R = mat.length;
        int C = mat[0].length;

        // An auxiliary array to store count of consecutive 1's
        // in every column.
        int hist[][] = new int[R + 1][C + 1];

        // Step 1: Fill the auxiliary array hist[][]
        for (int i = 0; i < C; i++) {
            // First row in hist[][] is copy of first row in mat[][]
            hist[0][i] = mat[0][i];

            // Fill remaining rows of hist[][]
            for (int j = 1; j < R; j++) {
                hist[j][i] = (mat[j][i] == 0) ? 0 : hist[j - 1][i] + 1;
            }
        }

        // Step 2: Sort rows of hist[][] in non-increasing order
        for (int i = 0; i < R; i++) {
            int count[] = new int[R + 1];

            // counting occurrence
            for (int j = 0; j < C; j++) {
                count[hist[i][j]]++;
            }

            // Traverse the count array from right side
            int col_no = 0;
            for (int j = R; j >= 0; j--) {
                if (count[j] > 0) {
                    for (int k = 0; k < count[j]; k++) {
                        hist[i][col_no] = j;
                        col_no++;
                    }
                }
            }
        }

        // Step 3: Traverse the sorted hist[][] to find maximum area
        int curr_area, max_area = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // Since values are in decreasing order,
                // The area ending with cell (i, j) can
                // be obtained by multiplying column number
                // with value of hist[i][j]
                curr_area = (j + 1) * hist[i][j];
                if (curr_area > max_area) {
                    max_area = curr_area;
                }
            }
        }
        return max_area;
    }

    public int solve(int[][] A) {

        int row = A.length;
        int col = A[0].length;
        int[][] countArray = new int[row + 1][col + 1];

        for(int j = 0; j < row; j++){
            int count = 0;
            for(int i = 0; i < col; i++){
                if(A[j][i] == 0) count = 0;
                else count++;
                countArray[j][i] = count;
            }
        }

        // Sorting
        for(int i = 0; i < row; i++){
            int[] count = new int[row + 1];
            for(int j = 0; j < col; j++){
                count[countArray[i][j]]++;
            }

            int countIndex = 0;
            for(int j = col; j >= 0; j--){
                if(count[j] > 0){
                    for(int k = 0; k < count[j]; k++ ){
                        countArray[i][countIndex++] = j;
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < row; i++){
            int curr = 0;
            for(int j = 0; j < col; j++){

                curr = countArray[i][j] * j + 1;
                max = Math.max(max,curr);
            }
        }

        return max;


    }
}
