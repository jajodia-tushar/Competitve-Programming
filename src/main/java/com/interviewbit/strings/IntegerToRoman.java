package com.interviewbit.strings;

import java.util.LinkedHashMap;
import java.util.Map;

/*
Please Note:
Another question which belongs to the category of questions which are intentionally stated vaguely.
Expectation is that you will ask for correct clarification or you will state your assumptions before you start coding.

Given an integer A, convert it to a roman numeral, and return a string corresponding to its roman numeral version

 Note : This question has a lot of scope of clarification from the interviewer. Please take a moment to think of all the needed clarifications and see the expected response using “See Expected Output” For the purpose of this question, https://projecteuler.net/about=roman_numerals has very detailed explanations.


Input Format

The only argument given is integer A.
Output Format

Return a string denoting roman numeral version of A.
Constraints

1 <= A <= 3999
For Example

Input 1:
    A = 5
Output 1:
    "V"

Input 2:
    A = 14
Output 2:
    "XIV"
 */
public class IntegerToRoman {

    public static void main(String[] args) {
        IntegerToRoman obj = new IntegerToRoman();
        System.out.println(obj.intToRoman(3999));
    }

    public String intToRoman(int A) {

        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        StringBuilder result = new StringBuilder();

        for (Map.Entry es : map.entrySet()) {
            int key = (Integer) es.getKey();
            String value = (String) es.getValue();

            int divide = A / key;
            if (divide <= 3 && divide >= 1) {
                A = A % key;
                int count = divide;
                if (count == 1) {
                    result.append(value);
                } else if (count == 2) {
                    result.append(value).append(value);
                } else {
                    result.append(value).append(value).append(value);
                }
            }

        }
        return result.toString();
    }

    public String intToRomanOptimized(int A) {

        String[] M = {"", "M", "MM", "MMM"};
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return M[A / 1000] + C[(A % 1000) / 100] + X[(A % 100) / 10] + I[A % 10];
    }
}

/*
    Just Note the Rules and Look the Optimized Version it seems amazing.
 */