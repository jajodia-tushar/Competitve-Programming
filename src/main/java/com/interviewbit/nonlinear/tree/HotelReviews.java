package com.interviewbit.nonlinear.tree;

import com.interviewbit.nonlinear.util.TierNode;
import com.interviewbit.utils.ArrayUtils;

import java.util.*;

public class HotelReviews {

    public static void main(String[] args) {

        HotelReviews obj = new HotelReviews();
        String A = "cool_ice_wifi";
        String[] B = {"water_is_cool", "cold_ice_drink", "cool_wifi_speed"};

        int[] result = obj.solve(A,B);
        ArrayUtils.printArray(result);
    }

    public int[] solve(String A, String[] B) {

        TierNode root = new TierNode();
        String[] goodWords = A.split("_");
        for(String key : goodWords){
            root.insert(key);
        }

        ArrayList<PairPointsOriginalIndex> sets = new ArrayList<>();

        for(int i = 0; i < B.length; i++){
            String[] keys = B[i].split("_");
            int points = 0;
            for( String key : keys){
                if( root.search(key)){
                    points++;
                }
            }
            PairPointsOriginalIndex pair = new PairPointsOriginalIndex();
            pair.points = points;
            pair.originalIndex = i;
            sets.add(pair);
        }
        Collections.sort(sets);

        return sets.stream().mapToInt(x -> x.originalIndex).toArray();
    }
}

class PairPointsOriginalIndex implements Comparable<PairPointsOriginalIndex>{

    public int points;
    public int originalIndex;

    @Override
    public int compareTo(PairPointsOriginalIndex pair){
        return Integer.compare(pair.points,this.points);
    }

}