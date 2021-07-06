package com.interviewbit.stackandqueue;

import java.util.Stack;

/*
Given a string A representing an absolute path for a file (Unix-style).

Return the string A after simplifying the absolute path.

Note:

Absolute path always begin with ’/’ ( root directory ).

Path will not have whitespace characters.




Input Format

The only argument given is string A.
Output Format

Return a string denoting the simplified absolue path for a file (Unix-style).
For Example

Input 1:
    A = "/home/"
Output 1:
    "/home"

Input 2:
    A = "/a/./b/../../c/"
Output 2:
    "/c"
 */
public class SimplifyDirectoryPath {

    public static void main(String[] args) {
        SimplifyDirectoryPath obj = new SimplifyDirectoryPath();
        System.out.println(obj.simplifyPath("/home/"));
    }

    public String simplifyPath(String A) {
        Stack<String> stack = new Stack<>();
        String[] arr = A.split("/");
        int i = 0;
        int n = arr.length;

        while (i < n) {
            String str = arr[i];
            if (!str.equals("")) {
                if (str.equals("..")) {
                    if (!stack.isEmpty())
                        stack.pop();
                } else if (!str.equals(".")) {
                    stack.push(str);
                }
            }
            i++;
        }

        StringBuilder string = new StringBuilder();
        boolean isSlashRequired = false;
        while (!stack.isEmpty()) {

            if (isSlashRequired) {
                string.insert(0, stack.pop() + "/");
            } else {
                string.insert(0, stack.pop());
                isSlashRequired = true;
            }
        }

        return "/" + string;
    }
}

/*
    Perfect Use of Stack.
    Just Too Many edge cases
 */