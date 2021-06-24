package com.interviewbit.strings;

/*
Given two binary strings, return their sum (also a binary string).
Example:
a = "100"
b = "11"
Return a + b =  “111”.
 */
public class AddBinaryStrings {

    public static void main(String[] args) {

    }

    public String addBinary(String A, String B) {

        StringBuilder result = new StringBuilder();

        int n = A.length();
        int m = B.length();

        int i = n - 1;
        int j = m - 1;
        int carry = 0;

        while (i >= 0 && j >= 0) {
            int sum = add(A.charAt(i), B.charAt(j), carry);
            carry = sum / 2;
            result.append(sum % 2);
            i--;
            j--;
        }

        if (i == -1) {
            while (j >= 0) {
                int sum = add('0', B.charAt(j), carry);
                carry = sum / 2;
                int rem = sum % 2;
                result.append(rem + "");

                j--;
            }
        } else {
            while (i >= 0) {
                int sum = add(A.charAt(i), '0', carry);
                carry = sum / 2;
                result.append(sum % 2);
                i--;
            }
        }

        return carry == 0 ? result.reverse().toString() :
                result.append(carry).reverse().toString();

    }

    public int add(char a, char b, int carry) {
        return Character.getNumericValue(a) +
                Character.getNumericValue(b) + carry;
    }
}

/*
    Nothing Much You can Do it easily.
 */