package com.interviewbit.strings;

public class MultiplyStrings {

    public static void main(String[] args) {
        MultiplyStrings obj = new MultiplyStrings();
        System.out.println(obj.multiply("31243242535342","01"));
    }

    public String multiply(String A, String B) {

        int n = A.length();
        int m = B.length();

        if(A.equals("0") || B.equals("0")) return "0";

        StringBuilder result = new StringBuilder();
        int carry = 0;

        for(int i = 0; i < n; i++){
            char a = A.charAt(n - i - 1);
            for(int j = 0; j < m; j++){

                int previousItem = 0;
                if( i != 0){
                    int index = i + j + 1;
                    previousItem = result.length() >= index ? Character.getNumericValue(result.charAt(index-1)) : 0;
                }

                char b = B.charAt(m - j -  1);
                int sum = Integer.parseInt(a+"") * Integer.parseInt(b+"") + carry + previousItem;
                int rem = sum % 10;
                carry = sum / 10;
                if(i == 0)
                    result.append(rem);
                else {
                    if (result.length() >= (i + j)) {
                        result.replace(i + j,i+j+1, rem+"");
                    } else {
                        result.append(rem);
                    }
                }
            }
            if(carry != 0){
                result.append(carry);
                carry = 0;
            }
        }
        String string = result.reverse().toString();
        int i = 0;
        while(i < string.length() && string.charAt(i) == '0')
            i++;
        return string.substring(i);
    }
}
