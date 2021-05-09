package com.interviewbit.dp.dptricky;

public class LongestValidParentheses {

    public static void main(String[] args) {

        LongestValidParentheses obj = new LongestValidParentheses();
        int result = obj.longestValidParentheses("(()()()())");
        System.out.println(result);


    }

    public int longestValidParentheses(String s) {
        if (s.length() <= 1)
            return 0;

        int curMax = 0;
        int[] longest = new int[s.length() + 1];

        for (int i = 1; i <= s.length(); i++)
        {
            char currentChar = s.charAt(i - 1);
            if(currentChar == '(') continue;
            if( i - 1 <= 0) continue;

            if( s.charAt(i - 2) == '('){
                longest[i] = longest[i - 2] + 2;
            }
            else if(i - longest[i - 1] - 1 > 0 &&
                    s.charAt(i - longest[i - 1] - 2) == '('){
                longest[i] = longest[i - 1] + 2 + longest[i - longest[i - 1] - 2];
            }
            curMax = Math.max(curMax,longest[i]);
        }
        return curMax;
    }
}
