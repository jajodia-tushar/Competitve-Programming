package com.october.binarysearch;

public class AllocateBooks {

    public static void main(String[] args) {

        AllocateBooks obj = new AllocateBooks();
        System.out.println(obj.books(new int[]{12, 34, 67, 90},2));
    }

    public int books(int[] A, int B) {


        if( B > A.length) return -1;
        int low = A[0];
        int high = 0;
        for(int i = 0; i < A.length; i++){
            high += A[i];
        }
        int ans = -1;

        while(low <= high){
            int mid = (low + high)/2;
            boolean status = canBooksBeAllocated(A,mid,B);

            if(status){
                ans = mid;
                high=mid-1;
            }
            else
                low=mid+1;
        }

        return low;

    }


    public boolean canBooksBeAllocated(int[] A, int max, int B){

        int count = 0;
        int i = 0;
        int sum = 0;
        int size = A.length;

        while(i < size){
            if(A[i] > max)
                return false;

            sum += A[i];
            if( sum <= max){
                i++;
            }
            else{
                sum = 0;
                count++;
                if( count > B)
                    return false;
            }
        }

        if(sum != 0){
            count++;
        }

        return count > B ? false : true;
    }
}
