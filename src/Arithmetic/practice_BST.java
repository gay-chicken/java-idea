package Arithmetic;

public class practice_BST {
    private class Node{
        private Node left,right;
        private int val;
    }
    private Node root;

    public Node search(int val){
        return search(root,val);
    }
    private Node search(Node node,int val){
        if(node == null) {
            return null;
        }
        if(node.val > val) {
            return search(node.left,val);
        } else if(node.val < val) {
            return search(node.right,val);
        } else {
            return node;
        }
    }

    public Node insert(int val){
        return insert(root,val);
    }
    private Node insert(Node node,int val){
        if(node.val > val){
            if(node.left == null){
                node.left.val=val;
                return node.left;
            }
            insert(node.left,val);
        }else if(node.val < val){
            if(node.right == null){
                node.right.val=val;
                return node.right;
            }
        }
        return node;
    }
}
