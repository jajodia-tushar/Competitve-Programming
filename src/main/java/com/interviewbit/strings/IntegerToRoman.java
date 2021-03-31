package com.interviewbit.strings;

import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerToRoman {

    public static void main(String[] args) {
        IntegerToRoman obj = new IntegerToRoman();
        System.out.println(obj.intToRoman(3999));
    }

    public String intToRoman(int A) {

        Map<Integer,String> map = new LinkedHashMap<>();
        map.put(1000,"M");
        map.put(900,"CM");
        map.put(500,"D");
        map.put(400,"CD");
        map.put(100,"C");
        map.put(90,"XC");
        map.put(50,"L");
        map.put(40,"XL");
        map.put(10,"X");
        map.put(9,"IX");
        map.put(5,"V");
        map.put(4,"IV");
        map.put(1,"I");

        StringBuilder result = new StringBuilder();

        for(Map.Entry es : map.entrySet()){
            int key = (Integer) es.getKey();
            String value = (String) es.getValue();

            int divide = A / key;
            if (divide <= 3 && divide >= 1) {
                A = A % key;
                int count = divide;
                if (count == 1) {
                    result.append(value);
                } else if (count == 2) {
                    result.append(value).append(value);
                } else {
                    result.append(value).append(value).append(value);
                }
            }

        }
        return result.toString();
    }
}
