package com.interviewbit.twopointer;

import com.interviewbit.utils.ArrayUtils;

import java.util.ArrayList;

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