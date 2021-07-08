package com.interviewbit.hashing;

import java.util.HashMap;

/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example :

Given numerator = 1, denominator = 2, return "0.5"
Given numerator = 2, denominator = 1, return "2"
Given numerator = 2, denominator = 3, return "0.(6)"
 */
public class Fraction {

    public static void main(String[] args) {

        Fraction obj = new Fraction();
        String result = obj.fractionToDecimal(-2147483648, -1);
        System.out.println(result);

    }

    public String fractionToDecimal(int num, int den) {
        if (num == 0) return "0";
        if (den == 0) return "";

        StringBuilder result = new StringBuilder();
        if ((num < 0) ^ (den < 0)) result.append("-");

        long A = Math.abs((long) num);
        long B = Math.abs((long) den);

        long integral = A / B;
        result.append(integral);
        long reminder = A % B;
        if (reminder == 0) return result.toString();

        result.append(".");
        HashMap<Long, Integer> repeatedMap = new HashMap<>();
        reminder *= 10;

        while (reminder != 0) {
            if (repeatedMap.containsKey(reminder)) {
                int index = repeatedMap.get(reminder);
                return result.substring(0, index) + "(" + result.substring(index) + ")";
            } else {
                repeatedMap.put(reminder, result.length());
                long quotient = reminder / B;
                reminder %= B;
                reminder *= 10;
                result.append(quotient);
            }
        }

        return result.toString();

    }
}

/*
    Don't be too much afraid from this question.
    It is easy.

    See if the answer has no decimal it is very easy.
    If it has Decimal
        Get the remainder part after division and keep dividing until reminder part becomes zero.
        1. Terminating.
                If decimal is terminating reminder is going to become zero.
        2. Repeating
                If decimal is repeating you can have a hashMap to keep the remainder and the position in the
                result where you have seen that repeat in the result. (Generally speaking length.)
                Then just substring and put the braces.
 */
