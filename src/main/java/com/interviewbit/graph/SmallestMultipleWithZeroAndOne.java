package com.interviewbit.graph;

import java.util.*;

public class SmallestMultipleWithZeroAndOne {

    public static void main(String[] args) {
        SmallestMultipleWithZeroAndOne obj = new SmallestMultipleWithZeroAndOne();
        String result = obj.multiple(55);
        System.out.println(result);
    }

    public String multiple(int A) {

        Queue<String> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();


        queue.add("1");

        while (!queue.isEmpty()) {

            String currentNumber = queue.poll();

            int rem = mod(currentNumber, A);

            if (rem == 0) {
                return currentNumber;
            }

            if (!visited.contains(rem)) {
                visited.add(rem);
                queue.add(currentNumber + "0");
                queue.add(currentNumber + "1");
            }
        }
        return "-1";
    }

    public int mod(String number, int n) {
        int res = 0;
        for (int i = 0; i < number.length(); i++) {
            res = ((res * 10) + (number.charAt(i) - '0'));
            res = res % n;
        }
        return res;
    }
}
