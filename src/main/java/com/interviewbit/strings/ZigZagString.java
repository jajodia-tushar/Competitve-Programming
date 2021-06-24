package com.interviewbit.strings;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P.......A........H.......N
..A..P....L....S....I...I....G
....Y.........I........R
And then read line by line: PAHNAPLSIIGYIR

Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
**Example 2 : **

ABCD, 2 can be written as

A....C
...B....D
and hence the answer would be ACBD.
 */
public class ZigZagString {

    public static void main(String[] args) {
        ZigZagString obj = new ZigZagString();
        System.out.println(obj.convert("PAYPALISHIRING", 4));
    }

    public String convert(String A, int B) {

        if (B == 1)
            return A;

        StringBuilder[] strArray = new StringBuilder[B];
        int currentRow = 0;
        boolean directionDown = true;

        for (int i = 0; i < A.length(); i++) {
            if (strArray[currentRow] == null)
                strArray[currentRow] = new StringBuilder();

            strArray[currentRow].append(A.charAt(i));

            if (directionDown) {
                if ((1 + currentRow) == B) directionDown = false;
            } else {
                if ((currentRow - 1) == -1) directionDown = true;
            }

            if (directionDown) currentRow++;
            else currentRow--;
        }

        StringBuilder finalString = new StringBuilder();
        for (int i = 0; i < B; i++) {
            if (strArray[i] != null)
                finalString.append(strArray[i]);
        }
        return finalString.toString();
    }
}
/*
        This One is Really Simple
 */