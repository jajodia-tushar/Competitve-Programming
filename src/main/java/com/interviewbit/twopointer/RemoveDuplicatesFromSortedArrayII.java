package com.interviewbit.twopointer;

import java.util.Arrays;
import java.util.List;

public class RemoveDuplicatesFromSortedArrayII {

    public static void main(String[] args) {

        List integers = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3);
        RemoveDuplicatesFromSortedArrayII obj = new RemoveDuplicatesFromSortedArrayII();
        System.out.println(obj.removeDuplicates(integers));
        System.out.println(integers);
    }

    public int removeDuplicates(List<Integer> a) {

        int first = 0;
        int next = 1;
        int index = 1;
        int count = 0;
        while(next < a.size()){

            if(a.get(first).equals(a.get(next)) && (count == 1)){
                next++;
            }
            else if(a.get(first).equals(a.get(next))){
                count++;
                a.set(index,a.get(next));
                index++;
            }
            else{
                a.set(index,a.get(next));
                first = next;
                next++;
                index++;
                count = 0;
            }
        }
        return index;

    }
}
