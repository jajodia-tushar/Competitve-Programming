package com.october.strings;

public class CountAndSay {

    public static void main(String[] args) {
        CountAndSay obj = new CountAndSay();
        System.out.println(obj.countAndSay(2));
    }

    public String countAndSay(int A) {
        if( A == 1) return "1";
        String ASmall = countAndSay(A - 1)+"*";

        int n = ASmall.length();
        int i = 0;
        int k = 1;
        StringBuilder result = new StringBuilder();
        while( i < n - 1){
            char chCurrent = ASmall.charAt(i);
            char chNext = ASmall.charAt(i + 1);
            if(chCurrent == chNext){
                k++;
            }
            else{
                result.append(k).append(chCurrent);
                k = 1;
            }
            i++;
        }

        return result.toString();
    }


}
