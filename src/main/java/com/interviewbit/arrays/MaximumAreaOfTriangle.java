package com.interviewbit.arrays;


/*
Problem Description

Given a character matrix of size N x M in the form of a string array A of size N where A[i] denotes ith row.

Each character in the matrix consists any one of the following three characters {'r', 'g', 'b'} where 'r' denotes red color similarly 'g' denotes green color and 'b' denotes blue color.

You have to find the area of the largest triangle that has one side parallel to y-axis i.e vertical and the color of all three vertices are different.
NOTE:
If the area comes out to be a real number than return the ceil of that number.
Problem Constraints
2 <= N, M <= 103
A[i][j] = 'r' or A[i][j] = 'g' or A[i][j] = 'b'

Input Format
First and only argument is an string array A of size N denoting the 2D character matrix.

Output Format
Return a single integer denoting the area of the largest triangle that has one side parallel to y-axis i.e vertical and the color of all three vertices are different.
If the area comes out to be a real number than return the ceil of that number.
Example Input
Input 1:


 */
public class MaximumAreaOfTriangle {

    public static void main(String[] args) {

    }


}

/*
bbrbbb
brgrbb
rbbggb
rggggr
rrggrb
grrbrg
gbbrrg
grgrbb
bbbrgr
bbrrgg
rggrbg
rrgggg
ggbbgb
grggbb
rrrbrr
rrrbrb
bbbbbb
rbbbrg
ggbbbg
ggbggr
bggrgb
bbrrrb
rbrrbb
brbgrg
rbrrrg
bbrrgg
rbgrgg

2 26
5 19
0 25

1 23
3 20
0 26

0 25
1 26
2 23

1 26
2 23
0 18

4 24
2 26
0 22

3 19
5 26
0 22
 */