package com.interviewbit.backtracking;
import java.util.*;

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
        recursive(board,0,diagonal1,diagonal2,vertical);

        return result;
    }


    public void recursive(int[][] board, int i,
                          Set<Integer> diagonal1, Set<Integer> diagonal2, Set<Integer> vertical){

        if(board.length == i){
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


        for(int j = 0; j < board.length; j++){
            if(!diagonal1.contains(i+j) && !diagonal2.contains(j - i)
                    && !vertical.contains(j)){
                board[i][j] = 1;
                HashSet<Integer> newVertical = new HashSet<>(vertical);
                HashSet<Integer> newD1 = new HashSet<>(diagonal1);
                HashSet<Integer> newD2 = new HashSet<>(diagonal2);
                newVertical.add(j);
                newD1.add(i + j);
                newD2.add(j - i);
                recursive(board,i+1, newD1,newD2, newVertical);
                board[i][j] = 0;
            }
        }


    }
}
