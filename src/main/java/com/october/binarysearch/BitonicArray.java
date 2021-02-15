package com.october.binarysearch;

public class BitonicArray {

    public static void main(String[] args) {
        BitonicArray obj =new BitonicArray();


        int[] ints = {5, 6, 7, 8, 9,10,3,2,1};
        System.out.println(obj.solve(ints, 1));
    }


    public int solve(int[] A, int B) {
        int bitonicPoint = findBitonicPoint(A);

        int index = binarySearchNormal(0,bitonicPoint,B,A);
        return index != -1 ? index : binarySearchReverse(bitonicPoint,A.length -1 ,B,A);
    }


    public int binarySearchNormal(int low, int high, int num, int[] A){

        while(high >= low){

            int mid = (high + low) / 2;

            if( A[mid] > num){
                high = mid - 1;
            }
            else if( A[mid] < num){
                low = mid + 1;
            }
            else{
                return mid;
            }
        }

        return -1;
    }

    public int binarySearchReverse(int low, int high, int num, int[] A){

        while(high >= low){

            int mid = (high + low) / 2;

            if( A[mid] < num){
                high = mid - 1;
            }
            else if( A[mid] > num){
                low = mid + 1;
            }
            else{
                return mid;
            }
        }

        return -1;
    }



    public int findBitonicPoint(int[] A) {

        int low = 0;
        int high = A.length;

        while (high > low) {
            int mid = (low + high) / 2;
            int midElement = A[mid];

            int midLeft = mid - 1;
            int midRight = mid + 1;

            if ((midLeft >= 0 && A[midLeft] >= midElement)) {
                high = mid;
            } else if ((midRight < A.length && A[midRight] >= midElement)) {
                low = mid;
            } else {
                return mid;
            }
        }

        if(A[0] > A[A.length - 1]){
            return 0;
        }
        else{
            return A.length - 1;
        }
    }

}
