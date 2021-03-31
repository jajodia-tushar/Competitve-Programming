package com.interviewbit.twopointer;

import com.interviewbit.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSumToZero {

    public static void main(String[] args) {
        ThreeSumToZero obj = new ThreeSumToZero();
        int[] ints = ArrayUtils.asArrays(1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3);
        int[][] ints1 = obj.threeSum(ints);
        ArrayUtils.printArray(ints1);
    }

    public int[][] threeSum(int[] arr) {
        Arrays.sort(arr);
        ArrayList<int[]> finalList = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {

            if (i == 0 || (i > 0 && arr[i] != arr[i - 1])) {
                int j = i + 1;
                int k = arr.length - 1;

                while (j < k) {
                    int sum = arr[i] + arr[j] + arr[k];

                    if (sum > 0)
                        k--;
                    else if (sum < 0)
                        j++;
                    else {
                        if (!finalList.isEmpty()) {
                            int[] ints = finalList.get(finalList.size() - 1);
                            if (ints[0] != arr[i] || ints[1] != arr[j] || ints[2] != arr[k])
                                finalList.add(new int[]{arr[i], arr[j], arr[k]});
                        } else {
                            finalList.add(new int[]{arr[i], arr[j], arr[k]});
                        }
                        j++;
                        k--;
                    }
                }
            }


        }
        int[][] A = new int[finalList.size()][3];
        int i = 0;
        for (int[] x : finalList) {
            A[i++] = x;
        }

        return A;
    }
}
