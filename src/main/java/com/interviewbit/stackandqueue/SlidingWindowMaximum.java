package com.interviewbit.stackandqueue;

import com.interviewbit.utils.ArrayUtils;

import java.util.*;

/*
Given an array of integers A.  There is a sliding window of size B which

is moving from the very left of the array to the very right.

You can only see the w numbers in the window. Each time the sliding window moves

rightwards by one position. You have to find the maximum for each window.

The following example will give you more clarity.

The array A is [1 3 -1 -3 5 3 6 7], and B is 3.

Window position	Max
———————————-	————————-
[1  3  -1] -3  5  3  6  7	3
1 [3  -1  -3] 5  3  6  7	3
1  3 [-1  -3  5] 3  6  7	5
1  3  -1 [-3  5  3] 6  7	5
1  3  -1  -3 [5  3  6] 7	6
1  3  -1  -3  5 [3  6  7]	7
Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1].

Note: If B > length of the array, return 1 element with the max of the array.




Input Format

The first argument given is the integer array A.
The second argument given is the integer B.
Output Format

Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1]
For Example

Input 1:
    A = [1, 3, -1, -3, 5, 3, 6, 7]
    B = 3
Output 1:
    C = [3, 3, 5, 5, 6, 7]
 */

// SEEAGAIN
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        SlidingWindowMaximum obj = new SlidingWindowMaximum();
        int arr[] = {648, 614, 490, 138, 657, 544, 745, 582, 738, 229, 775, 665, 876, 448, 4, 81, 807, 578, 712, 951, 867, 328, 308, 440, 542, 178, 637, 446, 882, 760, 354, 523, 935, 277, 158, 698, 536, 165, 892, 327, 574, 516, 36, 705, 900, 482, 558, 937, 207, 368};
        int[] result = obj.slidingMaximum(arr, 9);
        System.out.println(result.length);
        ArrayUtils.printArray(result);
    }

    public int[] slidingMaximum(final int[] A, int B) {

        LinkedList<Integer> queue = new LinkedList<>();
        int i = 0;
        int j = 0;
        int arr[] = new int[A.length - B + 1];

        while (j < A.length) {
            int item = A[j];

            while (!queue.isEmpty() && queue.getLast() < item) {
                queue.removeLast();
                ;
            }
            queue.addLast(A[j]);
            arr[i] = queue.peek();
            j++;
            if (j >= B) {
                if (queue.peek() == A[i])
                    queue.remove();
                i++;
            }
        }
        return arr;
    }

    public int[] slidingMaximumNext(final int[] A, int B) {

        int n = A.length;
        int maxSum = Integer.MIN_VALUE;
        int[] result = new int[n - B + 1];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int index = 0;

        for (int i = 0; i < n; i++) {
            if (i >= B) index++;
            queue.add(new int[]{A[i], i});
            result[index] = queue.peek()[0];

            while (!queue.isEmpty() && (i - queue.peek()[1] + 1) >= B) {
                queue.poll();
            }
        }
        return result;
    }
}

/*
    This one is really very famous Question.

    If you always find the max in the current window size it will be O(n^2) in worst case.

    So we want to store this max value somewhere, what would be better choice than PriorityQueue for this use case.
    However simply storing the number only will not work because once you more out of the frame that number should
    be removed also.
    But should we care about removing that number every time we move one size ahead. If we ensure that the number
    that is out of the size of the window won't be taken in the upcoming window size even though if it stays in the
    queue then ?

    for that we have the code from line 101.
    It says check if the current peek is out of range only then remove, if we have a number from previous frames that
    are not the max of current window size don't waste time in removing these numbers.

    ==========================================================================================================

    Other Technique is to use Double Ended Queues,
    You add from one side and remove from other side,
    While adding make sure that that value you are adding is maximum than the values that are already added,
    i mean don't remove the smaller number that are already in the queue and then add this number.
    By making this simple constraint of adding the current number only after removing all the smaller number
    from queue we can be sure that the other end will always get the maximum number in of the frame,
    If we move forward in the frame, and we remove the peek of queue the next number that we get
    will also be maximum, try to visualize
    Explanation in copy as well.


 */
