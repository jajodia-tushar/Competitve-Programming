package com.interviewbit.graph;

import com.interviewbit.utils.ArrayUtils;

import java.util.ArrayList;

public class CaptureRegionsOnBoard {

    public static void main(String[] args) {

        CaptureRegionsOnBoard obj = new CaptureRegionsOnBoard();
        ArrayList<String> strings = ArrayUtils.asArrayList("XOXXXXOOXX", "XOOOOXOOXX", "OXXOOXXXOO", "OXOXOOOXXO", "OXOOXXOOXX", "OXXXOXXOXO", "OOXXXXOXOO");
        ArrayList<ArrayList<Character>> list = new ArrayList<>();
        for (String str : strings) {
            ArrayList<Character> characterListFromString = ArrayUtils.getCharacterListFromString(str);
            list.add(characterListFromString);
            System.out.println(characterListFromString);
        }

        System.out.println();
        System.out.println();

        obj.solve(list);
        for (ArrayList<Character> l : list) {
            System.out.println(l);
        }

        System.out.println();
        System.out.println();
        ArrayList<String> actualResult = ArrayUtils.asArrayList("XOXXXXOOXX", "XOOOOXOOXX", "OXXOOXXXOO", "OXXXOOOXXO", "OXXXXXOOXX", "OXXXXXXOXO", "OOXXXXOXOO");
        for (String str : actualResult) {
            System.out.println(ArrayUtils.getCharacterListFromString(str));
        }


    }

    public void solve(ArrayList<ArrayList<Character>> a) {

        int row = a.size();
        int col = a.get(0).size();

        for (int i = 0; i < row; i++) {
            char ch = a.get(i).get(0);
            if (ch == 'O') {
                markDFS(i, 0, a);
            }

            ch = a.get(i).get(col - 1);
            if (ch == 'O') {
                markDFS(i, col - 1, a);
            }
        }

        for (int i = 0; i < col; i++) {
            char ch = a.get(0).get(i);
            if (ch == 'O') {
                markDFS(0, i, a);
            }

            ch = a.get(row - 1).get(i);
            if (ch == 'O') {
                markDFS(row - 1, i, a);
            }
        }


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (a.get(i).get(j) == '#') {
                    a.get(i).set(j, 'O');
                } else {
                    a.get(i).set(j, 'X');
                }
            }
        }
    }

    public boolean isSafe(int row, int col, ArrayList<ArrayList<Character>> adj) {
        return row >= 0 && row < adj.size() && col >= 0 && col < adj.get(0).size()
                && adj.get(row).get(col) == 'O';
    }

    public void markDFS(int row, int col, ArrayList<ArrayList<Character>> adj) {
        adj.get(row).set(col, '#');
        if (isSafe(row - 1, col, adj)) markDFS(row - 1, col, adj);
        if (isSafe(row + 1, col, adj)) markDFS(row + 1, col, adj);
        if (isSafe(row, col - 1, adj)) markDFS(row, col - 1, adj);
        if (isSafe(row, col + 1, adj)) markDFS(row, col + 1, adj);
    }

}
