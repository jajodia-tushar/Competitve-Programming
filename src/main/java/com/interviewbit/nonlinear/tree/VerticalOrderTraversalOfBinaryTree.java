package com.interviewbit.nonlinear.tree;

import com.interviewbit.nonlinear.util.TreeNode;
import com.interviewbit.utils.ArrayUtils;

import java.util.*;

public class VerticalOrderTraversalOfBinaryTree {

    Map<Integer, ArrayList<Pair>> maps = null;

    public static void main(String[] args) {

        VerticalOrderTraversalOfBinaryTree obj = new VerticalOrderTraversalOfBinaryTree();
        TreeNode root = TreeNode.createTreeFromArray(460, 3871, 4698, 8399, 504, 4421, 7515, -1, 4167, 5727, -1, -1, 3096, 434, 7389, 2667, 5661, 1969, 7815, 4292, 3006, 9750, 6693, -1, 6906, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1);
        int[][] ints = obj.verticalOrderTraversal(root);
        ArrayUtils.printArray(ints);

    }


    public int[][] verticalOrderTraversal(TreeNode A) {

        maps = new TreeMap<>();
        Map<Integer, HashSet<Integer>> map = new TreeMap<>();
        traverse(A, 0, 0);
        int[][] result = new int[maps.size()][];
        int i = 0;
        System.out.println(maps);
        for (ArrayList<Pair> listOfPairs : maps.values()) {
            result[i] = new int[listOfPairs.size()];
            Collections.sort(listOfPairs);
            for (int j = 0; j < listOfPairs.size(); j++) {
                result[i][j] = listOfPairs.get(j).value;
            }
            i++;
        }

        return result;
    }


    public void traverse(TreeNode A, int diversion, int elevation) {


        if (A == null) return;
        traverse(A.left, diversion - 1, elevation + 1);

        Pair newPair = new Pair();
        newPair.value = A.val;
        newPair.elevation = elevation;

        if (maps.containsKey(diversion)) {
            maps.get(diversion).add(newPair);
        } else {
            ArrayList<Pair> list = new ArrayList<>();
            list.add(newPair);
            maps.put(diversion, list);
        }

        traverse(A.right, diversion + 1, elevation + 1);

    }

    public int[][] verticalOrderTraversalAnotherSolution(TreeNode A) {

        if( A == null) return new int[0][0];

        Map<Integer, ArrayList<Integer>> maps = new TreeMap<>();

        Queue<TreeNodeWithXCoOrdinate> queue = new LinkedList<>();
        TreeNodeWithXCoOrdinate specialNode = new TreeNodeWithXCoOrdinate(A,0);
        queue.add(specialNode);

        while(!queue.isEmpty()){

            TreeNodeWithXCoOrdinate currNodeWithX = queue.poll();
            TreeNode currentNode = currNodeWithX.node;
            int currentXValue = currNodeWithX.xValue;

            if(maps.containsKey(currentXValue)){
                maps.get(currentXValue).add(currentNode.val);
            }
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(currentNode.val);
                maps.put(currentXValue,list);
            }

            if( currentNode.left != null){
                TreeNodeWithXCoOrdinate leftNode = new TreeNodeWithXCoOrdinate(currentNode.left,currentXValue - 1);
                queue.add(leftNode);
            }

            if( currentNode.right != null){
                TreeNodeWithXCoOrdinate rightNode = new TreeNodeWithXCoOrdinate(currentNode.right,currentXValue +1);
                queue.add(rightNode);
            }
        }

        int[][] result = new int[maps.size()][];
        int i = 0;
        for(ArrayList<Integer> list : maps.values()){
            result[i++] = list.stream().mapToInt(a -> a).toArray();
        }
        return result;
    }


}

class Pair implements Comparable<Pair> {

    public int value;
    public int elevation;

    public Pair() {
    }

    public Pair(int value, int elevation) {
        this.value = value;
        this.elevation = elevation;
    }

    @Override
    public int compareTo(Pair next) {
        return Integer.compare(this.elevation, next.elevation);
    }
}


class TreeNodeWithXCoOrdinate{
    public TreeNode node;
    public int xValue;

    public TreeNodeWithXCoOrdinate(TreeNode node, int xValue) {
        this.node = node;
        this.xValue = xValue;
    }
}