package com.october.week9;

public class Saturday {

    public static void main(String[] args) {

        int A[] = new int[]{0, 1, 0, 1, 1, 0, 0, 0, 1};
        int B = 3;

        Saturday saturday = new Saturday();
        System.out.println(saturday.solve(A,B));
    }

    /*

    Problem Description
        There is a corridor in a Jail which is N units long.
        Given an array A of size N. The ith index of this array is 0 if the light at ith position is faulty otherwise it is 1.
        All the lights are of specific power B which if is placed at position X, it can light the corridor from [ X-B+1, X+B-1].
        Initially all lights are off.
        Return the minimum number of lights to be turned ON to light the whole corridor or -1 if the whole corridor cannot be lighted.

    */


    /*
    This is the hardest Answer to understand or think. Even after looking at the answer I was not able to comprehend.
    The Idea behind the Solution is to find the right most element in the array that can be light up to brighten the current
    index. If we use Greedy Algorithm from starting and then we keep moving, at the end we will end up finding the
    count require the lighten up the entire corridor.

     */

    public int solve(int[] A, int B) {
        int n = A.length;  // Length of the Array given
        int i = Math.min(B - 1, n - 1); // i plays very crucial role here. We don't want to iterate from 0, we directly jump to B position or nth Position
        int cnt = 0;        // The idea is that if the light at Bth position is lighten then it will lighten up the corridor from 0th till Bth.


        while (i >= 0) {
            if (A[i] == 1) {  // If A[i] == 1 then we will update the count and then jump to next highest(rightest) element possible to start check if that
                cnt++;        // That can be lighten up. Being Greedy.
                A[i] = 2;     // This we will discuss in a minute. in else if part.
                i += B;       // if we lighten up i then corridor will be lighten up till (i + B - 1) so directly jumping.

                if (i >= n)   // Checking Base condition.
                    break;

                i = Math.min(n - 1, i + B - 1);  //  This is similar to the one we used in the starting line. Jumping B index from ith Index to see.
            }
            else if (A[i] == 2)  // Read Else part first. If we keep decreasing i and then at last if we come to a index where we have already lighten up the
                break;           // The light it means that the corridor cannot be lighten up and we need to return -1;
            else       //  If this particular A[i] is not 1 then we keep decreasing i. so see which rightmost light can be lighten.
                i--;
        }

        if (i < n - 1)   // If the Corridor cannot be lighten up then we are going to return -1. It comes when either or the else or else if part sends the control
            return -1;

        return cnt;  // Final Returning Part.
    }
}
