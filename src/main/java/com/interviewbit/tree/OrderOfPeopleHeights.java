package com.interviewbit.tree;

import java.util.TreeMap;

/*
Asked in:
Google
You are given the following :

A positive number N
Heights : A list of heights of N persons standing in a queue
Infronts : A list of numbers corresponding to each person (P) that gives the number of persons who are taller than P and standing in front of P
You need to return list of actual order of persons’s height

Consider that heights will be unique

Example

Input :
Heights: 5 3 2 6 1 4
InFronts: 0 1 2 0 3 2
Output :
actual order is: 5 3 2 1 6 4
So, you can see that for the person with height 5, there is no one taller than him who is in front of him, and hence Infronts has 0 for him.

For person with height 3, there is 1 person ( Height : 5 ) in front of him who is taller than him.

You can do similar inference for other people in the list.


 */
public class OrderOfPeopleHeights {

    public static void main(String[] args) {

    }

    public int[] order(int[] A, int[] B) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int l = A.length;
        for (int i = 0; i < l; i++) {
            map.put(A[i], B[i]);
        }
        int res[] = new int[l];
        for (int i = 0; i < l; i++) {
            res[i] = -1;
        }
        while (map.size() != 0) {
            int key = map.firstKey();
            int value = map.get(key);
            //System.out.print(key + " " + value + ",");
            int count = 0;
            for (int j = 0; j < l; j++) {
                if (res[j] == -1) {
                    count++;
                }
                if (count == value + 1) {
                    res[j] = key;
                    break;
                }
            }
           /* for(int j=0; j<l; j++){
                System.out.print(res[j]+",");}
                System.out.print("..");*/
            map.remove(key);
        }
        return res;

    }
}

/*
This problem is slightly tricky.

Really inefficient but correct approach :

Try out all possible permutation of the give numbers, and verify if the infronts numbers match for the given sequence.
This is obviously too inefficient. O(N!).
Lets see if we can do something better.

Hint towards something better

What can you say about the position of the shortest person ? If the position of the shortest person is i, how many people would be in front of the shortest person ?

Once you fix the position of the shortest person, what can you say about the position of the second shortest person ?

If we take that approach, do we need to sort the heights first ?
 */