package com.interviewbit.strings;

public class RomanToInteger {

    public static void main(String[] args) {
        RomanToInteger obj = new RomanToInteger();
        System.out.println(obj.romanToInt("MMMXXXI"));
    }

    public int romanToInt(String A) {

        int n = A.length();
        int result = 0;

        for(int i = 0; i < n; i++){

            int first = getIntValue(A.charAt(i));

            if( i < (n - 1)){
                int second = getIntValue(A.charAt(i+1));
                if(second > first){
                    result = result + (second - first);
                    i++;
                }
                else{
                    result = result + first;
                }
            }
            else{
                result = result + first;
            }
        }

        return result;


    }

    public int getIntValue(char ch){

        if(ch == 'I')
            return 1;
        else if(ch == 'V')
            return 5;
        else if(ch == 'X')
            return 10;
        else if(ch == 'L')
            return 50;
        else if(ch == 'C')
            return 100;
        else if(ch == 'D')
            return 500;
        else
            return 1000;
    }
}
