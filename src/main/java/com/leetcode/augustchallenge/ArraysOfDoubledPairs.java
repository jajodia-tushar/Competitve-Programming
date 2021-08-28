package com.leetcode.augustchallenge;

import java.util.*;

public class ArraysOfDoubledPairs {

    public static void main(String[] args) {

        ArraysOfDoubledPairs obj = new ArraysOfDoubledPairs();
        int[] ints = {4, -2, 2, -4};
        boolean result = obj.canReorderDoubled(ints);
        System.out.println(result);

    }

    public boolean canReorderDoubled(int[] arr) {

        Map<Integer, Integer> maps = new HashMap<>();

        for (int item : arr) {
            maps.put(item, maps.getOrDefault(item, 0) + 1);
        }

        Integer[] integerArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            integerArr[i] = arr[i];
        }

        // This Line Does the Trick
        Arrays.sort(integerArr, (a, b) -> Math.abs(a) - Math.abs(b));

        for (int item : integerArr) {
            if (maps.get(item) == 0) continue;

            if (maps.getOrDefault(item * 2, 0) <= 0) return false;

            maps.put(item, maps.get(item) - 1);
            maps.put(item * 2, maps.get(item * 2) - 1);
        }

        return true;

    }
}
