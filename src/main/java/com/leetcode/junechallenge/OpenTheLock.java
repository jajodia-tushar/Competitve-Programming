package com.leetcode.junechallenge;

/*
You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

The lock initially starts at '0000', a string representing the state of the 4 wheels.

You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.

Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.



Example 1:

Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
Output: 6
Explanation:
A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
because the wheels of the lock become stuck after the display becomes the dead end "0102".
Example 2:

Input: deadends = ["8888"], target = "0009"
Output: 1
Explanation:
We can turn the last wheel in reverse to move from "0000" -> "0009".
Example 3:

Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
Output: -1
Explanation:
We can't reach the target without getting stuck.
Example 4:

Input: deadends = ["0000"], target = "8888"
Output: -1


Constraints:

1 <= deadends.length <= 500
deadends[i].length == 4
target.length == 4
target will not be in the list deadends.
target and deadends[i] consist of digits only.
 */

import javax.naming.OperationNotSupportedException;
import java.util.*;

public class OpenTheLock {

    public static void main(String[] args) {

        OpenTheLock obj = new OpenTheLock();
        String[] deadends = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        String target = "8888";
        int result = obj.openLock(deadends, target);
        System.out.println(result);
    }

    HashSet<String> deadEndSets;
    char[][] neighbour = {{'1', '9'}, {'2', '0'}, {'3', '1'}, {'4', '2'}, {'5', '3'}, {'6', '4'}, {'7', '5'}, {'8', '6'}, {'9', '7'}, {'8', '0'}};

    public int openLock(String[] deadends, String target) {

        deadEndSets = new HashSet<>();
        for (String str : deadends) {
            deadEndSets.add(str);
        }

        Queue<String> queue = new LinkedList<>();
        String startingString = "0000";
        if (deadEndSets.contains(startingString)) return -1;
        queue.add(startingString);

        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currNode = queue.poll();
                if (currNode.equals(target)) return count;
                List<String> neighbours = getNeighbours(currNode);
                if (!neighbours.isEmpty()) {
                    for (String item : neighbours) {
                        if (!deadEndSets.contains(item)) {
                            deadEndSets.add(item);
                            queue.add(item);
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }

    public List<String> getNeighbours(String str) {

        List<String> result = new ArrayList<>();

        int n = str.length();
        char[] charArray = str.toCharArray();

        for (int i = 0; i < n; i++) {
            char ch = charArray[i];
            char[] allNeighbour = neighbour[ch - '0'];
            String firstNeighbour = getNewString(charArray, i, allNeighbour[0]);
            String secondNeihbour = getNewString(charArray, i, allNeighbour[1]);
            result.add(firstNeighbour);
            result.add(secondNeihbour);
        }
        return result;
    }

    public String getNewString(char[] charArray, int i, char newChar) {
        char ch = charArray[i];
        charArray[i] = newChar;
        String newString = new String(charArray);
        charArray[i] = ch;
        return newString;
    }
}

/*
    Very Good Question from Graph.
    You have to actually perform BFS and start from 0000 to reach the
    node you want to reach.
    The condition that you are given i.e. only one character you can move
    So all these possible are the neighbours from current node.
    You can track the level and once you hit the result return the level.

    One thing to note in classical BFS we use visited Set and populate it when
    we pop from the queue but in this question we won't do that because
    if we encounter the node that is not visited multiple times than
    they will be added in the queue and overload the queue.
    mark a node as visited as soon as you add that in the queue.



 */
