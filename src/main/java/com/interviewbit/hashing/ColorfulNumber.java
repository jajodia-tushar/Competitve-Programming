package com.interviewbit.hashing;

import java.util.HashSet;

//    For Given Number N find if its COLORFUL number or not
public class ColorfulNumber {

    public static void main(String[] args) {
        ColorfulNumber obj = new ColorfulNumber();
        System.out.println(obj.colorful(3245));
    }


    public int colorful(int str) {

        HashSet<Integer> set = new HashSet<>();
        String A = str + "";
        for(int i = 0; i < A.length(); i++){
            int num = A.charAt(i) - '0';

            if(set.contains(num)) return 0;
            else set.add(num);

            for(int j = i + 1; j < A.length(); j++){
                num = num * (A.charAt(j) - '0');
                if(set.contains(num)) return 0;
                else set.add(num);
            }
        }
        return 1;
    }
}
