package com.interviewbit.graph;

import com.interviewbit.utils.ArrayUtils;

/*
An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.

Return the modified image after performing the flood fill.



Example 1:


Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
Example 2:

Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
Output: [[2,2,2],[2,2,2]]


Constraints:

m == image.length
n == image[i].length
1 <= m, n <= 50
0 <= image[i][j], newColor < 216
0 <= sr < m
0 <= sc < n
 */
public class FloodFill {

    public static void main(String[] args) {

        FloodFill obj = new FloodFill();
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;

        int[][] result = obj.floodFill(image, sr, sc, newColor);
        ArrayUtils.printArray(result);

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColour) {

        int row = image.length;
        int col = image[0].length;
        int originalColour = image[sr][sc];
        if (originalColour == newColour) return image;

        dfs(sr, sc, originalColour, newColour, image, row, col);

        return image;

    }

    public boolean isSafe(int x, int y, int m, int n, int[][] image, int colour) {
        return x >= 0 && x < m && y >= 0 && y < n && image[x][y] == colour;
    }

    public void dfs(int x, int y, int originalColour, int newColour, int[][] image, int m, int n) {

        image[x][y] = newColour;

        if (isSafe(x + 1, y, m, n, image, originalColour)) {
            dfs(x + 1, y, originalColour, newColour, image, m, n);
        }

        if (isSafe(x, y + 1, m, n, image, originalColour)) {
            dfs(x, y + 1, originalColour, newColour, image, m, n);
        }

        if (isSafe(x - 1, y, m, n, image, originalColour)) {
            dfs(x - 1, y, originalColour, newColour, image, m, n);
        }

        if (isSafe(x, y - 1, m, n, image, originalColour)) {
            dfs(x, y - 1, originalColour, newColour, image, m, n);
        }

    }

}

/*
    Simple DFS.
    Watch Out No Need to Use Visited Array As Well.

 */