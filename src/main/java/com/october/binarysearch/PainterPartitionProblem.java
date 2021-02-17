package com.october.binarysearch;

public class PainterPartitionProblem {

    public static void main(String[] args) {


        PainterPartitionProblem obj = new PainterPartitionProblem();
        System.out.println(obj.paint(1,1000000,new int[]{1000000, 1000000}));

    }

    public int paint(int A, int B, int[] C) {

        int n = C.length;
        long low = 0;
        long high = 0;
        long ans = -1;
        int mod = 10000003;

        for(int i = 0; i < n; i++){
            high += (long)C[i] * (long)B;
        }


        while(low <= high){

            long mid = low + (high - low) / 2;

            if(isPossible(A,mid,B,C)){
                high = mid - 1;
                ans = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return (int) (ans % mod);
    }


    public boolean isPossible(int A,long T,int B, int[] C){

        int count = 0;
        int n = C.length;
        int sum = 0;
        int i = 0;


        while(i < n ){
            if(C[i] > T / B ){
                return false;
            }

            sum += C[i];
            if(sum <= T / B){
                i++;
            }
            else{
                sum = 0;
                count++;
                if( count > A){
                    return false;
                }
            }
        }

        if( sum < T)
            count++;

        return count <= A;
    }
}
