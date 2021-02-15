package com.october.week20;
import java.util.Arrays;
import java.util.Comparator;

public class HotelBookingPossibility {
    /*
        A hotel manager has to process N advance bookings of rooms for the next season.
        His hotel has C rooms. Bookings contain an arrival date and a departure date.
        He wants to find out whether there are enough rooms in the hotel to satisfy the demand.
        Write a program that solves this problem in time O(N log N) .

     */
    static boolean areBookingsPossible(int arrival[],
                                       int departure[],
                                       int n, int k)
    {
        Pair ans[] = new Pair[2*n];

        // create a common vector both arrivals
        // and departures.
        int j = 0;
        for (int i = 0; i < n; i++)
        {
            ans[i + j] = new Pair(arrival[i], 1);
            ans[i + j + 1] = new Pair(departure[i], 0);
            j++;
        }

        // sort the vector
        Compare obj = new Compare();
        obj.compare(ans, 2 * n);
        int curr_active = 0, max_active = 0;
        for (int i = 0; i < 2 * n; i++)
        {

            // if new arrival, increment current
            // guests count and update max active
            // guests so far
            if (ans[i].y == 1)
            {
                curr_active++;
                max_active = Math.max(max_active,
                        curr_active);
            }

            // if a guest departs, decrement
            // current guests count.
            else
                curr_active--;
        }

        // if max active guests at any instant
        // were more than the available rooms,
        // return false. Else return true.
        return (k >= max_active);
    }

    // Driver code
    public static void main(String[] args)
    {
        int arrival[] = { 1, 3, 5 };
        int departure[] = { 2, 6, 8 };
        int n = arrival.length;
        System.out.println(areBookingsPossible(arrival, departure, n, 1) ? "Yes" : "No");
    }

}



// User defined Pair class
class Pair {
    int x;
    int y;

    // Constructor
    public Pair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

// class to define user defined conparator
class Compare {

    static void compare(Pair arr[], int n)
    {

        // Comparator to sort the pair according to second element
        Arrays.sort(arr, new Comparator<Pair>() {
            @Override public int compare(Pair p1, Pair p2)
            {
                return Integer.valueOf(p1.x).compareTo(p2.x);
            }
        });
    }
}
