package com.interviewbit.graph;

import java.util.*;

public class KnightOnChessBoard {

    public static void main(String[] args) {

        KnightOnChessBoard obj = new KnightOnChessBoard();
        int A = 8;
        int B = 8;
        int C = 1;
        int D = 1;
        int E = 8;
        int F = 8;

        int result = obj.knight(A, B, C, D, E, F);
        System.out.println(result);
    }

    public int knight(int A, int B, int C, int D, int E, int F) {

        int[] first = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] second = {-1, 1, -2, 2, -2, 2, -1, 1};

        boolean[][] visited = new boolean[A + 1][B + 1];

        Queue<KnightPair> queue = new LinkedList<>();
        KnightPair start = new KnightPair(C, D);
        queue.add(start);

        int count = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                KnightPair curr = queue.poll();
                visited[curr.x][curr.y] = true;
                // System.out.println("I am at ("+ curr.x +","+ curr.y+")" + count);
                if (curr.x == E && curr.y == F) {
                    return count;
                }

                for (int j = 0; j < 8; j++) {
                    int nextX = curr.x + first[j];
                    int nextY = curr.y + second[j];
                    if (isSafe(A, B, nextX, nextY, visited)) {
                        queue.add(new KnightPair(nextX, nextY));
                    }
                }
            }
            count++;
        }
        return -1;
    }

    public boolean isSafe(int A, int B, int C, int D, boolean[][] visited) {
        return C >= 1 && C <= A && D >= 1 && D <= B && !visited[C][D];
    }
}

class KnightPair {
    public int x;
    public int y;

    public KnightPair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
