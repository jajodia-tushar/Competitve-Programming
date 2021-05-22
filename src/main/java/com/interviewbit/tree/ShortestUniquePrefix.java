package com.interviewbit.tree;

import com.interviewbit.utils.ArrayUtils;

public class ShortestUniquePrefix {

    public static void main(String[] args) {

        ShortestUniquePrefix obj = new ShortestUniquePrefix();
        String[] keys = {"zebra", "dog", "duck", "dove"};

        String[] result = obj.prefix(keys);
        ArrayUtils.printArray(result);
    }

    public String[] prefix(String[] A) {

        TierNode root = new TierNode();
        String[] result = new String[A.length];

        for(String key : A){
            root.insert(key);
        }

        for(int i = 0; i < result.length; i++){
            result[i] = root.getMinimum(A[i]);
        }

        return result;
    }
}

class TierNode {
    public TierNode[] children;
    public boolean isEndOfWord;
    public int accessedValue;

    public TierNode() {
        this.children = new TierNode[26];
        this.isEndOfWord = false;
        this.accessedValue = 0;
    }

    public void insert(String key){

        TierNode traversingNode = this;

        for(int i = 0; i < key.length(); i++){
            int index = key.charAt(i) - 'a';

            if (traversingNode.children[index] == null){
                traversingNode.children[index] = new TierNode();
            }
            traversingNode = traversingNode.children[index];
            traversingNode.accessedValue++;
        }

        traversingNode.isEndOfWord = true;
    }

    public String getMinimum(String key){

        TierNode traversingNode = this;
        StringBuilder str = new StringBuilder();

        for(int i = 0; i < key.length(); i++){

            int index = key.charAt(i) - 'a';
            if(traversingNode.accessedValue == 1){
                return str.toString();
            }
            str.append(key.charAt(i));
            traversingNode = traversingNode.children[index];
        }
        return str.toString();
    }

}

