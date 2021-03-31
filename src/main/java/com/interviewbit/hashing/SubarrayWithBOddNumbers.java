package com.interviewbit.hashing;

import com.interviewbit.utils.ArrayUtils;

public class SubarrayWithBOddNumbers {

    public static void main(String[] args) {
        SubarrayWithBOddNumbers obj = new SubarrayWithBOddNumbers();
        int[] ints = ArrayUtils.asArrays(2, 2, 5, 6, 9, 2, 11);
        int result = obj.countSubArrays(ints, 2);
        System.out.println(result);
    }

    public int countSubArrays(int a[], int m)
    {
        int n = a.length;
        int count = 0;
        int prefix[] = new int[n + 1];
        int odd = 0;

        // Traverse in the array
        for (int i = 0; i < n; i++)
        {
            prefix[odd]++;

            // If array element is odd
            if ((a[i] & 1) == 1)
                odd++;

            // When number of odd
            // elements >= M
            if (odd >= m)
                count += prefix[odd - m];
        }

        return count;
    }
}
