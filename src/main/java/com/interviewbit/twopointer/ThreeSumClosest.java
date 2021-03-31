package com.interviewbit.twopointer;

import java.util.Arrays;

public class ThreeSumClosest {

    public static void main(String[] args) {
        ThreeSumClosest obj = new ThreeSumClosest();
        System.out.println(obj.threeSumClosest(new int[]{2, 1, -9, -7, -8, 2, -8, 2, 3, -8},-1));
    }

    // I thought this should be working but it is not working for higher test cases
    public int threeSumClosestBinarySearchTechnique(int[] arr, int target) {
        Arrays.sort(arr);

        long closestNumber = Integer.MAX_VALUE;
        int closestIndex = -1;
        for(int i = 0; i < arr.length; i++){
            int item = arr[i];
            long currDiff = Math.abs(closestNumber - target);
            int newDiff = Math.abs(item - target);

            if(currDiff > newDiff){
                closestNumber = item;
                closestIndex = i;
            }
        }

        int i = 0;
        int j = arr.length - 1;
        long finalClosest = Integer.MAX_VALUE;
        while(i < j){

            if( i == closestIndex){
                i++;
                continue;
            }
            if( j == closestIndex){
                j--;
                continue;
            }

            int sum = (int)closestNumber + arr[i] + arr[j];
            long currDiff = Math.abs(finalClosest - target);
            int newDiff = Math.abs(target - sum);
            if( newDiff < currDiff){
                finalClosest = sum;
            }

            if(sum > target){
                j--;
            }
            else if(sum < target){
                i++;
            }
            else{
                return target;
            }
        }

        return (int)finalClosest;



    }

    public int threeSumClosest(int[] arr, int target) {
        Arrays.sort(arr);
        long closest = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length - 2; i++){

            int j = i+1;
            int k = arr.length - 1;

            while( j < k){

                int sum = arr[i] + arr[j] + arr[k];
                long currDiff = Math.abs(closest - target);
                int newDiff = Math.abs(sum - target);

                if( newDiff < currDiff)
                    closest = sum;

                if( sum > target)
                    k--;
                else if( sum < target)
                    j++;
                else
                    return target;
            }
        }
        return (int)closest;
    }
}
