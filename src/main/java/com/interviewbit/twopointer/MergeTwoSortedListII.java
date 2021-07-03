package com.interviewbit.twopointer;

import com.interviewbit.utils.ArrayUtils;

import java.util.ArrayList;

/*
Given two sorted integer arrays A and B, merge B into A as one sorted array.

 Note: You have to modify the array A to contain the merge of A and B. Do not output anything in your code.
TIP: C users, please malloc the result into a new array and return the result.
If the number of elements initialized in A and B are m and n respectively, the resulting size of array A after your code is executed should be m + n
Example :
Input :
         A : [1 5 8]
         B : [6 9]
Modified A : [1 5 6 8 9]
 */
public class MergeTwoSortedListII {

    public static void main(String[] args) {

        MergeTwoSortedListII obj = new MergeTwoSortedListII();
        ArrayList<Integer> a = ArrayUtils.asArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        ArrayList<Integer> b = ArrayUtils.asArrayList(11, 111, 1111, 32111, 111111, 999999);
        obj.merge(a, b);
        System.out.println(a);
    }

    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {

        int j = 0;
        int i = a.size() - 1;
        while (j < b.size()) {
            a.add(0);
            j++;
        }

        int k = a.size() - 1;
        j--;

        while (i >= 0 && j >= 0) {

            int A = a.get(i);
            int B = b.get(j);

            if (A > B) {
                a.set(k, A);
                i--;
            } else {
                a.set(k, B);
                j--;
            }
            k--;
        }

        if (i == -1) {
            while (j >= 0) {
                a.set(k, b.get(j));
                j--;
                k--;
            }
        }

    }
}

/*
       The Technique is Amazing. You can already add B.size() spaces in Array A.
       Now You just have to fill in the values in there.
       You should start from the End ( Have reason)
       and then put two pointers in the end of the both array.
       Valid A and B
       array and then iterate over as in merge sort.


       Why you can't start from the beginning is because you already have real values in
       Array A and now you want to use this as aux array as well.
       the Problem is if you have the smaller values in the B array you will have to place
       those in the actual position of values of A now where will you place those values of Array A.

       While filling from the back at worst what can happen is all the array from B are greater than array a value
       even in that case you don't need to change any of the values in array A.
       If some values are matched from A and some values from B then also no problem because if we are matching x places
       from Array A then x places from Last in the valid A range would be already copied so our pointer will move
       towards left.
       Try to visualize and you shall do it.

 */