package com.interviewbit.backtracking;

import java.util.ArrayList;

import static com.interviewbit.utils.ArrayUtils.*;

public class Sudoku {

    public static int N = 9;

    public static void main(String[] args) {
        Sudoku obj = new Sudoku();
        ArrayList<ArrayList<Character>> list = new ArrayList<>();

        list.add(asArrayList('5', '3', '.', '.', '7', '.', '.', '.', '.'));
        list.add(asArrayList('6', '.', '.', '1', '9', '5', '.', '.', '.'));
        list.add(asArrayList('.', '9', '8', '.', '.', '.', '.', '6', '.'));
        list.add(asArrayList('8', '.', '.', '.', '6', '.', '.', '.', '3'));
        list.add(asArrayList('4', '.', '.', '8', '.', '3', '.', '.', '1'));
        list.add(asArrayList('7', '.', '.', '.', '2', '.', '.', '.', '6'));
        list.add(asArrayList('.', '6', '.', '.', '.', '.', '2', '8', '.'));
        list.add(asArrayList('.', '.', '.', '4', '1', '9', '.', '.', '5'));
        list.add(asArrayList('.', '.', '.', '.', '8', '.', '.', '7', '9'));
        printCollection(list);
        obj.recursive(list,0,0);
        System.out.println("------------------------------");
        printCollection(list);
    }


//    boolean isValid(ArrayList<ArrayList<Character>> A, int row, int col) {
//        Character elem = A.get(row).get(col);
//
//        //check range
//        if (elem - '0' < 1 || elem - '0' > 9)
//            return false;
//
//        //check row and column for duplicates
//        for (int p = 0; p < N; ++p) {
//            if (A.get(p).get(col) == elem && p != row)
//                return false;
//            if (A.get(row).get(p) == elem && p != col)
//                return false;
//        }
//
//        //check 3x3 subgrid for duplicates
//        int subRow = (row / 3) * 3; //Ex: row = 2 belongs to first subgrid, so to bring back row to index 0
//        int subCol = (col / 3) * 3; //so as to start iterating first subgrid, we do 2/3 = 0 then 0*3 = 0.
//
//        for (int i = subRow; i < subRow + 3; ++i) {
//            for (int j = subCol; j < subCol + 3; ++j) {
//                if (A.get(i).get(j) == elem && (i != row || j != col))
//                    return false;
//            }
//        }
//
//        return true;
//    }

//    boolean sudoku(ArrayList<ArrayList<Character>> A, int row, int col) {
//        if (row == 9)
//            return true;
//
//        int nextRow, nextCol;
//        if (col == 8) {
//            nextRow = row + 1;
//            nextCol = 0;
//        } else {
//            nextRow = row;
//            nextCol = col + 1;
//        }
//
//        if (A.get(row).get(col) != '.') {
//            if (!isValid(A, row, col))
//                return false;
//            return sudoku(A, nextRow, nextCol);
//        }
//
//        for (int i = 1; i <= N; ++i) {
//            A.get(row).set(col, (char) (i + '0'));
//            if (isValid(A, row, col) && sudoku(A, nextRow, nextCol))
//                return true;
//        }
//
//        A.get(row).set(col, '.');
//        return false;
//    }

    public boolean recursive(ArrayList<ArrayList<Character>> list, int row, int column){

        int nextRow = row;
        int nextColumn;

        if(row == 9){
            return true;
        }
        else if( column == 8) {
            nextColumn = 0;
            nextRow = row + 1;
        }
        else{
            nextColumn = column + 1;
        }

        int item = list.get(row).get(column) - '0';

        if(item > 0){
            return recursive(list,nextRow,nextColumn);
        }

        int arr[] = {1,2,3,4,5,6,7,8,9};

        for(int i = 0; i < 9; i++){
            int columnWise = list.get(i).get(column) - '0';
            int rowWise = list.get(row).get(i) - '0';

            if(columnWise > 0) arr[columnWise - 1] = -1;
            if(rowWise > 0) arr[rowWise - 1] = -1;
        }

        // Removing Sub Array Elements.
        int subRow = (row / 3) * 3;
        int subCol = (column / 3) * 3;

        for(int i = subRow; i < subRow + 3; i++){
            for(int j = subCol; j < subCol + 3; j++){
                int itemIndex = list.get(i).get(j) - '0';
                if(itemIndex > 0) arr[itemIndex - 1] = -1;
            }
        }

        boolean returnedValue = false;
        for(int i = 0; i < 9; i++){
            if(arr[i] != -1){
                list.get(row).set(column,(char)(arr[i] + '0'));
                 returnedValue = recursive(list, nextRow, nextColumn);

                 if(returnedValue)
                     return true;
            }
        }
        list.get(row).set(column,'.');
        return false;
    }

//    public void solveSudoku(ArrayList<ArrayList<Character>> A) {
//        if (A.size() != N || A.get(0).size() != N)
//            return;
//        sudoku(A, 0, 0);
//    }
}
