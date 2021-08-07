package com.leetcode.julychallenge;

/*
    Given a positive integer n, return the number of the integers in the range [0, n] whose binary representations do not contain consecutive ones.

    Example 1:

    Input: n = 5
    Output: 5
    Explanation:
    Here are the non-negative integers <= 5 with their corresponding binary representations:
    0 : 0
    1 : 1
    2 : 10
    3 : 11
    4 : 100
    5 : 101
    Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule.
    Example 2:

    Input: n = 1
    Output: 2
    Example 3:

    Input: n = 2
    Output: 3


    Constraints:

    1 <= n <= 109
 */
public class NonNegativeIntegersWithoutConsecutiveOnes {

    public static void main(String[] args) {

        NonNegativeIntegersWithoutConsecutiveOnes obj = new NonNegativeIntegersWithoutConsecutiveOnes();
        int result = obj.findIntegers(22);
        System.out.println(result);

    }

    public int findIntegers(int num) {
        int[] f = new int[32];
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i < f.length; i++)
            f[i] = f[i - 1] + f[i - 2];
        int i = 30, sum = 0, prev_bit = 0;
        while (i >= 0) {
            if ((num & (1 << i)) != 0) {
                sum += f[i];
                if (prev_bit == 1) {
                    sum--;
                    break;
                }
                prev_bit = 1;
            } else
                prev_bit = 0;
            i--;
        }
        return sum + 1;
    }
}
/*
    No One Can Explain this better than the Leetcode Solution Section.
    https://leetcode.com/problems/non-negative-integers-without-consecutive-ones/solution/


    Try to think in terms of Dynamic Problem.
    It is Fibonacci types

    See if you have a 0 at current position then you can add 1 and 0 both number in  front of the this current number
    But if you have a 1 at current position then you can add 0 only as adding 1 will result in

    So for current i Position
        f[i] = f[i - 1] + f[i - 2]

    why i - 2. is see if you pick up the i - 2 character and place a 10 in it you can be sure that the number is not going to have
    consecutive 1s.

    Now so far so good.
    These are for bit right.
    For ith bit.
    How many number you can generate without consecutive 1's with 4 bit number.

    But you need to tweak this little bit, If you want to get for a particular Number like 18.

    18th Representation is 10010
    Now you can get for 5 bit and 2 bit and add to get the answer for 18.

    But if the number is like 28.

    It will be like
    11100

    but see for this one you can't do f[5] + f[4] + f[3]

    because doing f[5] + f[4] will represent 11000 and there is consecutive 1 and all the number that
    you form by adding anything after will not be ok so f[3] will not be allowed.
    Moreover you will have to subtract 1 from f[5] + f[4] as well.( -1 accommodated with 0000)


 */
