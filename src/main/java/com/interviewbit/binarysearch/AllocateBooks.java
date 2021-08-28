package com.interviewbit.binarysearch;

/*
Given an array of integers A of size N and an integer B.

College library has N bags,the ith book has A[i] number of pages.

You have to allocate books to B number of students so that maximum number of pages alloted to a student is minimum.

A book will be allocated to exactly one student.
Each student has to be allocated at least one book.
Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
Calculate and return that minimum possible number.

NOTE: Return -1 if a valid assignment is not possible.




Input Format

The first argument given is the integer array A.
The second argument given is the integer B.
Output Format

Return that minimum possible number
Constraints

1 <= N <= 10^5
1 <= A[i] <= 10^5
For Example

Input 1:
    A = [12, 34, 67, 90]
    B = 2
Output 1:
    113
Explanation 1:
    There are 2 number of students. Books can be distributed in following fashion :
        1) [12] and [34, 67, 90]
        Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
        2) [12, 34] and [67, 90]
        Max number of pages is allocated to student 2 with 67 + 90 = 157 pages
        3) [12, 34, 67] and [90]
        Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages

        Of the 3 cases, Option 3 has the minimum pages = 113.

Input 2:
    A = [5, 17, 100, 11]
    B = 4
Output 2:
    100
 */
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

        return count <= B;
    }
}
/*
        Try to think in this term when you are writing the function canAllocateBooks.
        If I am allowed to only allocate Max pages to a student will I be able to
        allocate all the books to the students i have or I will be needing more students.
        return true or false.

        We are able to use binary search in this type of problem because see it is
        kind of a greedy problem you can start from max and then decrease one every time
        you are not able you fail. But this will take a lot of time.
        So binary search can help you find actually the number faster as the number
        to be searched is in kind of sorted array.


 */