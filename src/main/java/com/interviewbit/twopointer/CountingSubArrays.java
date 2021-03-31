package com.interviewbit.twopointer;

import com.interviewbit.utils.ArrayUtils;

public class CountingSubArrays {

    public static void main(String[] args) {
        CountingSubArrays obj = new CountingSubArrays();
        System.out.println(obj.solve(ArrayUtils.asArrays(10, 1, 1, 7, 2, 4, 9, 10, 4, 5, 5, 7, 1, 7, 7, 2, 9, 5, 10, 7, 4, 8, 9, 9, 3, 10, 2, 4, 6, 10, 9, 5, 1, 8, 7, 4, 7, 2, 6, 5, 3, 1, 10, 8, 4, 8, 3, 7, 1, 2 ),56));
    }

    /*
    This is quite Interesting Problem.
    The Question is from Sliding Window.
    Here we are adding A[j] to the Sum.
    and till sum < B we are adding (j - i)
    to the Count as (j - i) is the total
    number of sub-arrays that are possible.

    Now if Sum exceeds B then we will need to
    increase i such that Sum becomes Less than B.
    Now the Interesting Part is that.
    We need to increase j
    as current item at jth position is already added
    so we will need to increase j as well to get correct Answer.
     */

    public int solve(int[] A, int B) {

        int n = A.length;
        int i = 0;
        int j = 0;
        int sum = 0;
        int count = 0;
        while( j < n){
            if(sum < B){
                sum += A[j];
                count = count + (j - i);
                j++;
            }
            else{
                while(sum >= B){
                    sum = sum - A[i];
                    i++;
                }
            }
        }

        while(sum >= B){
            sum = sum - A[i];
            i++;
        }
        int diff = j - i;

        return count + diff;
    }

    public static String CountingMinutes(String str) {

        String[] times = str.split("\\-");
        String first = times[0];
        String second = times[1];

        int firstTime = getMinutes(first);
        int secondTime = getMinutes(second);

        char ch1 = first.split("\\:")[1].charAt(2);
        char ch2 = second.split("\\:")[1].charAt(2);

        int diff = secondTime - firstTime;
        if(diff < 0){
            return (1440 + diff)+"";
        }
        else{
            return diff + "";
        }


    }

    public static int getMinutes(String time){
        String[] times = time.split(":");
        int hour = Integer.parseInt(times[0]);
        int minutes = Integer.parseInt(times[1].substring(0,2));
        String format = times[1].substring(2);
        hour = hour % 12;
        int totalMinutes = (hour * 60) + minutes;
        if(format.equals("am")){
            return totalMinutes;
        }
        else{
            return (totalMinutes + 720);
        }
    }
}
