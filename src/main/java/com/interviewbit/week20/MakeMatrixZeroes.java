package com.interviewbit.week20;

import java.util.ArrayList;

public class MakeMatrixZeroes {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>>  arr = new ArrayList<>()
        {{  add(new ArrayList<>()
            {{  add(0);
                add(0);
            }});

            add(new ArrayList<>()
            {{  add(1);
                add(1);
            }});

        }};

        MakeMatrixZeroes obj = new MakeMatrixZeroes();
        obj.setZeroes(arr);
        System.out.println(arr);

    }

    public void setZeroes(ArrayList<ArrayList<Integer>> a) {

        int m = a.size();
        int n = a.get(0).size();
        boolean c = false;
        boolean r = false;
        for(int i = 0; i < m; i++){
            int item = a.get(i).get(0);
            if(item == 0){
                c = true;
                break;
            }
        }

        for(int i = 0; i < n; i++){
            int item = a.get(0).get(i);
            if(item == 0){
                r = true;
            }
        }


        for(int i = 0; i < m; i++){
            for(int j = 0; j < n ;j++){
                int item = a.get(i).get(j);
                if(item == 0){
                    a.get(0).set(j,Integer.MIN_VALUE);
                    a.get(i).set(0,Integer.MIN_VALUE);
                }

            }
        }

        for(int i = 1; i < a.size(); i++){
            int item = a.get(i).get(0);
            if(item < 0){
                makeRowZeros(a.get(i));
            }
        }

        for(int i = 1; i < a.get(0).size(); i++){
            int item = a.get(0).get(i);
            if(item < 0){
                makeColZeros(a,i);
            }
        }


        if(r){
            for(int i = 0; i < n; i++){
                a.get(0).set(i,0);
            }
        }

        if(c){
            for(int i = 0; i < m; i++){
                a.get(i).set(0,0);
            }
        }
    }

    public void makeRowZeros(ArrayList<Integer> row){
        for(int i = 1; i < row.size(); i++){
            row.set(i,0);
        }
    }

    public void makeColZeros(ArrayList<ArrayList<Integer>> arr,int col){
        for(int i = 1; i < arr.size(); i++){
            arr.get(i).set(col,0);
        }

    }
}
