package com.interviewbit.stackandqueue;

import java.util.Stack;

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
                } else if (!str.equals(".")){
                    stack.push(str);
                }
            }
            i++;
        }

        StringBuilder string = new StringBuilder();
        boolean isSlashRequired = false;
        while(!stack.isEmpty()){

            if(isSlashRequired){
                string.insert(0, stack.pop() + "/");
            }
            else{
                string.insert(0, stack.pop());
                isSlashRequired = true;
            }
        }

        return "/" + string;
    }
}
