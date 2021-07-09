package com.interviewbit.dp.lcsvariation;


/*

    Consider a 2-D map with a horizontal river passing through its center.
    There are n cities on the southern bank with x-coordinates a(1) … a(n)
    and n cities on the northern bank with x-coordinates b(1) … b(n).
    You want to connect as many north-south pairs of cities as possible
    with bridges such that no two bridges cross.
    When connecting cities, you can only connect city a(i)
    on the northern bank to city b(i) on the southern bank.
    Maximum number of bridges that can be built to connect north-south pairs
    with the aforementioned constraints.

 */

import com.interviewbit.utils.ArrayUtils;

import java.util.Arrays;

public class BuildingBridges {

    public static void main(String[] args) {
        int[][] ints = {{8, 1, 4, 3, 5, 2, 6, 7}, {1, 2, 3, 4, 5, 6, 7, 8}};
        ArrayUtils.printArray(ints);

        BuildingBridges obj = new BuildingBridges();

        int n = ints[0].length;
        CityPairs[] cityPairs = new CityPairs[n];

        for (int i = 0; i < n; i++) {
            cityPairs[i] = new CityPairs(ints[0][i], ints[1][i]);
        }

        int result = obj.maxBridges(cityPairs);
        System.out.println(result);

    }

    public int maxBridges(CityPairs[] pairs) {

        Arrays.sort(pairs);
        int n = pairs.length;
        int[] LIS = new int[n];

        Arrays.fill(LIS, 1);

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j].south <= pairs[i].south) {
                    LIS[i] = Math.max(LIS[j] + 1, LIS[i]);
                }
            }
            max = Math.max(max, LIS[i]);
        }
        return max;
    }


}

class CityPairs implements Comparable<CityPairs> {
    int north, south;

    CityPairs(int north, int south) {
        this.north = north;
        this.south = south;
    }

    @Override
    public int compareTo(CityPairs cityPairs) {

        if (cityPairs.north == this.north)
            return this.south - cityPairs.south;

        return this.north - cityPairs.north;
    }
}

/*
    This one is the variation of LIS ( Longest Increasing SubSequence) Problem
    Sort One Direction
    And Find the LCS of the Second One.
    They will not intersect.
    Why.
    The First Sequence is already increasing.
    Adn LIS is number of increasing subsequence in 2nd String as well.
 */