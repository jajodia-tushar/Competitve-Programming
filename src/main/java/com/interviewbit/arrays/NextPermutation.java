package com.interviewbit.arrays;


import java.util.Arrays;

/*
Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.

If such arrangement is not possible, it must be rearranged as the lowest possible order i.e., sorted in an ascending order.

Note:

1. The replacement must be in-place, do **not** allocate extra memory.
2. DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submission retroactively and will give you penalty points.
Input Format:

The first and the only argument of input has an array of integers, A.
Output Format:

Return an array of integers, representing the next permutation of the given array.
Constraints:

1 <= N <= 5e5
1 <= A[i] <= 1e9
Examples:

Input 1:
    A = [1, 2, 3]

Output 1:
    [1, 3, 2]

Input 2:
    A = [3, 2, 1]

Output 2:
    [1, 2, 3]

Input 3:
    A = [1, 1, 5]

Output 3:
    [1, 5, 1]

Input 4:
    A = [20, 50, 113]

Output 4:
    [20, 113, 50]

 */
public class NextPermutation {

    public static void main(String[] args) {

        NextPermutation obj = new NextPermutation();
        int[] ints = {444, 994, 508, 72, 125, 299, 181, 238, 354, 223, 691, 249, 838, 890, 758, 675, 424, 199, 201, 788, 609, 582, 979, 259, 901, 371, 766, 759, 983, 728, 220, 16, 158, 822, 515, 488, 846, 321, 908, 469, 84, 460, 961, 285, 417, 142, 952, 626, 916, 247, 116, 975, 202, 734, 128, 312, 499, 274, 213, 208, 472, 265, 315, 335, 205, 784, 708, 681, 160, 448, 365, 165, 190, 693, 606, 226, 351, 241, 526, 311, 164, 98, 422, 363, 103, 747, 507, 669, 153, 856, 701, 319, 695, 52};


    }

    public int[] nextPermutation(int[] A) {

        int n = A.length;
        int i = n - 1;
        for (; i > 0; i--) {
            if (A[i - 1] < A[i]) {
                break;
            }
        }

        if (i == 0) {
            Arrays.sort(A);
            return A;
        }

        int maxJ = i;
        for (int j = i + 1; j < n; j++) {
            if (A[i - 1] < A[j] && A[j] < A[maxJ]) {
                maxJ = j;
            }
        }

        int temp = A[maxJ];
        A[maxJ] = A[i - 1];
        A[i - 1] = temp;
        Arrays.sort(A, i, n);

        return A;
    }
}

/*
        Let's take baby steps.
        Suppose the Array is sorted that means if you just swap last two numbers you are done.
        If it is sorted in opposite manner that means this is the greatest number that is possible and no next Greater exists.

        You will loop from n - 1 till 0 to find if any two number are in ascending form
        i.e A[i - 1] < A[i]
        It means that the number in the right of current i are in kind of descending order
        so you can now swap this two numbers to get greater number

        for eg
        4 2 5
        Your i will be at 5 and i - 1 will be at 2.
        so you swap these two numbers to get
        4 5 2

        Which is the next greater number.

        But in case of number
        4 2 5 3
        if you swap you will get
        4 5 2 3
        Which is no doubt greater but not next greater.

        Next greater is 4 3 2 5.
        Because your next greater number will be formed if you replace i - 1 will the
        smallest number possible.

        So you will actually need to loop from i + 1 to n to find smallest possible number that can be
        used to swap with i - 1.
        Well the condition is it must be greater than i - 1 { if not greater than no point is swapping it will not make greater}
        and it must be smallest possible.

        so we can do

        int possibleSmallest = i;
        for(j = i + 1; j < n; j++){
            if(A[i - 1] < A[j] && A[j] < A[possibleSmallest]){
                possibleSmallest = j;
            }
        }

        now you can perfectly swap these two numbers
        i - 1 and possibleSmallest.
        and you will have to sort Array from i to n
        so that the combination is smallest after i.

        You will understand.
        Good Question




 */