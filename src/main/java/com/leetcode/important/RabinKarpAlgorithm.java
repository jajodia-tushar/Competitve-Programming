package com.leetcode.important;

/*
    String Matching Pattern.
 */
public class RabinKarpAlgorithm {

    public static void main(String[] args) {

    }
}

/*
       Converting the Characters into the Numeric Values for matching.
       Using some hash function.
       This Hash Function should such that
       the next value of the hash can be easily calculated by the previous value.

       So You convert the pattern into a hash value using the hash function.
       Now, From the string you take the size of the pattern characters
       Hash them and see if both the hash, hash of pattern and string are matching.
       If yes then start comparing the characters,
       else you can proceed the window size.
       Now here instead of again calculating the hash you should be able to
       use the previous hash value to calculate the hash value of the next
       window.
       This is the complete idea.

       RabinKarp suggests to use the hash function with power of 10.
       Each character is multiplied with 10th power starting with 0 from right till m - 1 in the left
       where m is the size of the pattern.

       And each alphabet is replaced with it's value can be 1 to 26 as well.

 */