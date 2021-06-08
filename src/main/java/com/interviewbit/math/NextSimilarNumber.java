package com.interviewbit.math;

import java.util.Arrays;

public class NextSimilarNumber {
    public static void main(String[] args) {

        NextSimilarNumber obj = new NextSimilarNumber();
        String result = obj.solve("131232352");
        System.out.println(result);

    }

    public String solve(String A) {

        int n = A.length();
        char[] charArray = A.toCharArray();

        int maxJ = 0;
        int i = n - 1;
        for (; i > 0; i--) {
            if (charArray[i - 1] < charArray[i]) {
                maxJ = i;
                break;
            }
        }

        if (maxJ == 0) {
            return "-1";
        }

        for (int j = i + 1; j < n; j++) {
            if (charArray[j] > charArray[i - 1] && charArray[j] < charArray[maxJ]) {
                maxJ = j;
            }
        }

        swap(charArray, i - 1, maxJ);
        Arrays.sort(charArray, i, n);

        return new String(charArray);
    }

    public void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }
}

/*

    There is nothing much in this question as well.
    Refer to the similar question as next Permutation in Arrays Section
 */
