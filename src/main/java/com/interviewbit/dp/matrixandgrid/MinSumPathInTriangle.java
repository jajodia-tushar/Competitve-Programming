package com.interviewbit.dp.matrixandgrid;

import com.interviewbit.utils.ArrayUtils;

import java.util.ArrayList;

public class MinSumPathInTriangle {

    public static void main(String[] args) {

        MinSumPathInTriangle obj = new MinSumPathInTriangle();
        ArrayList<Integer> first = ArrayUtils.asArrayList(2);
        ArrayList<Integer> second = ArrayUtils.asArrayList(3, 4);
        ArrayList<Integer> third = ArrayUtils.asArrayList(6, 5, 7);
        ArrayList<Integer> fourth = ArrayUtils.asArrayList(4, 1, 8, 3);

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(first);
        list.add(second);
        list.add(third);
        list.add(fourth);
        int result = obj.minimumTotal(list);
        System.out.println(result);

    }

    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {

        int row = a.size();
        int[] dp = new int[row];

        int n = a.size() - 1;
        for (int i = 0; i < a.get(n).size(); i++) {
            dp[i] = a.get(n).get(i);
        }
        // System.out.println();

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < a.get(i).size(); j++) {

                dp[j] = a.get(i).get(j) +
                        Math.min(dp[j], dp[j + 1]);
                //System.out.print(dp[i]+" inner ");
            }
        }

        return dp[0];
    }
}
