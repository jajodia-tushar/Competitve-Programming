package com.interviewbit.hashing;

import com.interviewbit.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.HashSet;

public class ValidSudoku {


    public static void main(String[] args) {
        ValidSudoku obj = new ValidSudoku();
//        String[] arr = {"....5..1.", ".4.3.....", ".....3..1", "8......2.", "..2.7....", ".15......", ".....2...", ".2.9.....", "..4......"};
        String[] arr = {"..5.....6", "....14...", ".........", ".....92..", "5....2...", ".......3.", "...54....", "3.....42.", "...27.6.."};
        ArrayUtils.printArray(arr);
        System.out.println(obj.isValidSudoku(arr));
    }

//    public int isValidSudoku(final String[] A) {
//        return isValid(A,0,0) ? 1 : 0;
//    }
//
//    public static int N = 9;
//
//    public boolean isValid(String[] arr,int row, int column){
//
//        if(column == 9){
//            column = 0;
//            row = row + 1;
//        }
//
//        if(row == 9){
//            return true;
//        }
//
//        int item = arr[row].charAt(column) - '0';
//
//        if(item < 0){
//            return isValid(arr,row,column+1);
//        }
//
//        for(int i = 0; i < N; i++){
//            int currentRow = arr[row].charAt(i) - '0';
//            int currentCol = arr[i].charAt(column) - '0';
//            if(item == currentRow && i != column )
//                return false;
//
//            if(item == currentCol && i != row)
//                return false;
//        }
//
//        int subRow = (row / 3) * 3;
//        int subCol = (column / 3) * 3;
//
//
//        for(int i = subRow; i < subRow + 3; i++){
//            for(int j = subCol; j < subCol + 3; j++){
//                int currItem = arr[i].charAt(j) - '0';
//                if(i == row && j == column)
//                    continue;
//                if(item == currItem)
//                    return false;
//            }
//        }
//
//        return isValid(arr,row,column+1);
//    }

    public int isValidSudoku(final String[] A) {
        return recursive(A, 0, 0);
    }

    public int recursive(String[] A, int row, int col) {

        if (row == 9) return 1;
        if (col == 9) return recursive(A, row + 1, 0);

        char currentChar = A[row].charAt(col);
        if (currentChar == '.') return recursive(A, row, col + 1);

        HashSet<Character> validPoints = getValidPoints(A, row, col);

        if (validPoints == null || validPoints.size() == 0) return 0;
        if (!validPoints.contains(currentChar)) return 0;

        return recursive(A, row, col + 1);
    }

    public HashSet<Character> getValidPoints(String[] A, int row, int col) {

        HashSet<Character> result = new HashSet<>();
        result.add('1');
        result.add('2');
        result.add('3');
        result.add('4');
        result.add('5');
        result.add('6');
        result.add('7');
        result.add('8');
        result.add('9');

        for (int i = 0; i < 9; i++) {
            Character ch = A[row].charAt(i);
            if (i != col && ch != '.')
                result.remove(ch);
        }

        for (int i = 0; i < 9; i++) {
            Character ch = A[i].charAt(col);
            if (i != row && ch != '.')
                result.remove(ch);
        }

        int r = row / 3 * 3;
        int c = col / 3 * 3;

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                Character ch = A[i].charAt(j);
                if (ch == '.' || (i == row && j == col))
                    continue;
                result.remove(ch);
            }
        }
        return result;
    }

    public int isValidSudokuOptimized(final String[] A) {

        HashSet<String> sets = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = A[i].charAt(j);
                if (ch != '.') {
                    String row = "r$" + i + "$" + ch;
                    String col = "c$" + j + "$" + ch;
                    String box = "b$" + (i / 3 * 3) + "$" + (j / 3 * 3) + "$" + ch;

                    if (sets.contains(row) || sets.contains(col) || sets.contains(box))
                        return 0;
                    else {
                        sets.add(row);
                        sets.add(col);
                        sets.add(box);
                    }
                }
            }
        }
        return 1;
    }
}
