package com.lovebabbar;


import java.sql.SQLOutput;

/*
    In a party of N people, only one person is known to everyone.
    Such a person may be present in the party, if yes, (s)he doesn’t
    know anyone in the party. We can only ask questions like “does A know B? “.
    Find the stranger (celebrity) in the minimum number of questions.
    We can describe the problem input as an array of numbers/characters
    representing persons in the party. We also have a hypothetical function
    HaveAcquaintance(A, B) which returns true if A knows B, false otherwise.
    How can we solve the problem.
 */
public class CelebrityProblem {

    public static void main(String[] args) {

        CelebrityProblem obj = new CelebrityProblem();
        int connection[][] = { { 0, 0, 1, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 1, 0 } };

        int n = 4;
        int result = obj.findCelebrity(n,connection);

        if( result != -1){
            int iKnow = 0;
            int theyKnow = 0;
            for(int i = 0; i < 4; i++){
                if(connection[result][i] == 1) iKnow++;
                if(connection[i][result] == 1) theyKnow++;
            }
            if( iKnow == 0 && theyKnow == n)
                System.out.println("The Celebrity is "+result);
            return;
        }
        System.out.println("There is No Celebrity");
    }

    int findCelebrity(int n, int[][] connections) {
        if (n == 0) return -1;

        int result = findCelebrity(n - 1, connections);

        // If No One is Celebrity, I can Be the Celebrity. (N - 1) Denotes Current Node.
        if (result == -1) return n - 1;
        // If Someone Claiming to be Celebrity knows me then there are not Celebrity but I can be Celebrity
        else if (connections[result][n - 1] == 1) return n - 1;
        // If Someone Claiming to be Celebrity doesn't know me and I know the person. The Person Can be
        // The Celebrity.
        else if (connections[n - 1][result] == 1) return result;
        // I don't think anyone is Celebrity.
        else return -1;
    }
}
