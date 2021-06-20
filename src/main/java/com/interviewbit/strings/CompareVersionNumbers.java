package com.interviewbit.strings;

public class CompareVersionNumbers {

    public static void main(String[] args) {
        CompareVersionNumbers obj = new CompareVersionNumbers();
        System.out.println(obj.compareVersion("3346237295", "898195413.2.6243"));


    }

    public int compareVersion(String A, String B) {

        String[] arr1 = A.split("\\.");
        String[] arr2 = B.split("\\.");

        int n = arr1.length;
        int m = arr2.length;

        if (n <= 2 && m <= 2) {
            return Double.valueOf(A).compareTo(Double.valueOf(B));
        }

        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            int value;
            if (arr1[i].length() == arr2[j].length()) {
                value = arr1[i].compareTo(arr2[j]);
            } else {
                value = arr1[i].length() - arr2[j].length();
            }

            if (value == 0) {
                i++;
                j++;
            } else {
                return value >= 1 ? 1 : -1;
            }
        }

        if (i == n) {
            return -1;
        } else if (j == m) {
            return 1;
        } else {
            return 0;
        }
    }
}