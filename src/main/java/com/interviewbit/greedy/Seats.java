package com.interviewbit.greedy;

public class Seats {

    public static void main(String[] args) {

        Seats obj = new Seats();
        String A = "....x..xx...x..";
        int result = obj.seats(A);
        System.out.println(result);
    }

    int MOD = 10000003;

    public int seats(String A) {

        int mid = median(A);
        if (mid == -1) return 0;

        // left;
        int start = mid - 1;
        int empty = mid - 1;
        long count = 0;
        while (start >= 0) {
            if (A.charAt(start) == 'x') {
                int jumps = (empty - start);
                count = (count + jumps) % MOD;
                empty--;
            }
            start--;
        }

        start = mid + 1;
        empty = mid + 1;

        while (start < A.length()) {
            if (A.charAt(start) == 'x') {
                int jumps = start - empty;
                count = (count + jumps) % MOD;
                empty++;
            }
            start++;
        }

        return (int) count;


    }

    public int median(String A) {
        int count = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'x') count++;
        }

        count = (count + 1) / 2;
        if (count == 0) return -1;
        int i = 0, count2 = 0;

        while (count2 < count) {
            if (A.charAt(i) == 'x') count2++;
            i++;
        }
//        System.out.println(count + " -- " + count2 + " -- " + (i - 1));
        return count;
    }

}
