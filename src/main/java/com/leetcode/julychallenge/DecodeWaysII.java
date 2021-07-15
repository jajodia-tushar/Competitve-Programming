package com.leetcode.julychallenge;

public class DecodeWaysII {

    public static void main(String[] args) {
        DecodeWaysII obj = new DecodeWaysII();
        int result = obj.numDecodings("**");
        System.out.println(result);
    }

    public int numDecodings(String s) {
        int n = s.length();
        return reverse(s, n - 1);
    }

    public int reverse(String str, int index) {

        if (index < 0) return 1;
        if (str.charAt(0) == '0') return 0;

        int n = str.length();

        int resultOne = 0;
        if ((str.charAt(index) - '0') > 0)
            resultOne = reverse(str, index - 1);
        else if (str.charAt(index) == '*') {
            for (int i = 1; i < 10; i++) {
                resultOne += reverse(str, index - 1);
            }
        }

        int resultTwo = 0;
        if (index > 0 && ((str.charAt(index - 1) - '0') < 3) && ((str.charAt(index - 1) - '0') > 0)) {

            if ((str.charAt(index) == '*')) {
                for (int i = 0; i < 7; i++) {
                    resultTwo += reverse(str, index - 2);
                }
            } else if ((str.charAt(index) - '0') < 7) {
                resultTwo = reverse(str, index - 2);
            }

        }
        return resultOne + resultTwo;
    }
}
