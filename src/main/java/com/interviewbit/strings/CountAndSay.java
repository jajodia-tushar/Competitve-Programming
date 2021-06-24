package com.interviewbit.strings;
/*
The count-and-say sequence is the sequence of integers beginning as follows:

1, 11, 21, 1211, 111221, ...
1 is read off as one 1 or 11.
11 is read off as two 1s or 21.

21 is read off as one 2, then one 1 or 1211.

Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

Example:

if n = 2,
the sequence is 11.
 */
public class CountAndSay {

    public static void main(String[] args) {
        CountAndSay obj = new CountAndSay();
        System.out.println(obj.countAndSay(3));
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

/*
    Don't get panic.
    Things are straight and easy.
    Just use recursive and try to bulid things on them.

 */
