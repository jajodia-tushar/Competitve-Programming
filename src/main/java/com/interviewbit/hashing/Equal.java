package com.interviewbit.hashing;

import com.interviewbit.utils.ArrayUtils;

import java.util.*;

/*
    Given an array A of integers, find the index of values that satisfy A + B = C + D, where A,B,C & D are integers values in the array
 */
public class Equal {

    public static void main(String[] args) {
        Equal obj = new Equal();
        int[] ints = ArrayUtils.asArrays(3, 4, 7, 1, 2, 9, 8);
        int[] equal = obj.equal(ints);
        ArrayUtils.printArray(equal);
    }

    public int[] equal(int[] A) {

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int n = A.length;

        int[] result = null;

        for(int i = 0; i < n; i++){
            int itemI = A[i];
            for(int j = i + 1; j < n; j++){
                int itemJ = A[j];
                int sum = itemI + itemJ;
                if(map.containsKey(sum)){
                    ArrayList<Integer> list = map.get(sum);
                    int a = list.get(0);
                    int b = list.get(1);
                    int c = i;
                    int d = j;

                    if( a < b && c < d && a < c && b != c && b != d){

                        if(result == null){
                            result =  new int[]{a,b,c,d};
                        }
                        else{

                            if((a < result[0])
                                    ||  (a == result[0] && b < result[1])
                                    || ( a == result[0] && b == result[1] && c < result[2])
                                    || (a == result[0] && b == result[1] &&  c == result[2] && d < result[3])){
                                result = new int[]{a,b,c,d};
                            }
                        }
                    }
                }
                else{
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    map.put(sum,list);
                }
            }
        }

        if( result == null)
            return new int[0];

        return result;


    }
}
