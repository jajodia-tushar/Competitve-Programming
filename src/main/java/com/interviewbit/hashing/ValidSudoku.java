package com.interviewbit.hashing;

import com.interviewbit.utils.ArrayUtils;

public class ValidSudoku {


    public static void main(String[] args) {
        ValidSudoku obj = new ValidSudoku();
//        String[] arr = {"....5..1.", ".4.3.....", ".....3..1", "8......2.", "..2.7....", ".15......", ".....2...", ".2.9.....", "..4......"};
        String[] arr = {"..5.....6", "....14...", ".........", ".....92..", "5....2...", ".......3.", "...54....", "3.....42.", "...27.6.."};
        ArrayUtils.printArray(arr);
        System.out.println(obj.isValidSudoku(arr));
    }

    public int isValidSudoku(final String[] A) {
        return isValid(A,0,0) ? 1 : 0;
    }

    public static int N = 9;

    public boolean isValid(String[] arr,int row, int column){

        if(column == 9){
            column = 0;
            row = row + 1;
        }

        if(row == 9){
            return true;
        }

        int item = arr[row].charAt(column) - '0';

        if(item < 0){
            return isValid(arr,row,column+1);
        }

        for(int i = 0; i < N; i++){
            int currentRow = arr[row].charAt(i) - '0';
            int currentCol = arr[i].charAt(column) - '0';
            if(item == currentRow && i != column )
                return false;

            if(item == currentCol && i != row)
                return false;
        }

        int subRow = (row / 3) * 3;
        int subCol = (column / 3) * 3;


        for(int i = subRow; i < subRow + 3; i++){
            for(int j = subCol; j < subCol + 3; j++){
                int currItem = arr[i].charAt(j) - '0';
                if(i == row && j == column)
                    continue;
                if(item == currItem)
                    return false;
            }
        }

        return isValid(arr,row,column+1);
    }
}
