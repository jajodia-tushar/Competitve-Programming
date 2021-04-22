package com.interviewbit.maths;

import com.interviewbit.utils.ArrayUtils;

import java.util.HashMap;

public class HolidayAccommodation {

    public static void main(String[] args) {

        HolidayAccommodation obj = new HolidayAccommodation();
        int n = 6;
        int[][] arr = {{0,3,0,0,0,0},{3,0,4,1,0,0},{0,4,0,0,0,0},{0,1,0,0,8,0},{0,0,0,8,0,5},{0,0,0,0,5,0}};
        int result =  obj.solve(n,arr);
        System.out.println(result);
    }

    public int solve(int n, int[][] arr){

        int row = arr.length;
        int col = arr[0].length;


        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(i == j) continue;
                if(arr[i][j] == 0){

                    int[] tempArray = arr[j];
                    for(int k = 0; k < tempArray.length; k++){
                        if(tempArray[k] != 0 && arr[i][k] != 0){
                            arr[i][j] = arr[i][k] + arr[k][j];
                        }
                    }
                }
            }
        }


        HashMap<Integer, HashMap<Integer,Integer>> maps = new HashMap<>();

        maps.put(1,new HashMap<>(){{
            put(2,3);
        }});
        maps.put(2,new HashMap<>(){{
            put(1,3);
            put(3,4);
            put(4,1);
        }});
        maps.put(3,new HashMap<>(){{
            put(2,4);
        }});

        ArrayUtils.printArray(arr);

        return -1;


    }

}
