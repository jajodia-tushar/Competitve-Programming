package com.interviewbit.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacterInAStreamOfCharacters {

    public static void main(String[] args) {
        FirstNonRepeatingCharacterInAStreamOfCharacters obj = new FirstNonRepeatingCharacterInAStreamOfCharacters();
        System.out.println(obj.solve("jyhrcwuengcbnuchctluxjgtxqtfvrebveewgasluuwooupcyxwgl"));
    }

    public String solve(String A) {
        Queue<Character> queue = new LinkedList<>();
        int[] arr = new int[26];
        StringBuilder str = new StringBuilder();

        for(int i = 0; i < A.length(); i++) {
            queue.add(A.charAt(i));
            arr[A.charAt(i) - 97]++;

            while(!queue.isEmpty() && arr[queue.peek() - 97] != 1){
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