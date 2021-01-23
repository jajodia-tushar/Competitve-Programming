package com.october.week10;

import java.util.*;

public class Monday {

    public static void main(String[] args) {

        Monday obj = new Monday();
        System.out.println(obj.largestNumber(new int[]{0,0,0,0,0}));
    }

    public String largestNumber(final List<Integer> A) {
        Collections.sort(A, (a, b) -> {
            Double aFirst = Double.parseDouble(a + "" + b);
            Double bFirst = Double.parseDouble(b + "" + a);
            return bFirst.compareTo(aFirst);

        });
        String str = "";
        if (A.get(0) == 0) {
            return "0";
        }

        for (Object o : A) {
            str += o;
        }
        return str;
    }

    public boolean isSwappingNeeded(int a, int b) {
        double aFirst = Double.parseDouble(a + "" + b);
        double bFirst = Double.parseDouble(b + "" + a);
        return bFirst > aFirst;
    }

    public String largestNumber(final int[] A){
        String arr[] = new String[A.length];

        for (int i = 0; i < A.length; i++) {
            arr[i] = String.valueOf(A[i]);
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        StringBuilder string = new StringBuilder();
        for (String str : arr) {
            string.append(str);
        }

        if(arr[0].equals("0"))
            return "0";

        return string.toString();
    }
}


