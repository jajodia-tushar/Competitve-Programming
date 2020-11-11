package com.october.week5;

public class Tuesday {

    public static void main(String[] args) {
        Tuesday obj = new Tuesday();
        int arr[] = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        obj.arrayRotation(arr,arr.length,5);
        for (int x : arr)
            System.out.print(x+", ");
    }

    public int findGCD(int x , int y){
        if(y == 0)
            return x;
        else
            return findGCD(y, x % y);
    }

    public void arrayRotation(int[] arr, int size, int diff){
        int gcd = findGCD(size, diff);  // Divide the array into groups equal to GCD.
        for(int i = 0; i < gcd; i++){   // Iterate Outer Loop.
            int j = i;
            int temp = arr[i];          // Save the first Element of the Group
            while(true){                // Iterate each groups and then shift all the elements 1 step forward.
                int k = j + diff;       // Next element in the group will be `diff` elements apart.
                k %= size;              // So that k doesn't gross the size of array. Null pointer Exception

                if(i == k)              // if K has reached in the starting position of group that means now we will need to exit
                    break;
                arr[j] = arr[k];       // if not reached swap the items
                j = k;
            }
            arr[j] = temp;             // Finally place the first element of the group in it's correct position
        }


    }

}

/*

Arrays,
Refreshing and trying already learned things.
This week I am trying to cover all the revision topics.

I know about Arrays and How they Function.
 */

/* =========================================================== GCD ================================================================================
This Method of GCD is now so Counter intuitive. Because, What you are doing essentially is that you are trying to reduce the problem in smaller
size. You just know one thing that if the smaller number divides the bigger number the GCD is the smaller number. Now you don't know how to calculate
the GCD. So you reduce the problem into smaller problem without altering the question !

There is one thing to observe in the problem. GCD is the highest number to divide both the numbers. Now if you subtract the bigger number with the
smaller number this new number has to also be divisible to GCD and you can be sure that no number greater than GCD will be able to divide the new
number as well. How ? (Think about it, You are actually subtracting the bigger number with the smaller number. Now both the number are multiple of a
GCD, so that the number you obtain has to be the multiple of GCD also, Now lets say that the new number that you obtain is divisible by a greater number
than the GCD but this new number will not affect the original GCD because this new number will not divide the other number from which you subtracted
and if it is able to divide than this is your correct GCD).

 */