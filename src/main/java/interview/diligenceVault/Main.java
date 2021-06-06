package interview.diligenceVault;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Main obj = new Main();
        String[] A = {"door", "bag", "toy", "boys"};
        char[] B = {'b', 'o', 'y', 'd', 'r'};

        ArrayList<String> result = obj.findTheWordsThatCanBeFormed(A, B);
        System.out.println(result);

    }

    public ArrayList<String> findTheWordsThatCanBeFormed(String[] A, char[] B) {

        ArrayList<String> result = new ArrayList<>();
        HashSet<Character> sets = new HashSet<>();

        for (char ch : B) {
            sets.add(ch);
        }

        for (String strToCheck : A) {
            int n = strToCheck.length();
            int i = 0;
            for (; i < n; i++) {
                char ch = strToCheck.charAt(i);
                if (!sets.contains(ch))
                    break;
            }
            if (i == n) {
                result.add(strToCheck);
            }
        }
        return result;
    }


}
