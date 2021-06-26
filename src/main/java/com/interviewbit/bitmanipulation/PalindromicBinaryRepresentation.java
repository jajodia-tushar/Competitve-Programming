package com.interviewbit.bitmanipulation;

// YOU MIGHT NEED TO VISIT THIS CHECKAGAIN
public class PalindromicBinaryRepresentation {

    public static void main(String[] args) {

        PalindromicBinaryRepresentation obj = new PalindromicBinaryRepresentation();
        System.out.println(obj.solve(15));
    }

    public int solve(int A) {
        int length = 1;
        int count = 1;
        int preCount = -1;

        while (A > count) {
            length++;
            preCount = count;
            count = count + (1 << (length - 1) / 2);
        }

        int offSet = A - preCount - 1;
        int[] arr = new int[length];
        arr[0] = 1;
        arr[length - 1] = 1;
        if (length % 2 != 0) {
            arr[length / 2] = (offSet % 2);
            offSet /= 2;
        }

        int i = length / 2 - 1;
        int j = (length + 1) / 2;
        while (offSet > 0) {
            int bit = offSet % 2;
            arr[i] = bit;
            arr[j] = bit;
            i--;
            j++;
            offSet /= 2;
        }

        int ans = 0;

        for (int k = 0; k < length; k++) {
            if (arr[k] == 1) {
                ans = ans + (1 << k);
            }
        }
        return ans;
    }
}
