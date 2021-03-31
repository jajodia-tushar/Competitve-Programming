package com.interviewbit.week5;

import com.interviewbit.utils.Heap;
import com.interviewbit.utils.MaxHeap;

import static com.interviewbit.utils.ArrayUtils.printArray;

public class Wednesday {

    /*
    Given an Array of Length l the problem is to rotate the array by K elements in Optimal way.
     */

    public static void main(String[] args) {
        Wednesday wednesday = new Wednesday();
//        callFirstQuestion(wednesday);
        callSecondSolution(wednesday);
    }

    private static void callSecondSolution(Wednesday wednesday) {
        int arr[] = {7,8,6,18,3,2,1,6,9};
        int k = 2;
        Heap maxHeap = new MaxHeap(arr.length);
        for (int i : arr){
            maxHeap.insert(i);
        }
        for(int i = 0; i < 2; i++){
            System.out.print(maxHeap.getTopItem()+", ");
        }
    }

    private static void callFirstQuestion(Wednesday wednesday) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        wednesday.reverse(arr,0,8);
        wednesday.rotate(arr,3);
        printArray(arr);
    }

    // Question 1. Rotate the Array using Reversing Technique.

    public void reverse(int[] arr,int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] arr, int d){
        reverse(arr,0,d-1);
        reverse(arr,d, arr.length - 1);
        reverse(arr, 0 , arr.length - 1);
    }



/*

Rotation of Array is equal to arr[] for d elements is equal to
    Reverse(arr,0,d)
    Reverse(arr,d+1,n)
    Reverse(arr,0,n)

It is so Counterintuitive Now.

   Eg.
    arr = [1,2,3,4,5,6,7,8,9], n = 9, d = 3;

    Reverse(arr,0,d) = Reverse(arr,0,3) = [3,2,1,4,5,6,7,8,9]
    Reverse(arr,d+1,n) = Reverse(arr,4,8) = [3,2,1,9,8,7,6,5,4]
    Reverse(arr,0,n) = Reverse(arr,0,9) = [4,5,6,7,8,9,1,2,3]

    And This is the Answer.

    For Reversing We don't need anything Special We can iterate using two pointers,one in the starting and the other at the ending.
    We keep on swapping elements in the pointer and then keep increasing the starting pointer and decrease the ending pointer until
    both of them are equal. Similar to the one we used to do in Quick Sort.
 */



/* Question 2. Find the K largest/Smallest Element in the Given.
    N = 5, K = 2
    Arr[] = {12, 5, 787, 1, 23}
    Output: 787 23
    Explanation: 1st largest element in the
    array is 787 and second largest is 23.
    Technique 1. Is to use to Bubble Sort technique and only run to outer loop for k times.
    Time Complexity is O(k*n) = n^2
 */


    public void solution1BubbleSort(int arr[], int k){
        int n = arr.length;
        for(int i = 0; i < k; i++){
            for( int j = 0; j < (n - i - 1); j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] =  temp;
                }
            }
        }

        for(int i = 0; i < k; i++){
            System.out.println(arr[n-1-i]);
        }
    }

    /*
    Technique 2
    Using Quick Sort to Sort the Array in O(n * log(n))
    Just A Small revision on the Quick Sort.

    Partition is the hero.
    You will need to take a pivot and then make a virtual partition of the array into two parts such that
    all the elements are smaller on the left of a particular point and all elements that are greater are on the right
    of a particular point and return this particular point.

    Now if we repeat the same step again and again for the left sub array and right sub array we are going to solve this.
    Now the array is sorted you will just need to print the k elements from the sorted array from end.

     */

    public void solution2QuickSort(int[] arr, int k){
        quickSort(arr,0, arr.length - 1);
        for(int i = arr.length - 1; i >arr.length - k - 1; i--){
            System.out.print(arr[i]+", ");
        }


    }

    public int partition(int arr[], int low, int high){
        int pivot = arr[high];
        int i = low - 1;
        while(low < high){
            if(arr[low] < pivot){
                i++;
                swap(arr, i, low);
            }
            low++;
        }
        swap(arr, i+1, high);
        return i + 1;
    }

    private void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }


    public void quickSort(int arr[], int low, int high){

        if(low < high) {
            int partition = partition(arr, low, high);
            quickSort(arr, low, partition-1);
            quickSort(arr, partition + 1, high);
        }
    }

    /*
    Technique 3 is to use the Max Heap. and pop k items after insertion is complete.
    and then the Technique is
    Heap are the data structure that are complete binary tree and these things gives insertion, updatation and deletion in oder of O(nlogn)
    so they are great for these types of questions.
     */

}







