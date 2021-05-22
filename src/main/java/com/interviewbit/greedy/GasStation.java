package com.interviewbit.greedy;

public class GasStation {

    public static void main(String[] args) {
        GasStation obj = new GasStation();
        int[] A = {1, 2};
        int[] B = {2, 1};

        int result = obj.canCompleteCircuit(A, B);
        System.out.println(result);
    }

    public int canCompleteCircuit(final int[] A, final int[] B) {

        int n = A.length;
        int preSum = 0;
        int startIndex = 0;
        int sumGas = 0;
        int sumCost = 0;

        for (int i = 0; i < n; i++) {
            sumGas += A[i];
            sumCost += B[i];
            preSum = preSum + A[i] - B[i];
            if (preSum < 0) {
                startIndex = i + 1;
                preSum = 0;
            }
        }

        return sumGas < sumCost ? -1 : startIndex;
    }
}
