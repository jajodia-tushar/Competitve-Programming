package com.interviewbit.stackandqueue;

import com.interviewbit.utils.ArrayUtils;

import java.util.*;

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

        while( j < A.length){
            int item = A[j];

            while(!queue.isEmpty() && queue.getLast() < item){
                queue.removeLast();;
            }
            queue.addLast(A[j]);
            arr[i] = queue.peek();
            j++;
            if( j >= B){
                if(queue.peek() == A[i])
                    queue.remove();
                i++;
            }
        }
        return arr;
    }
}
