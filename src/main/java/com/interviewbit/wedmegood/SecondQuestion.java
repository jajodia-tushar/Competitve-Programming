package com.interviewbit.wedmegood;

public class SecondQuestion {

    public static void main(String[] args) {

        SecondQuestion obj = new SecondQuestion();
        int[] ints = {9, -1, -2, 3, 1, 4, -10, 10, 5, -20};
        obj.RearrangePosNeg(ints);

        for (int num : ints) {
            System.out.print(num + ", ");
        }

    }

    public int[] arrangeNumbers(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int prev = arr[i];
            while (j < n && arr[j] > 0) {
                int temp = arr[j];
                arr[j] = prev;
                prev = temp;
                j++;
            }

            if (j < n) {
                arr[i] = arr[j];
                arr[j] = prev;
            }
            boolean isRemaining = false;
            while (j < n) {
                if (arr[j++] < 0) {
                    isRemaining = true;
                }
            }
            if(!isRemaining) break;
        }

        return arr;
    }

    public static void RearrangePosNeg(int arr[])
    {
        int i=0;
        int j=arr.length-1;
        while(true)
        {
            // Loop until arr[i] < 0 and
            // still inside the array
            while(arr[i]<0 && i<arr.length)
                i++;

            // Loop until arr[j] > 0 and
            // still inside the array
            while(arr[j]>0 && j>=0)
                j--;

            // if i is less than j
            if(i<j)
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            else
                break;
        }
    }
}
