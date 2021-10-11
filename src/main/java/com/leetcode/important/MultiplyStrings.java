package com.leetcode.important;

/*
    Given two non-negative integers num1 and num2 represented as strings,
    return the product of num1 and num2, also represented as a string.
    Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

    Example 1:
    Input: num1 = "2", num2 = "3"
    Output: "6"

    Example 2:
    Input: num1 = "123", num2 = "456"
    Output: "56088"


    Constraints:

    1 <= num1.length, num2.length <= 200
    num1 and num2 consist of digits only.
    Both num1 and num2 do not contain any leading zero, except the number 0 itself.

 */

public class MultiplyStrings {

    public static void main(String[] args) {

    }

    public String multiply(String num1, String num2) {

        int n = num1.length();
        int m = num2.length();

        int[] result = new int[n + m];

        for (int i = n - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {

                int y = num2.charAt(j) - '0';

                int carryPosition = i + j;
                int basePosition = i + j + 1;

                int mul = x * y + result[basePosition];
                int carry = mul / 10;
                int base = mul % 10;

                result[carryPosition] += carry;
                result[basePosition] = base;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < result.length; i++) {
            if (sb.length() == 0 && result[i] == 0) continue;
            sb.append(result[i]);
        }

        if (sb.length() == 0) return "0";
        return sb.toString();
    }
}

/*
    The Idea is to use the approach we use in School using Copy and Pen.
    Numbers are not in reverse order.
    So you will need to traverse from end.

    Now see,
    Try to use little logic.
    the maximum 5 digit number can be 99999
    and maximum 6 digit number can be 999999

    If you multiply you will get 99998900001

    you will at max have 11 digit in your result.
    So you start by making a n + m size array.
    and see the multiplication of n - 1 with m - 1 th Item.

    will have carry and base.
    so base will be at n + m - 1 position and carry will be at
    n + m - 2 position.

    No need to hold the carry, just put the carry in next location.
    If you go to the next location
    then you can do multiply n - 1 and m - 1 position element and then
    add value at the current index that can be carry.




 */