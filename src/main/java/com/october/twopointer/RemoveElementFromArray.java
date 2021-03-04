package com.october.twopointer;

import com.october.utils.ArrayUtils;

import java.util.ArrayList;

public class RemoveElementFromArray {

    public static void main(String[] args) {
        RemoveElementFromArray obj = new RemoveElementFromArray();
        ArrayList<Integer> arrayList = ArrayUtils.asArrayList(4, 1, 1, 2, 1, 3);
        obj.removeElement(arrayList, 1);
        System.out.println(arrayList);
    }

    public int removeElement(ArrayList<Integer> a, int b) {
        int index = 0;
        int i = 0;
        while( i < a.size()){
            if(a.get(i) == b){
                i++;
            }
            else{
                a.set(index,a.get(i));
                i++;
                index++;
            }
        }

        return index;
    }
}
