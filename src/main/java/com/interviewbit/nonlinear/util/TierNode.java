package com.interviewbit.nonlinear.util;

public class TierNode {
    public TierNode[] children;
    public boolean isEndOfWord;

    public TierNode() {
        this.children = new TierNode[26];
        this.isEndOfWord = false;
    }

    public void insert(String key){

        TierNode traversingNode = this;

        for(int i = 0; i < key.length(); i++){
            int index = key.charAt(i) - 'a';

            if (traversingNode.children[index] == null){
                traversingNode.children[index] = new TierNode();
            }
            traversingNode = traversingNode.children[index];
        }

        traversingNode.isEndOfWord = true;
    }

    public boolean search(String key){

        TierNode traversingNode = this;
        for(int i = 0; i < key.length(); i++){
            int index = key.charAt(i) - 'a';
            if (traversingNode.children[index] == null)
                return false;
            traversingNode = traversingNode.children[index];
        }

        return traversingNode != null && traversingNode.isEndOfWord;
    }

}
