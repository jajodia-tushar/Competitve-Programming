package com.interviewbit.arrays;

/*
Problem Description

A hotel manager has to process N advance bookings of rooms for the next season. His hotel has C rooms. Bookings contain an arrival date and a departure date. He wants to find out whether there are enough rooms in the hotel to satisfy the demand. Write a program that solves this problem in time O(N log N) .



Input Format
First argument is an integer array A containing arrival time of booking.
Second argument is an integer array B containing departure time of booking.
Third argument is an integer C denoting the count of rooms.



Output Format
Return True if there are enough rooms for N bookings else return False.
Return 0/1 for C programs.



Example Input
Input 1:

 A = [1, 3, 5]
 B = [2, 6, 8]
 C = 1


Example Output
Output 1:

 0


Example Explanation
Explanation 1:

 At day = 5, there are 2 guests in the hotel. But I have only one room.
 */

import com.interviewbit.utils.ArrayUtils;

import java.util.*;

public class HotelBookingsPossible {

    public static void main(String[] args) {

        HotelBookingsPossible obj = new HotelBookingsPossible();
        ArrayList<Integer> arrival = ArrayUtils.asArrayList(3, 1, 2, 3);
        ArrayList<Integer> depart = ArrayUtils.asArrayList(3, 2, 3, 4);

        boolean result = obj.hotel(arrival, depart, 1);
        System.out.println(result);

    }

    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int k) {
        Collections.sort(arrive);
        Collections.sort(depart);

        int n = arrive.size();
        int departPointer = 0;

        for (int i = 0; i < n; i++) {
            int currArr = arrive.get(i);
            int currDep = depart.get(departPointer);
            if (currArr < currDep) {
                k--;
            } else {
                departPointer++;
            }
            if (k < 0) return false;
        }
        return true;
    }

    public boolean hotelNextSolution(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        Collections.sort(arrive);
        Collections.sort(depart);
        int roomsRequired=0,i=0,j=0;
        while(i<arrive.size()  && j<arrive.size() && roomsRequired<=K){
            if(arrive.get(i)<depart.get(j) ){
                i++;
                roomsRequired++;
            }else{
                j++;
                roomsRequired--;
            }
        }
        if(roomsRequired<=K){
            return true;
        }else{
            return false;
        }
    }
}

/*
    Look Properly I have Sorted Both the arrival and Departure.
    And iterating on over the arrival Event.
    There is a departure pointer.

    My Idea I want to let the guest arrive and want to handle them.
    If there is a arrival and the next departure is yet happen (i.e. it didn't happen till now) (currArr < currDep)
    I will have to allot a new room to the Guest
    So Number of Rooms decrease.
    But if the the room would already be empty before arrival of the guest ( else part of currArr < currDep)
    then I can allot the same room to the Guest so I wouldn't decrease the count of the room.
    If at any point of time number of room becomes less than zero it means I won't be able to serve the
    request of the guest. so I will return false else will return true.

    There is a similar but a different approach in taking this particular problem.
    What I take events as they happen.
    Like in the time frame we plot the arrival and departure.
    I have shown that in the next function.
    Here we don't keep increasing the arrival pointer every time rather
    we try to tackle this question in more time series based approach.

    If Arr < dept it means at current point of time some guest are coming
    so we need to decrease the number of rooms and we can increase the arrival pointer to look for next arrival time.
    Else if Arr >= dept it means at current point of time Some guest are leaving the hotel so
    it will increase the number of room as we will increase the departure pointer to look for next departure time.

    If at any point of time my number of rooms goes more than available rooms I am done and should return false.
    else return true.
    This Seems very logical and understandable to me.



 */
