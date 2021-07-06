package com.interviewbit.stackandqueue;

import java.util.Stack;

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) – Push element x onto stack.
pop() – Removes the element on top of the stack.
top() – Get the top element.
getMin() – Retrieve the minimum element in the stack.
Note that all the operations have to be constant time operations.

Questions to ask the interviewer :

Q: What should getMin() do on empty stack?
A: In this case, return -1.

Q: What should pop do on empty stack?
A: In this case, nothing.

Q: What should top() do on empty stack?
A: In this case, return -1
NOTE : If you are using your own declared global variables, make sure to clear them out in the constructor.
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(10);
        obj.push(5);
        obj.push(100);
        obj.push(123);
        obj.push(1123);
        System.out.println(obj.getMin());
        obj.pop();
        obj.pop();
        System.out.println(obj.getMin());
    }

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || stack2.peek() >= x) {
            stack2.push(x);
        }
    }

    public void pop() {

        if (!stack1.isEmpty()) {
            int x = stack1.pop();
            if (x == stack2.peek())
                stack2.pop();
        }
    }

    public int top() {
        return stack1.isEmpty() ? -1 : stack1.peek();
    }

    public int getMin() {
        return stack2.isEmpty() ? -1 : stack2.peek();
    }
}

/*
    Two Stack technique works.
    Because see if we already have a min number in the next stack and we are given to push a number
    greater than than current number our min will not change regardless of it is added or Popped.

    Only if we want to add the smaller number our min is going to change.
 */