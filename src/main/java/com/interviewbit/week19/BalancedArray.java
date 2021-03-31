package com.interviewbit.week19;

public class BalancedArray {

    public int solve(int[] A) {

        int totalOdd = 0;
        int totalEven = 0;
        int total = 0;

        for(int i = 0; i < A.length; i++){
            if(i % 2 == 0)
                totalEven += A[i];
            else
                totalOdd += A[i];
        }

        total = totalOdd + totalEven;

        int oddTillNow = 0;
        int evenTillNow = 0;
        int count = 0;

        for(int i = 0; i < A.length; i++){
            int num = A[i];
            int oddRem = 0;
            int evenRem = 0;

            if(i % 2 == 0){
                evenRem = totalEven - evenTillNow - num;
                oddRem = totalOdd - oddTillNow;
            }
            else{
                oddRem = totalOdd - oddTillNow - num;
                evenRem = totalEven - evenTillNow;
            }

            if((oddTillNow + evenRem) == (evenTillNow + oddRem))
                count++;


            if(i % 2 == 0)
                evenTillNow += num;
            else
                oddTillNow += num;
        }

        return count;

    }

    public static void main(String[] args) {
        BalancedArray obj = new BalancedArray();
        System.out.println(obj.solve(new int[]{5, 5, 2, 5, 8}));
    }
}
