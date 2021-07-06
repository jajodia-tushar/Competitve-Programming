package com.interviewbit.backtracking;

import java.util.*;

/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

N Queens: Example 1

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens’ placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,

There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]

 */
public class NQueen {

    public static void main(String[] args) {
        NQueen obj = new NQueen();
        ArrayList<ArrayList<String>> arrayLists = obj.solveNQueens(4);
        System.out.println(arrayLists);
    }

    private ArrayList<ArrayList<String>> result;

    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        result = new ArrayList<>();
        Set<Integer> diagonal1 = new HashSet<>();
        Set<Integer> diagonal2 = new HashSet<>();
        Set<Integer> vertical = new HashSet<>();
        int[][] board = new int[a][a];
        recursive(board, 0, diagonal1, diagonal2, vertical);

        return result;
    }


    public void recursive(int[][] board, int i,
                          Set<Integer> diagonal1, Set<Integer> diagonal2, Set<Integer> vertical) {

        if (board.length == i) {
            ArrayList<String> tempResult = new ArrayList<>();
            for (int[] ints : board) {
                StringBuilder str = new StringBuilder();
                for (int j = 0; j < board.length; j++) {
                    if (ints[j] == 1)
                        str.append("Q");
                    else
                        str.append(".");
                }
                tempResult.add(str.toString());
            }
            result.add(tempResult);
            return;
        }


        for (int j = 0; j < board.length; j++) {
            if (!diagonal1.contains(i + j) && !diagonal2.contains(j - i)
                    && !vertical.contains(j)) {
                board[i][j] = 1;
                HashSet<Integer> newVertical = new HashSet<>(vertical);
                HashSet<Integer> newD1 = new HashSet<>(diagonal1);
                HashSet<Integer> newD2 = new HashSet<>(diagonal2);
                newVertical.add(j);
                newD1.add(i + j);
                newD2.add(j - i);
                recursive(board, i + 1, newD1, newD2, newVertical);
                board[i][j] = 0;
            }
        }
    }


    public ArrayList<ArrayList<String>> solveNQueensX(int a) {

        result = new ArrayList<>();
        Set<Integer> d1 = new HashSet<>();
        Set<Integer> d2 = new HashSet<>();
        Set<Integer> c1 = new HashSet<>();

        recursive(0, a, d1, d2, c1, new ArrayList<>());
        return result;
    }


    public void recursive(int row, int N, Set<Integer> d1, Set<Integer> d2,
                          Set<Integer> c1, ArrayList<String> currAns) {

        if (row == N) {
            result.add(currAns);
            return;
        }

        String currString = "";
        for (int i = 0; i < N; i++) {
            if (!c1.contains(i) && !d1.contains(row + i) && !d2.contains(row - i)) {
                String currRepresentation = getString(N, i);
                Set<Integer> newC1 = new HashSet<>(c1);
                Set<Integer> newD1 = new HashSet<>(d1);
                Set<Integer> newD2 = new HashSet<>(d2);
                ArrayList<String> newAns = new ArrayList<>(currAns);

                newC1.add(i);
                newD1.add(row + i);
                newD2.add(row - i);
                newAns.add(currRepresentation);
                recursive(row + 1, N, newD1, newD2, newC1, newAns);
            }
        }

    }

    public String getString(int n, int position) {
        String result = "";
        for (int i = 0; i < n; i++) {
            if (i == position) result += "Q";
            else result += ".";
        }
        return result;
    }
}

/*
       The Trick to be very specific in this question is to how to keep track of Diagonals

       See let's clear out things one by one.
       Queen Can attack.
                Row
                Column
                Diagonal

        To Avoid extra Calculations for Row.
        1. For each Queen we will consider they must be in Different Column so we place a queen in one column
            then we more to the next column. (Simple right) ( The other way we won't get valid answers)

        2. For Column we can keep a Set where we keep track of the previous Columns used by previous Queens .
            So before placing Current Queen in current position we see if there is any queen in current Column.

        3. For Diagonal.
            There are actually four Diagonals.
                1 Up Left
                2. Up Right
                3. Down Left
                4. Down Right

               We consider that we are filling the board from top to bottom fashion by doing this we have removed
                diagonal condition 3 and 4 because we know there will not be any queen below us.

               For Up Left.
                if We keep a HashSet where we put the values in (row - column) for previous queen position
                    for eg if queen is at position 2,3 we would place (2 - 3 = -1) in the hashSet.

                   Now if you watch properly all the cell in this diagonal will have -1 as value.
                        (left diagonal is you are adding y and adding x so x - y will be constant) (3,4) (4,5) and so on.

                For Up Right
                    if We keep a HashSet where we put the values in (row + column) for previous queen position
                    for eg if queen is at position 2,3 we would place (2 + 3 = 5) in the hashSet.

                   Now if you watch properly all the cell in this diagonal will have 5 as value.
                        ( right diagonal is you are adding y and decreasing x so x + y will be constant) eg, (1,4),(0,5)

                 Try to visualize .

                 You can Solve this easily Now.
 */