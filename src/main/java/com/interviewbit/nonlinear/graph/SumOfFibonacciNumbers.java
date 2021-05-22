package com.interviewbit.nonlinear.graph;

import java.util.ArrayList;

public class SumOfFibonacciNumbers {

    public static void main(String[] args) {
        SumOfFibonacciNumbers obj = new SumOfFibonacciNumbers();
        int result = obj.fibsum(889);
        System.out.println(result);
    }

    public int fibsum(int A) {


        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);

        int numberRequired = A;
        int f = 1;
        int s = 1;

        while( (f + s) <= numberRequired){
            list.add(f + s);
            int temp = s;
            s = f + s;
            f = temp;
        }
        // System.out.println(list);

        int count = 0;
        for(int i = list.size() - 1; i >= 0; i--){
            int num = list.get(i);
            if( numberRequired == 0){
                break;
            }

            if( num <= numberRequired){
                // System.out.println(numberRequired + " -- "+ num);
                count++;
                numberRequired -= num;
            }

        }
        return count;
    }
}
