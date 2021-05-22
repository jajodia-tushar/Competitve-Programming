package com.interviewbit.tree;

import com.interviewbit.utils.TreeLinkNode;

public class PopulateNextRightPointersTree {

    public static void main(String[] args) {

//        TreeLinkNode root = TreeLinkNode.createTreeFromArray(838142, 79327, 850082, 78362, 664467, -1, 973809, 56042, 79117, 326663, 773985, 899271, 976568, 40359, 69725, -1, -1, 134531, 603123, 760369, 826902, 862205, 959993, -1, -1, 32358, 50782, 66899, 73260, 114761, 298159, 545464, 604554, 678183, 762219, 780090, 831066, -1, 868662, 951588, -1, 9679, 33090, -1, 51208, -1, -1, -1, -1, 103548, -1, 255457, 311604, 357548, 548587, 603382, 633869, 671177, 689824, -1, 773186, 776851, 792094, -1, -1, -1, -1, -1, -1, 9608, 28853, -1, -1, -1, -1, 87854, -1, 196521, 274844, -1, -1, 344728, 462110, -1, 599430, -1, -1, 619311, 646060, 667529, -1, 681109, 747257, -1, -1, -1, -1, 784081, -1, -1, -1, 16653, -1, -1, 100198, 187605, 209762, -1, -1, -1, -1, 379623, 477976, 585788, 602218, 616193, -1, -1, -1, -1, -1, -1, 684882, -1, -1, -1, -1, 15442, 26527, -1, -1, 180722, -1, -1, -1, 377684, 398392, 468700, 507966, -1, -1, -1, -1, 610117, -1, -1, -1, -1, -1, 23983, -1, 161326, -1, -1, -1, -1, 415961, -1, -1, 491819, 509566, -1, -1, -1, -1, -1, 168956, 411487, -1, -1, 492019, -1, -1, -1, 171862, -1, 412294, -1, 498100, -1, 177068, -1, -1, -1, -1, 172344, -1, -1, -1);

        PopulateNextRightPointersTree obj = new PopulateNextRightPointersTree();
        TreeLinkNode root = TreeLinkNode.createTreeFromArray(838142, 79327, 850082, 78362, 664467, -1, 973809, 56042, 79117, 326663, 773985, 899271, 976568, 40359, 69725, -1, -1, 134531, 603123, 760369, 826902, 862205, 959993, -1, -1, 32358, 50782, 66899, 73260, 114761, 298159, 545464, 604554, 678183, 762219, 780090, 831066, -1, 868662, 951588, -1, 9679, 33090, -1, 51208, -1, -1, -1, -1, 103548, -1, 255457, 311604, 357548, 548587, 603382, 633869, 671177, 689824, -1, 773186, 776851, 792094, -1, -1, -1, -1, -1, -1, 9608, 28853, -1, -1, -1, -1, 87854, -1, 196521, 274844, -1, -1, 344728, 462110, -1, 599430, -1, -1, 619311, 646060, 667529, -1, 681109, 747257, -1, -1, -1, -1, 784081, -1, -1, -1, 16653, -1, -1, 100198, 187605, 209762, -1, -1, -1, -1, 379623, 477976, 585788, 602218, 616193, -1, -1, -1, -1, -1, -1, 684882, -1, -1, -1, -1, 15442, 26527, -1, -1, 180722, -1, -1, -1, 377684, 398392, 468700, 507966, -1, -1, -1, -1, 610117, -1, -1, -1, -1, -1, 23983, -1, 161326, -1, -1, -1, -1, 415961, -1, -1, 491819, 509566, -1, -1, -1, -1, -1, 168956, 411487, -1, -1, 492019, -1, -1, -1, 171862, -1, 412294, -1, 498100, -1, 177068, -1, -1, -1, -1, 172344, -1, -1, -1);
//        TreeNode.printBinaryTree(root,0);
        obj.connect(root);

    }

//    public void connect(TreeLinkNode root) {
//
//        TreeLinkNode leftNode = root;
//        while( root != null && root.left != null){
//            updateNextPointer(leftNode);
//            leftNode = leftNode.left;
//        }
//    }

    public void updateNextPointer(TreeLinkNode node){
        TreeLinkNode previous = null;
        TreeLinkNode current = null;
        TreeLinkNode next = null;

        while(node != null){
            current = node.left;
            next = node.right;
            if( previous != null)
                previous.next = current;

            current.next = next;
            previous = next;
            node = node.next;
        }
    }

    public void connect(TreeLinkNode root) {

        TreeLinkNode parent = root;
        TreeLinkNode nextNode = root;

        while(nextNode != null){

            parent = nextNode;
            boolean set = false;

            while(parent != null){

                if( parent.left != null){

                    if(!set){
                        nextNode = parent.left;
                        set = true;
                    }

                    if(parent.right != null){
                        parent.left.next = parent.right;
                    }
                    else{
                        TreeLinkNode possibleNextNode = parent.next;
                        while( possibleNextNode != null){

                            if( possibleNextNode.left != null){
                                parent.left.next = possibleNextNode.left;
                                break;
                            }

                            if(possibleNextNode.right != null){
                                parent.left.next = possibleNextNode.right;
                                break;
                            }

                            possibleNextNode = possibleNextNode.next;
                        }
                    }
                }

                if( parent.right != null){
                    if(!set){
                        nextNode = parent.right;
                        set = true;
                    }
                    TreeLinkNode possibleNextNode = parent.next;

                    while( possibleNextNode != null){

                        if(possibleNextNode.left != null){
                            parent.right.next = possibleNextNode.left;
                            break;
                        }

                        if(possibleNextNode.right != null){
                            parent.right.next = possibleNextNode.right;
                            break;
                        }

                        possibleNextNode = possibleNextNode.next;
                    }
                }
                parent = parent.next;
            }

            if(!set){
                break;
            }
        }




    }
}
