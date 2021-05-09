package com.interviewbit.dp.mcmvariatino;

import java.util.Arrays;

public class ScrambleString {

    public static void main(String[] args) {
        ScrambleString obj = new ScrambleString();
        String A = "ABCD";
        String[] Barr = {"ABCD", "ABDC", "ACBD", "ACDB", "ADCB", "ADBC", "BACD", "BADC", "BCAD", "BCDA", "BDCA", "BDAC", "CBAD", "CBDA", "CABD", "CADB", "CDAB", "CDBA", "DBCA", "DBAC", "DCBA", "DCAB", "DACB", "DABC"};
        System.out.println(Barr.length);
        String B = "BDAC";
//        for (String B : Barr) {
        boolean result = obj.isScrambledOptimized(A, B);
        System.out.println(A + "---" + B + " " + result);
//        }

    }

    public boolean isScrambled(String A, String B) {

        int n = A.length();
        int m = B.length();
        if (n != m) return false;
        if (n == 0) return true;
        if (n == 1) return A.equals(B);
        if (A.equals(B)) return true;

        char[] aArr = A.toCharArray();
        char[] bArr = B.toCharArray();
        Arrays.sort(aArr);
        Arrays.sort(bArr);
        if (!new String(aArr).equals(new String(bArr))) return false;

        for (int i = 1; i < n; i++) {

            String x = A.substring(0, i);
            String xRem = A.substring(i);

            String y = B.substring(0, i);
            String yRem = B.substring(i);

            String xDash = A.substring(n - i);
            String xDashRem = A.substring(0, n - i);

            if ((isScrambled(x, y) && isScrambled(xRem, yRem) ||
                    isScrambled(xDash, y) && isScrambled(xDashRem, yRem))) {
                return true;
            }
        }
        return false;
    }

    public boolean isScrambledOptimized(String A, String B) {

        int length1 = A.length();
        if (length1 != B.length())
            return false;
        if (A.equals(B))
            return true;

        boolean[][][] scrambled = new boolean[length1][length1][length1];

        for (int i = 0; i < length1; ++i) {
            for (int j = 0; j < length1; ++j) {
                scrambled[i][j][0] = (A.charAt(i) == B.charAt(j));
            }
        }

        for (int k = 1; k < length1; ++k) {
            for (int i = 0; i < length1 - k; ++i) {
                for (int j = 0; j < length1 - k; ++j) {
                    scrambled[i][j][k] = false;
                    for (int p = 0; p < k; ++p) {
                        if ((scrambled[i][j][p] && scrambled[i + p + 1][j + p + 1][k - p - 1]) ||
                                (scrambled[i][j + k - p][p] && scrambled[i + p + 1][j][k - p - 1])) {
                            scrambled[i][j][k] = true;
                            break;
                        }
                    }
                }
            }
        }
        return scrambled[0][0][length1 - 1];


    }

}


