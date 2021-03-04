package com.october.twopointer;

import java.util.ArrayList;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5000);
        arr.add(5000);
        arr.add(5000);
        System.out.println(obj.removeDuplicates(arr));
    }

    public int removeDuplicates(ArrayList<Integer> a) {

        int first = 0;
        int next = 1;
        int index = 1;
        while(next < a.size()){

            if(a.get(first).equals(a.get(next))){
                a.set(next,Integer.MAX_VALUE);
                next++;
            }
            else{
                a.set(index,a.get(next));
                first = next;
                next++;
                index++;
            }
        }
        return index;

    }
}
