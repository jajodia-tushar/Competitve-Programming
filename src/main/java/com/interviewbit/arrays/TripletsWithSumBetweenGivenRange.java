package com.interviewbit.arrays;

public class TripletsWithSumBetweenGivenRange {

    public static void main(String[] args) {

    }

    public int solve(String[] A) {

        int n = A.length;
        double max1A = Integer.MIN_VALUE,
                max2A = Integer.MIN_VALUE,
                max3A = Integer.MIN_VALUE,
                max1B = Integer.MIN_VALUE;

        double min1A = Integer.MAX_VALUE,
                min2A = Integer.MAX_VALUE,
                min1B = Integer.MAX_VALUE,
                min2B = Integer.MAX_VALUE,
                min1C = Integer.MAX_VALUE;


        for (int i = 0; i < A.length; i++) {
            double num = Double.parseDouble(A[i]);
            if (isInA(num)) {
                if (num > max1A) {
                    max3A = max2A;
                    max2A = max1A;
                    max1A = num;
                } else if (num > max2A) {
                    max3A = max2A;
                    max2A = num;
                } else if (num > max3A) max3A = num;
                if (num < min1A) {
                    min2A = min1A;
                    min1A = num;
                } else if (num < min2A) min2A = num;
            } else if (isInB(num)) {
                if (num > max1B)
                    max1B = num;

                if (num < min1B) {
                    min2B = min1B;
                    min1B = num;
                } else if (num < min2B) min2B = num;
            } else if (isInC(num)) {

                if (num < min1C) min1C = num;
            }
        }

        if ((max1A + max2A + max3A) > 1.0) return 1;
        else if ((max1A + max2A + min1B) > 1.0 && (max1A + max2A + min1B) < 2.0) return 1;
        else if ((min1A + min2A + max1B) > 1.0 && (min1A + min2A + max1B) < 2.0) return 1;
        else if ((min1A + min1B + min2B) < 2.0) return 1;
        else if ((min1A + min1B + min1C) < 2.0) return 1;
        else if ((min1A + min2A + min1C) < 2.0) return 1;
        else return 0;
    }

    public boolean isInA(double num) {
        return num > 0.0 && num < 2.0 / 3.0;
    }

    public boolean isInB(double num) {
        return num >= 2.0 / 3.0 && num < 1.0;
    }

    public boolean isInC(double num) {
        return num >= 1.0 && num < 2.0;
    }
}

/*

    Notes.
    Look very Carefully.
    The Given Range is 0-2.
    We will divide the range in three Buckets.
    A (0-2/3)
    B [2/3 - 1)
    C [1 - 2)

    The Combination of Three Numbers in the Bucket could be

    A A A
    A A B
    A A C
    A B B
    A B C

    A C C  X
    B B B  X
    B B C  X
    B C C  2 + something so X.
    C C C  Min Value of C group is 1 so 1 + 1 + 1 is minimum 3 X.

    So we will take 6 variables.
    minA, minB, minC.
    maxA, maxB, maxC.

    now.

    1. max1A + max2A + max3A at max can be less than 2/3. So no Worry for overflow just check if it is greater than 1. if yes we are good to return true.
    2. min1A + min2A + max1B Both overflow and underflow and max1A + max2A + min1B.
    3. min1A + min2A + min1C for Overflow.
    4. min1A + min1B + min2B for overflow.
    5. min1A + min1B + min1C for Overflow.

    Start by writing all these test cases and then 3 handy functions and finally init the variables it would make too much sense.
    that way.
 */
