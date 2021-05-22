package com.interviewbit.nonlinear.graph;

public class PossibilityOfFinishingAllCoursesGivenPrerequisites {

    public static void main(String[] args) {
        PossibilityOfFinishingAllCoursesGivenPrerequisites obj = new PossibilityOfFinishingAllCoursesGivenPrerequisites();
        int A = 3;
        int[] B = {1, 2};
        int[] C = {2, 3};
        int result = obj.solve(A, B, C);
        System.out.println(result);

    }

    public int solve(int A, int[] B, int[] C) {
        return isCyclic(A, B, C) ? 0 : 1;
    }

    public boolean isCyclic(int A, int[] B, int[] C) {
        boolean[] visited = new boolean[A + 1];
        boolean[] recursiveArr = new boolean[A + 1];

        for (int i = 1; i <= A; i++) {
            if (!visited[i]) {
                boolean result = isCyclicUtil(i, visited, recursiveArr, B, C);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCyclicUtil(int nodeToVisit, boolean[] visited,
                                boolean[] recursiveArr, int[] B, int[] C) {

        if (recursiveArr[nodeToVisit]) return true;
        if (visited[nodeToVisit]) return false;

        visited[nodeToVisit] = true;
        recursiveArr[nodeToVisit] = true;

        for (int i = 0; i < B.length; i++) {
            if (B[i] == nodeToVisit) {
                boolean result = isCyclicUtil(C[i], visited, recursiveArr, B, C);
                if (result) return true;
            }
        }

        recursiveArr[nodeToVisit] = false;
        return false;
    }
}
