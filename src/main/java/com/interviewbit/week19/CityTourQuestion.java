package com.interviewbit.week19;

import java.util.*;

public class CityTourQuestion {

    public int DIVISOR = 1000000007;

    public int solve(int A, int[] B) {
        int n = A - B.length;
        Arrays.sort(B);
        List<Integer> subLists = new ArrayList();

        subLists.add(B[0] - 1);
        for(int i = 1; i < B.length; i++){
            subLists.add(B[i] - B[i - 1] - 1);
        }
        subLists.add(A - B[B.length - 1]);

        long finalAns = factorial(n);
        for(int i = 0; i < subLists.size(); i++){
            int item = subLists.get(i);
            if( item > 1 ){
                finalAns = (finalAns * power(factorial(item),DIVISOR - 2) ) % DIVISOR;

                if( (i != 0 ) && (i != (subLists.size() - 1))){
                    finalAns = (finalAns * power(2,item - 1)) % DIVISOR;
                }
            }
        }
        return (int)(finalAns % DIVISOR);
    }


    public long power(long num, long power){
        if( power == 0)
            return 1;

        if(power == 1)
            return num % DIVISOR;


        long r =  power(num, power/2);
        r = (r * r) % DIVISOR;

        if(power % 2 != 0)
            return (r * num) % DIVISOR;

        return r % DIVISOR;
    }

    public long factorial(int N){
        int sum = 1;
        for(int i = 2; i <= N; i++){
            sum = ( sum * i ) % DIVISOR;
        }
        return sum % DIVISOR;
    }

    public static void main(String[] args) {
        CityTourQuestion obj = new CityTourQuestion();
        System.out.println(obj.solve(3, new int[]{1}));
    }
}
