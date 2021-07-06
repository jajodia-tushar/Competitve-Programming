package com.interviewbit.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

/*
Problem Description

Given a string A denoting a stream of lowercase alphabets. You have to make new string B.

B is formed such that we have to find first non-repeating character each time a character is inserted to the stream and append it at the end to B. If no non-repeating character is found then append '#' at the end of B.



Problem Constraints
1 <= length of the string <= 100000



Input Format
The only argument given is string A.



Output Format
Return a string B after processing the stream of lowercase alphabets A.



Example Input
Input 1:

 A = "abadbc"
Input 2:

 A = "abcabc"


Example Output
Output 1:

 "aabbdd"
Output 2:

 "aaabc#"


Example Explanation
Explanation 1:

    "a"      -   first non repeating character 'a'
    "ab"     -   first non repeating character 'a'
    "aba"    -   first non repeating character 'b'
    "abad"   -   first non repeating character 'b'
    "abadb"  -   first non repeating character 'd'
    "abadbc" -   first non repeating character 'd'
Explanation 2:

    "a"      -   first non repeating character 'a'
    "ab"     -   first non repeating character 'a'
    "abc"    -   first non repeating character 'a'
    "abca"   -   first non repeating character 'b'
    "abcab"  -   first non repeating character 'c'
    "abcabc" -   no non repeating character so '#'

 */

public class FirstNonRepeatingCharacterInAStreamOfCharacters {

    public static void main(String[] args) {
        FirstNonRepeatingCharacterInAStreamOfCharacters obj = new FirstNonRepeatingCharacterInAStreamOfCharacters();
        System.out.println(obj.solve("jyhrcwuengcbnuchctluxjgtxqtfvrebveewgasluuwooupcyxwgl"));
    }

    public String solve(String A) {
        Queue<Character> queue = new LinkedList<>();
        int[] arr = new int[26];
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < A.length(); i++) {
            queue.add(A.charAt(i));
            arr[A.charAt(i) - 97]++;

            while (!queue.isEmpty() && arr[queue.peek() - 97] != 1) {
                queue.remove();
            }

            if (!queue.isEmpty())
                str.append(queue.peek());
            else
                str.append('#');
        }
        return str.toString();
    }
}
/*
    Very Basic Question with Queue. You can do it easily by maintaining queue and an array for the count for character.
    if count greater than 1 it will never be non repeating character.
    And a char that is non repeating will remain util we get the char again.
 */