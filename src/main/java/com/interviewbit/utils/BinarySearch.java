package com.interviewbit.utils;

public class BinarySearch {

    public static int find(int arr[], int num){

        int mid = -1;
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while(high >= low){
            mid = (low + high)/2;
            int midVal = arr[mid];


            if(midVal > num){
                high = mid - 1;
            }
            else if ( midVal < num){
                low = mid + 1;
            }
            else{
                ans = midVal;
            }
        }
        return ans != -1 ? ans : arr[mid];
    }

    public static void main(String[] args) {

        int[] ints = {1,2,3,4,5,6,7,9,10,11,12,13,14,15,17,19,20};
        System.out.println(find(ints,8));
    }
}
