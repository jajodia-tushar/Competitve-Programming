package com.october.strings.extras;

public class ConvertToPalindrome {

    public static void main(String[] args) {
        ConvertToPalindrome obj = new ConvertToPalindrome();
        System.out.println(obj.solve("mnwnn"));
    }

    public int solve(String A) {


        int n = A.length();
        int i = 0;
        int j = n - 1;
        int mistakes = 0;

        while(i <= j){

            if(A.charAt(i) != A.charAt(j)){
                if(mistakes > 1){
                    return 0;
                }
                mistakes++;
                if((i + 1) <= j && (i + 1) < n && A.charAt(i + 1) == A.charAt(j)){
                    j++;
                }
                else if(i <= (j - 1) && (j - 1) < n &&  A.charAt(i) == A.charAt(j-1)){
                    i--;
                }
                else{
                    return 0;
                }
            }

            i++;
            j--;
        }

        if(n % 2 == 0 && mistakes == 0){
            return 0;
        }

        return 1;
    }
}
