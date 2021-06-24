package com.interviewbit.strings;


/*
Compare Version Numbers
Your Score:
144
Max Score: 225
Medium
2

9
Add to favorites
Asked In:
INTUIT
AMAZON
Time taken: 37 min.
Compare two version numbers version1 and version2.

If version1 > version2 return 1,
If version1 < version2 return -1,
otherwise return 0.
You may assume that the version strings are non-empty and contain only digits and the . character.

The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
Here is an example of version numbers ordering:
0.1 < 1.1 < 1.2 < 1.13 < 1.13.4
 */
public class CompareVersionNumbers {

    public static void main(String[] args) {
        CompareVersionNumbers obj = new CompareVersionNumbers();
        System.out.println(obj.compareVersion("01.01.001.001", "1.1.1.1"));


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

/*
    There are glitches in this solution.
    You can do better than this.
    The Solution in the Editor is using BitInteger.
    But we don't want to use that.
 */