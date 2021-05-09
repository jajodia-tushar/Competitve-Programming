package com.interviewbit.week20;

public class FindTheLargestRepeatingAlphabet {

    public static void main(String[] args) {
        FindTheLargestRepeatingAlphabet obj = new FindTheLargestRepeatingAlphabet();
        String result = obj.getLargestRepeatingSubString("abcabbbccccddddd");
        System.out.println(result);
    }

    public String getLargestRepeatingSubString(String str) {

        int n = str.length();
        int i = 0;
        int j = 1;
        String ans = "";

        while (j < n) {
            if (str.charAt(i) != str.charAt(j)) {
                String temp = str.substring(i, j);
                if (temp.length() > ans.length()) {
                    ans = temp;
                }
                i = j;
            }
            j++;
        }

        String temp = str.substring(i, j);
        if (temp.length() > ans.length()) {
            ans = temp;
        }

        return ans;

    }
}
