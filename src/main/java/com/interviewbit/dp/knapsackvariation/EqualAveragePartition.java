package com.interviewbit.dp.knapsackvariation;

import com.interviewbit.hashing.Equal;
import com.interviewbit.utils.ArrayUtils;

import java.util.Arrays;
import java.util.Vector;

public class EqualAveragePartition {

    static boolean[][][] dp;
    static Vector<Integer> res = new Vector<>();
    static int[] original;
    static int totalSize;

    public static void main(String[] args) {
        EqualAveragePartition obj = new EqualAveragePartition();
        int[] Vec = { 19, 5, 38, 22, 44, 12, 17, 35};
        int[][] sol = obj.avgset(Vec);
        ArrayUtils.printArray(sol);
    }

    public boolean isPossible(int index, int requiredSum, int reqSize) {

        if (reqSize == 0) {
            return requiredSum == 0;
        }

        if (index >= totalSize) return false;

        if (!dp[index][requiredSum][reqSize]) return false;

        if (requiredSum >= original[index]) {

            res.add(original[index]);

            if (isPossible(index + 1, requiredSum - original[index], reqSize - 1))
                return true;
            res.remove(res.size() - 1);
        }


        if (isPossible(index + 1, requiredSum, reqSize))
            return true;

        return dp[index][requiredSum][reqSize] = false;
    }


    public int[][] avgset(int[] Vec) {

        Arrays.sort(Vec);
        original = Vec;
        res.clear();

        int totalSum = 0;
        totalSize = Vec.length;

        for (int i = 0; i < totalSize; i++) {
            totalSum += Vec[i];
        }

        dp = new boolean[original.length][totalSum + 1][totalSize];

        for (int i = 0; i < original.length; i++)
            for (int j = 0; j < totalSum + 1; j++)
                for (int k = 0; k < totalSize; k++)
                    dp[i][j][k] = true;


        for (int i = 1; i < totalSize; i++) {

            if ((totalSum * i) % totalSize != 0) continue;
            int subSetSum = (totalSum * i) / totalSize;


            if (isPossible(0, subSetSum, i)) {

                int p1 = 0;
                int p2 = 0;

                int m = 0;
                int n = 0;

                int[] res1 = new int[res.size()];
                int[] res2 = new int[totalSize - res.size()];

                while (p1 < totalSize || p2 < res.size()) {

                    if (p1 < totalSize && p2 < res.size()
                            && Vec[p1] == res.elementAt(p2)) {
                        res1[m++] = Vec[p1];
                        p1++;
                        p2++;
                        continue;
                    }
                    res2[n++] = Vec[p1++];
                }

                int[][] ans = new int[2][];
                ans[0] = res1;
                ans[1] = res2;
                return ans;
            }
        }

        int[][] ans = new int[2][];
        ans[0] = new int[]{};
        ans[1] = new int[]{};
        return ans;
    }
}
