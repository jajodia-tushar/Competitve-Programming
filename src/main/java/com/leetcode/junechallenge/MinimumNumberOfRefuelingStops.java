package com.leetcode.junechallenge;

import java.util.PriorityQueue;

/*
    A car travels from a starting position to a destination which is target miles east of the starting position.
    There are gas stations along the way. The gas stations are represented as an array stations where
    stations[i] = [positioni, fueli] indicates that the ith gas station is positioni miles east of
    the starting position and has fueli liters of gas.

    The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it.
    It uses one liter of gas per one mile that it drives. When the car reaches a gas station, it may
    stop and refuel, transferring all the gas from the station into the car.
    Return the minimum number of refueling stops the car must make in order to reach its destination.
    If it cannot reach the destination, return -1.

    Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there.
    If the car reaches the destination with 0 fuel left, it is still considered to have arrived.

    Example 1:

    Input: target = 1, startFuel = 1, stations = []
    Output: 0
    Explanation: We can reach the target without refueling.
    Example 2:

    Input: target = 100, startFuel = 1, stations = [[10,100]]
    Output: -1
    Explanation: We can not reach the target (or even the first gas station).
    Example 3:

    Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
    Output: 2
    Explanation: We start with 10 liters of fuel.
    We drive to position 10, expending 10 liters of fuel.  We refuel from 0 liters to 60 liters of gas.
    Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
    and refuel from 10 liters to 50 liters of gas.  We then drive to and reach the target.
    We made 2 refueling stops along the way, so we return 2.


    Constraints:

    1 <= target, startFuel <= 109
    0 <= stations.length <= 500
    0 <= positioni <= positioni+1 < target
    1 <= fueli < 109
 */


public class MinimumNumberOfRefuelingStops {

    public static void main(String[] args) {

        MinimumNumberOfRefuelingStops obj = new MinimumNumberOfRefuelingStops();
        int[][] stations = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};
        int startFuel = 10;
        int target = 100;

        int result = obj.minRefuelStops(target, startFuel, stations);
        System.out.println(result);

    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int n = stations.length;
        int count = 0;

        for (int i = 0; i <= n; i++) {
            int currentPosition = i == n ? target : stations[i][0];
            while (currentPosition > startFuel) {
                if (queue.isEmpty()) return -1;
                startFuel += queue.poll();
                count++;
            }
            if (i < n)
                queue.add(stations[i][1]);
        }
        return count;
    }

    // Using Dynamic Programming.
    public int minRefuelStopsDP(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        int[] dp = new int[n + 1];
        dp[0] = startFuel;

        for(int i = 0; i < n; i++){
            for(int k = i; k >= 0; k--){
                if( dp[k] >= stations[i][0]){
                    dp[k + 1] = Math.max(dp[k + 1], dp[k] + stations[i][1]);
                }
            }
        }

        for(int i = 0; i <= n; i++){
            if(dp[i] >= target) return i;
        }
        return -1;
    }
}

/*

    You were just making hype in this question.
    It was really simple.

    Go Greedily. If you don't need to fill the gas at current stations then move on and
    if you reach a station where you will not be able to reach without gas,
    Then what do you think you would do naturally.
    You will fill the maximum gas from the previous possible stations.

    So for that what you can do is keep a heap for max in the previous.
    reachable stations where you didn't fill the gas.

    Careful, see in line 72 we are using while loop not if.
    because it can be possible that we will need to fill from multiple
    previous fuel stations.

    At any point in time if you are in a not reachable station and the heap is also empty then you are gone.

    Even after filling gas from previous stations in maximum format now you are able to reach this current
    stations so here also you will not fill the gas and move forward by storing the current available in heap.

    This gas fuel will be used if are not able to reach any further stations.

    ----------------------------------------------------------------------------------------------------------------------------

    using Dynamic Programing is not very intuitive.
    we say dp[i] is the maximum distance we can reach by refueling at i stations (not ith station).
    So we can iterate over the dp at end and find minimum value of i for which dp[i] >= target.
    How do we update dp ?

    dp[0] = startingFuel.
    By not filling at 0 stations we can happily reach startingFuel distance.

    and for other stations we iterate over all the stations and see
    if we are ith stations at max we could have filled i - 1 number of times.
    so we check if

    by filling i - 1 number of times are we able to reach current station ?
    like
    dp[i - 1] >= stations[i][0]

    if yes,
    what we can do is

    dp[i] will denote the maximum distance we can reach by filling i number of times.
    will be equal to

    dp[i], dp[i - 1] + stations[i][1];


    See now there can also be possibility that by filing i - 2 times as well we could reach this stations
    so we can do this in a loop for k = i - 1 till k >= 0;


    Since our dp starts from 0 and goes till n.
    and there are stations from 0 to n - 1;
    there might have been confusion in the code and upper explanation.

    iterating i as stations means that if we are at ith stations at max we could have filled i times as i starts from 0.

    so take care.


 */