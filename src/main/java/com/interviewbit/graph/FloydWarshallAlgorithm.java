package com.interviewbit.graph;

import com.interviewbit.utils.ArrayUtils;

import java.util.*;
import java.util.stream.Collectors;

public class FloydWarshallAlgorithm {

    public static void main(String[] args) {

        FloydWarshallAlgorithm obj = new FloydWarshallAlgorithm();
        int[][] ints = {{0, 3, 9999, 7}, {8, 0, 2, 9999}, {5, 9999, 0, 1}, {2, 9999, 9999, 0}};
        int[][] result = obj.solve(ints);
        ArrayUtils.printArray(result);
    }

    public int[][] solve(int[][] ints) {
        int row = ints.length;
        int col = ints[0].length;

        int[][] dp = new int[row][col];

        for (int k = 0; k < row; k++) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    dp[i][j] = Math.min(ints[i][j], ints[i][k] + ints[k][j]);
                }
            }
            ints = dp;
        }
        return dp;
    }
}

class Test {
    static Test t;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        String result = getLargestString("zzzzzzzzzzzyzzzzyzzzzzzzzzzzyzzzzzzzzzzzzzzzzzyzzzyyzzzzyzyzzzzzzzzzzzzzzzzzzyzyzxzyzzzzzzzzzyzzzyzzzzzzzzyzzzzzzzzzzzzzzzzzyxzzxzzzzzzzyzzzzzzxzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzyzzzzyzzyzzzyzzzzyzzzzzyzzzzzzzzzzzzzzzyzzzyzzzyzyzyzzyyzzzzzzzzzzzzzyzzzzzyzzxzzyzzyzzzzzzyzzzzzzzzzzyzyzzzzzzzzyzyzzzzzzyzzzzzzzzzzzxzzzzzzzzzzxzzzzzzzzzzzzzzzzzzzyzzzzzzzzzzyzwzzzzzzzyzzzzyzzzzzzzzyzzyzzyzzyzzzzyzzyzzyzzzzzzzzzzzzzzyzzzzzzzzyzzzzzzzzzzzyzyzzzzzzzzzzzzzzzyzzzyzzzzzzzzzyzzzzzyyzzzzzzzzzzzzzzzzzzzzzyzzzzzzzzzzzzzzzzzyzzyzzzzzzzzzzzzzyzzzzzzzyzzzzzzzzyzzzzzzzzzyzzzzzzzzzzzzyyzyzzzzzzzzzzzzzzzzzzzyzzzzzzzzyzzzzzzzzzzzyyyzzzzzzyzzzzzzzzzzzzzzyzzzzyzzzyzzzzzzzzzzzzyzzzzzzyzzzzzzyzyzzzzzzzzzzyzzzzzzzwzzzzzzzzzzzzzzzyzyzzyzzzzzzyzzzzzzyzyzzzzzzzzzzzzzzzzzzzzzzzzyzzzzzzzxzzzyyzzzxzyzzxzzzzzzzzzzzzzzzyzyzzyzzzzzzzzzzzzzzzzyzzzzzyzzzzzzzzzzzzzzzzzzzzzzzzzzzzyzzzyzzzyzzyzzzzzzzzzzzzzzyzzzzzzzzzzzzzzyzzzzzzzzzzzzzzzzzzywzzzzzzzzyzzzzzzzzzzzzzyzyzzzzzzzzzyzzzzzzzzzzzzzzzzzzzzzzzz", 4);
        System.out.println(result);
    }

    public static String getLargestString(String s, int k) {
        // Write your code here

        char[] ch = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        List<Character> list = new ArrayList<>();

        for (Character c : ch)
            map.put(c, map.getOrDefault(c, 0) + 1);

        Arrays.sort(ch);
        char prev = '0';

        int left = ch.length - 1, right = ch.length - 1, count = 0;
        for (; right >= 0; right--) {
            if (ch[left] == ch[right] && map.get(ch[right]) != 0 && ch[right] != prev) {
                while (count < k && map.get(ch[right]) != 0) {
                    list.add(ch[right]);
                    map.put(ch[right], map.get(ch[right]) - 1);
                    count++;
                }
            } else if (count == k && map.get(ch[right]) != 0) {
                list.add(ch[right]);
                map.put(ch[right], map.get(ch[right]) - 1);
                right = left + 1;
                count = 0;
                prev = list.get(list.size() - 1);

            } else {
                left--;
                right = left + 1;
                count = 0;
                prev = list.get(list.size() - 1);
            }
        }


        return list.stream().map(e -> e.toString()).collect(Collectors.joining());
    }
}