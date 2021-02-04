package com.october.week18;

import java.util.Arrays;

public class PrimeNumbers {
    public static void main(String[] args) {

        PrimeNumbers obj = new PrimeNumbers();
//        int[] booleans = obj.primeSum(1048574);
//        for(int i = 0; i < booleans.length; i++){
//                System.out.println(booleans[i]);
//        }
//        System.out.println();

//        System.out.println(obj.hammingDistance(new int[]{2,5,6}));

//        System.out.println(obj.solveStepProblem(98));
        obj.solve("124356");
    }

    public boolean[] generatePrimeNumbersLessThan(int n){

        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr, true);
        arr[0] = false;
        arr[1] = false;
        arr[2] = true;

        for(int i = 2; i * i < n + 1; i++){
            if(arr[i]){
                for(int j = i*i; j < n + 1; j+=i){
                    arr[j] = false;
                }
            }
        }
        return arr;
    }

    public int[] primeSum(int A) {


        boolean[] arr = new boolean[A + 1];
        Arrays.fill(arr,true);

        arr[0] = false;
        arr[1] = false;
        arr[2] = true;

        for(int i = 2; i < A + 1; i++){
            if(arr[i]){
                for(int j = i * i; j < A + 1; j+=i){
                    arr[j] = false;
                }

            }
        }

        for (int p = 2; p * p <= A + 1; p++)
        {
            // If isPrime[p] is not changed,
            // then it is a prime
            if (arr[p] == true)
            {
                // Update all multiples of p
                for (int i = p * p; i < A + 1; i += p)
                    arr[i] = false;
            }
        }


        for(int i = 0; i < A+1; i++){
            if(arr[i] && arr[A - i]){
                return new int[]{i, A - i};
            }
        }

        throw new RuntimeException();
    }

    public int hammingDistance(final int[] A) {
        int sum = 0;

        for(int i = 0; i < A.length; i++){
            for(int j = i+1; j < A.length; j++){
                int x = A[i] ^ A[j];
                sum += countBits(x);
            }
        }

        return sum;

    }

    public int countBits(int number){
        if(number > 0){
            return (int)(Math.log(number) /
                    Math.log(2) + 1);
        }
        else return 0;

    }

    public int solveStepProblem(int A) {

        int num1 = (int) (-1 + (Math.sqrt(1 + 8 * A))) / (2);

        if (calculateSumOfFirstNNaturalNumber(num1) == A) {
            return num1;
        } else {
            while (true) {
                int x = calculateSumOfFirstNNaturalNumber(num1);
                num1++;
                int y = calculateSumOfFirstNNaturalNumber(num1);
                int diff = y - x;
                if (diff % 2 == 0) {
                    return num1;
                }
            }
        }
    }
        public int calculateSumOfFirstNNaturalNumber(int n){
            return n * ( n + 1 ) / 2;
        }

    public String solve(String A) {

        int size = A.length();

        if(size % 2 == 0){

            int rightMiddle = size / 2;
            int leftMiddle = rightMiddle - 1;


            int left = leftMiddle - 1;
            int right = rightMiddle + 1;
            boolean changeMiddle = false;
            boolean lrSame = true;

            while(left != -1 && (right - 1 ) != size){
                char l = A.charAt(left);
                char r = A.charAt(right);
                if(l != r){
                    lrSame = false;
                    A = A.substring(0,right) + l + A.substring(right + 1);
                }
                if( r > l || lrSame){ changeMiddle = true;}
                left --;
                right++;
            }

            if( rightMiddle < leftMiddle){
                // makeRigtMiddle = leftMiddle;
                A = A.substring(0,leftMiddle + 1) + A.charAt(leftMiddle) + A.substring(rightMiddle + 1);
            }
            else if( rightMiddle > leftMiddle){
                if(rightMiddle == 9){

                }
                else{
                    //makeLeftMiddle = rightMiddle;
                    A = A.substring(0,leftMiddle) + A.charAt(rightMiddle) + A.substring(rightMiddle);
                }
            }
            return A;
        }
        else{
            int middle = size / 2;
            int left = middle - 1;
            int right = middle + 1;
            boolean changeMiddle = false;
            boolean lrSame = true;

            while(left != -1 && (right - 1 ) != size){
                char l = A.charAt(left);
                char r = A.charAt(right);
                if(l != r){
                    lrSame = false;
                    A = A.substring(0,right) + l + A.substring(right + 1);
                }
                if( r > l || lrSame){ changeMiddle = true;}

                left --;
                right++;
            }
            if(changeMiddle){
                char newMiddle = (char) (A.charAt(middle) + 1);
                A = A.substring(0,middle) + newMiddle + A.substring(middle + 1);
            }
            return A;
        }



    }

    }


