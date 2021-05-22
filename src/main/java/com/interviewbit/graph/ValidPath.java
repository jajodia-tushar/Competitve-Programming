package com.interviewbit.graph;

import java.util.*;

public class ValidPath {

    public static void main(String[] args) {

        ValidPath obj = new ValidPath();
        int A = 14;
        int B = 3;
        int C = 9;
        int D = 0;
        int[] E = {3, 3, 0, 11, 8, 11, 14, 8, 4};
        int[] F = {1, 0, 2, 2, 0, 2, 3, 2, 1};
        String result = obj.solve(A, B, C, D, E, F);
        System.out.println(result);
    }

    public String solve(int A, int B, int C, int D, int[] E, int[] F) {

        boolean[][] visited = new boolean[A + 1][B + 1];
        Queue<Point> queue = new LinkedList<>();
        int[] X = {0, 0, 1, 1, 1, -1, -1, -1};
        int[] Y = {1, -1, 0, 1, -1, 0, 1, -1};

        Point point = new Point();
        point.x = 0;
        point.y = 0;
        queue.add(point);

        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            if (!visited[curr.x][curr.y]) {
                visited[curr.x][curr.y] = true;
                for (int i = 0; i < 8; i++) {
                    boolean validPoint = true;
                    for (int j = 0; j < 8; j++) {
                        Point newPoint = new Point(curr.x + X[i], curr.y + Y[j]);
                        if (inRange(newPoint, A, B)) {
                            for (int k = 0; k < C; k++) {
                                int centerX = E[k];
                                int centerY = F[k];
                                if (insideCircle(newPoint, centerX, centerY,D)) {
                                    validPoint = false;
                                    break;
                                }
                            }
                            if (validPoint) {
                                queue.add(newPoint);
                            }
                        }
                    }
                }
            }
        }

        return visited[A][B] ? "YES" : "NO";

    }

    public boolean inRange(Point point, int x, int y) {
        return point.x >= 0 && point.x <= x && point.y >= 0 && point.y <= y;
    }

    public boolean insideCircle(Point point, int x, int y, int radius) {
        int distance = distance(point.y,y,point.x,x);
        return distance <= radius;
    }

    public int distance(int y2, int y1, int x2, int x1) {
        int yDiv = y2 - y1;
        int xDiv = x2 - x1;
        return (int) Math.ceil(
                Math.sqrt(
                        Math.pow(yDiv, 2) + Math.pow(xDiv, 2)));
    }
}

class Point {
    public int x;
    public int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
