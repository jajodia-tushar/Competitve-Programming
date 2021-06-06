package com.interviewbit.arrays;

public class FirstMissingInteger {

    public static void main(String[] args) {

        FirstMissingInteger obj = new FirstMissingInteger();
        int[] ints = {229, 888, 742, 191, 843, 721, 268, 439, 238, 585, 120, 514, 201, 829, 334, 467, 636, 735, 743, 405, 541, 710, 798, 632, 397, 625, 440, 508, 794, 696, 319, 810, 297, 369, 425, 617, 520, 216, 43, 759, 258, 914, 863, 929, 638, 656, 699, 648, 275, 786, 315, 370, 462, 969, 828, 727, 756, 200, 243, 842, 46, 110, 158, 361, 224, 560, 539, 874, 505, 621, 661, 8, 808, 635, 609, 213, 844, 67, 922, 74, 481, 237, 174, 449, 40, 154, 905, 571, 558, 952, 24, 658, 662, 179, 686, -4, 784, 300, 755, 873, 618, 981, 928, 286, 188, 150, 73, 1000, 598, 225, 814, 595, 532, 673, 793, 290, 774, 909, 876, 855, 375, 235, 524, 365, 613, 333, 7, 336, 848, 959, 797, 328, 90, 629, 140, 59, 69, 339, 640, 199, 732, 317, 395, 940, 263, 799, 172, 570, 56, 730, 468, 461, 801, 282, 502, 389, 295, 871, 740, 921, 35, 933, 690, 717, 778, 48, 547, 257, 823, 272, 985, 681, 528, 204, 536, 889, 486, 305, 586, 956, 861};
//        Arrays.sort(ints);
//        ArrayUtils.printArray(ints);

        int result = obj.firstMissingPositive(ints);
        System.out.println(result);
    }

    public int firstMissingPositive(int[] A) {

        int n = A.length;
        for (int i = 0; i < n; i++) {
            if (A[i] <= 0 || A[i] > n) {
                A[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < n; i++) {
            int index = Math.abs(A[i]);
            if (index != Integer.MAX_VALUE) {
                A[index - 1] = -Math.abs(A[index - 1]);
            }
        }

        for (int i = 0; i < n; i++) {
            int value = A[i];
            if (value > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}

/*
    You have done this question multiple times even though it was causing some problem
    There were just some constraints that were causing problems.

    What you have to do is just ignore these number that are out of range
    like the negative number and the number that are greater than n;
    So you can iterate once and mark these guys as some constants or Integer.MAX_VALUE;

    Not iterate again to apply the main logic.
    Now while iterating the last time find the first positive number.
 */

