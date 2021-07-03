package com.interviewbit.twopointer;

import com.interviewbit.utils.ArrayUtils;

import java.util.ArrayList;

/*
Given an array with n objects colored red, white or blue,
sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: Using library sort function is not allowed.

Example :

Input : [0 1 2 0 1 2]
Modify array so that it becomes : [0 0 1 1 2 2]
 */
public class SortByColor {

    public static void main(String[] args) {
        SortByColor obj = new SortByColor();
        ArrayList<Integer> integers = ArrayUtils.asArrayList(0, 1, 2, 0, 1, 2);
        obj.sortColors(integers);
        System.out.println(integers);
    }

    public void sortColors(ArrayList<Integer> arrayList) {
        if (arrayList == null || arrayList.size() < 2) {
            return;
        }

        int[] colours = new int[3];
        arrayList.stream().forEach(x -> colours[x]++);
        int value = 0;

        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < colours[i]; j++) {
                arrayList.set(k++, i);
            }
        }
    }
}
/*
    There are just three Types of Number in the Array.
    If you just count their occurrence and put then after it should be fine.
 */