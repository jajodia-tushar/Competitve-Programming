package com.interviewbit.week17;

public class Saturday {
    /*
        Calculate the Factorial of 100.
     */


    public String calculateFactorial(int n ){
        int res[] = new int[200];
        res[0] = 1;
        int resSize = 1;
        int product = 0;

        for(int i = 2; i <=n ; i++){
            int carry = 0;
            for(int j = 0; j < resSize; j++){
                product =  (res[j] * i) + carry;
                carry = product / 10;
                product = product % 10;
                res[j] = product;
            }
            while( carry != 0){
                res[resSize] = carry % 10;
                carry = carry / 10;
                resSize++;
            }
        }
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < resSize; i++){
            str.append(res[i]);
        }
        return str.reverse().toString();
    }

    static void modInverse(int a, int m)
    {
        int g = gcd(a, m);
        if (g != 1)
            System.out.println("Inverse doesn't exist");
        else
        {
            // If a and m are relatively prime, then modulo
            // inverse is a^(m-2) mode m
            System.out.println(
                    "Modular multiplicative inverse is "
                            + power(a, m - 2, m));
        }
    }

    // To compute x^y under modulo m
    static int power(int x, int y, int m)
    {
        if (y == 0)
            return 1;

        int p = power(x, y / 2, m) % m;
        p = (p * p) % m;

        if (y % 2 == 0)
            return p;
        else
            return (x * p) % m;
    }

    static int power(int x, int y){
        if( y == 0) return 1;
        return y % 2 == 0 ? power(x, y/2) * power(x, y/2) : power(x, y/2) * power(x, y/2) * x;
    }

    // Function to return gcd of a and b
    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    // Driver Code
    public static void main(String args[])
    {
        int a = 3, m = 11;

        // Function call
//        modInverse(a, m);
        System.out.println(power(2,10));
    }

}
