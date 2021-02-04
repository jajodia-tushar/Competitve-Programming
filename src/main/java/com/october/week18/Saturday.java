package com.october.week18;

import java.util.*;

public class Saturday {

    public int DIVISOR = 1000003;
    /*
            Sorted Permutation Rank with Repeats
     */

    public int findRank(String A) {

        int n  = A.length();
        if( n <= 0){
            return 1;
        }

        long permutationGoneBefore = smallerPermutationsPossible(A);
        return (int) ((permutationGoneBefore + findRank(A.substring(1))) % DIVISOR);
    }

    public int numberOfSmallCharacter(String A){

        char firstCharacter = A.charAt(0);
        int count = 0;

        for(int i = 1; i < A.length(); i++){
            if(firstCharacter > A.charAt(i)){
                count++;
            }
        }
        return count;
    }

    public int smallerPermutationsPossible(String A){

        int n = A.length();

        Map<Character, Integer> charCounts = new HashMap();

        for(int i = 0; i < A.length(); i++) {
            Character ch = A.charAt(i);
            if (charCounts.containsKey(ch)) {
                int count = charCounts.get(ch);
                count++;
                charCounts.put(ch, count);
            } else {
                charCounts.put(ch, 1);
            }
        }
        Optional<Long> reduce =
                charCounts.values().stream()
                        .filter(x-> x > 1).map(this::factorial).reduce((a, b) -> (((a %  DIVISOR) * (b % DIVISOR)) % DIVISOR));

        long nFactorial = factorial(n - 1);
        int numberOfSmallCharacter = numberOfSmallCharacter(A);

        if(reduce.isPresent()){
            long denominator = reduce.get();
            long multiplicativeInverse = calculatePower(denominator,DIVISOR - 2) % DIVISOR;
            return (int) (((nFactorial % DIVISOR) * (multiplicativeInverse % DIVISOR) % DIVISOR) * (numberOfSmallCharacter % DIVISOR));
        }
        else{
            return (int) (nFactorial * numberOfSmallCharacter) % DIVISOR;
        }
    }

    private long calculatePower(long number, long power) {
        if(power == 0){
            return 1;
        }
        if(power == 1){
            return number % DIVISOR;
        }
        long product = calculatePower(number, power / 2);
        long result = (product * product) % DIVISOR;

        if( power % 2 == 0)
            return result % DIVISOR;
        else
            return ((result % DIVISOR ) * (number % DIVISOR)) % DIVISOR;
    }


    public long factorial(int n){
        long sum = 1;
        for(int i = 2; i <= n; i++){
            sum = (((sum % DIVISOR) * (i % DIVISOR)) % DIVISOR);
        }
        return sum;
    }

    /*
    =========================================================================================================================
     */

    public String solve(String A) {

        if(A.length() == 1){
            return "-1";
        }

        boolean isAllAscending = true;
        boolean isAllDescending = true;

        for(int i = 0; i < A.length() - 1 ; i++){
            char firstCharacter = A.charAt(i);
            char secondCharacter = A.charAt(i+1);
            if( !isAllDescending && !isAllAscending){
                break;
            }

            if(firstCharacter > secondCharacter){
                // Descending
                isAllAscending = false;
            }
            else if(firstCharacter < secondCharacter){
                //Ascending
                isAllDescending = false;
            }
        }


        if(isAllDescending){
            return "-1";
        }

        if(isAllAscending){
            return A.substring(0,A.length()-2)
                    + A.charAt(A.length() - 1)
                    + A.charAt(A.length() - 2);
        }

        char[] str = A.toCharArray();
        int n = A.length() - 1;

        while(n > 1 && str[n] < str[n -1]){
            n--;
        }
        swap(str,n,n-1);
        n++;

        while(n < (A.length())){
            if(str[n] < str[n-1]){
                swap(str,n,n-1);
            }
            n++;
        }

        return String.valueOf(str);
    }

    public void swap(char[] str, int i, int j){
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static void main(String[] args) {

        Saturday obj = new Saturday();
        System.out.println(obj.solve("85416895"));
    }



}
