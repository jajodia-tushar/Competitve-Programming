package com.interviewbit.backtracking;

import java.util.ArrayList;

import static com.interviewbit.utils.ArrayUtils.*;
/*
        Write a program to solve a Sudoku puzzle by filling the empty cells.
Empty cells are indicated by the character '.'
You may assume that there will be only one unique solution.



A sudoku puzzle,



and its solution numbers marked in red.

Example :

For the above given diagrams, the corresponding input to your program will be

[[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]
and we would expect your program to modify the above array of array of characters to

[[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]


 */


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
        obj.solveSudoku(list);

        System.out.println(list);
    }

    public boolean recursive(ArrayList<ArrayList<Character>> list, int row, int column) {

        int nextRow = row;
        int nextColumn;

        if (row == 9) {
            return true;
        } else if (column == 8) {
            nextColumn = 0;
            nextRow = row + 1;
        } else {
            nextColumn = column + 1;
        }

        int item = list.get(row).get(column) - '0';

        if (item > 0) {
            return recursive(list, nextRow, nextColumn);
        }

        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int i = 0; i < 9; i++) {
            int columnWise = list.get(i).get(column) - '0';
            int rowWise = list.get(row).get(i) - '0';

            if (columnWise > 0) arr[columnWise - 1] = -1;
            if (rowWise > 0) arr[rowWise - 1] = -1;
        }

        // Removing Sub Array Elements.
        int subRow = (row / 3) * 3;
        int subCol = (column / 3) * 3;

        for (int i = subRow; i < subRow + 3; i++) {
            for (int j = subCol; j < subCol + 3; j++) {
                int itemIndex = list.get(i).get(j) - '0';
                if (itemIndex > 0) arr[itemIndex - 1] = -1;
            }
        }

        boolean returnedValue = false;
        for (int i = 0; i < 9; i++) {
            if (arr[i] != -1) {
                list.get(row).set(column, (char) (arr[i] + '0'));
                returnedValue = recursive(list, nextRow, nextColumn);

                if (returnedValue)
                    return true;
            }
        }
        list.get(row).set(column, '.');
        return false;
    }

    ///------------------------Fresh Code --------------------------------------

    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        recursive(0, 0, a);
    }

    public boolean recursive(int row, int column, ArrayList<ArrayList<Character>> board) {

        if (row == 9)
            return true;

        if (column == 9) return recursive(row + 1, 0, board);

        Character currenChar = board.get(row).get(column);
        if (currenChar != '.') return recursive(row, column + 1, board);

        ArrayList<Character> validValues = getValidValues(board, row, column);
        if (validValues == null || validValues.size() == 0) return false;

        for (Character ch : validValues) {
            board.get(row).set(column, ch);
            if (recursive(row, column + 1, board)) return true;
        }
        board.get(row).set(column, '.');
        return false;
    }


    public ArrayList<Character> getValidValues(ArrayList<ArrayList<Character>> board, int row, int column) {

        ArrayList<Character> result = new ArrayList<>();
        result.add('1');
        result.add('2');
        result.add('3');
        result.add('4');
        result.add('5');
        result.add('6');
        result.add('7');
        result.add('8');
        result.add('9');

        ArrayList<Character> boardRow = board.get(row);
        for (Character ch : boardRow) {
            result.remove(ch);
        }

        for (ArrayList<Character> boardCol : board) {
            Character ch = boardCol.get(column);
            result.remove(ch);
        }

        int rRow = (row / 3) * 3;
        int cCol = (column / 3) * 3;

        for (int i = rRow; i < rRow + 3; i++) {
            for (int j = cCol; j < cCol + 3; j++) {
                Character ch = board.get(i).get(j);
                result.remove(ch);
            }
        }

        return result;
    }

}

/*
    The Idea to Solve this Question is simple.

    If you know the basics rule of Sudoku.
    For every cell you can find the valid set of values that it can have.
    Now with classical backtracking technique.
    What you can do is.
    You can try each possible values to see if it gives you the answer.

    you can return true or false depending for back knowledge if this are working right or wrong.

    If suppose valid values size is zero that means you have made some mistake so go back.

    while going back remember to set it to . again.

    So Check the valid values in the 3 * 3 Grid.

    You can do
        subRow = row * 3 / 3
        subCol = col * 3 / 3

        This is little interesting.

        You Can Do this one as well

 */

