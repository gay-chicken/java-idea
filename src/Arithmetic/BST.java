package Arithmetic;

import java.util.Queue;

public class BST<Key extends Comparable<Key>,Value> {
    private Node root;
    private class Node{
        private Key key;
        private Value val;
        private Node left,right;
        private int N;

        public Node(Key key,Value val,int N){
            this.key=key;
            this.val=val;
            this.N=N;
        }
    }

    public int size(){
        return size(root);
    }
    private int size(Node root){
        if(root == null) {
            return 0;
        } else {
            return root.N;
        }
    }

    public Value get(Key key){
        return get(root,key);
    }
    private Value get(Node root,Key key){
        if(root == null) {
            return null;
        }
        int cmp=key.compareTo(root.key);
        if(cmp<0) {
            return get(root.left,key);
        } else if(cmp>0) {
            return get(root.right,key);
        } else {
            return root.val;
        }
    }

    public void put(Key key,Value val){
        root=put(root,key,val);
    }
    private Node put(Node node,Key key,Value val){
        if(node == null) {
            return new Node(key,val,1);
        }
        int cmp=key.compareTo(node.key);
        if(cmp<0) {
            node.left=put(node.left,key,val);
        } else if(cmp>0) {
            node.right=put(node.right,key,val);
        } else {
            node.val=val;
        }
        node.N=size(node.left)+size(node.right)+1;
        return node;
    }

    public Key min(){
        return min(root).key;
    }
    private Node min(Node node){
        if(node.left == null) {
            return node;
        }
        return min(node.left);
    }

    public Key floor(Key key){
        Node node=floor(root,key);
        if(node == null) {
            return null;
        }
        return node.key;
    }
    private Node floor(Node node,Key key){
        if(node == null) {
            return null;
        }
        int cmp=key.compareTo(node.key);
        if(cmp == 0) {
            return node;
        }
        if(cmp<0) {
            return floor(node.left,key);
        }
        Node tree=floor(node.right,key);
        if(tree != null) {
            return tree;
        } else {
            return node;
        }
    }

    public Key max(){
        return max(root).key;
    }
    private Node max(Node node){
        if(node.right == null) {
            return node;
        }
        return max(node.right);
    }
/*
    public Key ceiling(){}
    private Node ceiling(){}
     */

    public Key select(int k){
        return select(root,k).key;
    }
    private Node select(Node node,int k){
        if(node == null) {
            return null;
        }
        int t=size(node.left);
        if(t>k) {
            return select(node.left,k);
        } else if(t<k) {
            return select(node.right,k);
        } else {
            return node;
        }
    }

    public int rank(Key key){
        return rank(root,key);
    }
    private int rank(Node node,Key key){
        if(node == null) {
            return 0;
        }
        int cmp=key.compareTo(node.key);
        if(cmp<0) {
            return rank(node.left,key);
        } else if(cmp>0) {
            return size(node.left)+rank(node.right,key)+1;
        } else {
            return size(node.left);
        }
    }

    public void deleteMin(){
        root=deleteMin(root);
    }
    private Node deleteMin(Node node){
        if(node.left == null) {
            return node.right;
        }
        node.left=deleteMin(node.left);
        node.N=size(node.left)+size(node.right)+1;
        return node;
    }

    public void delete(Key key){
        root=delete(root,key);
    }
    private Node delete(Node node,Key key){
        if(node == null) {
            return null;
        }
        int cmp=key.compareTo(node.key);
        if(cmp<0) {
            node.left=delete(node.left,key);
        } else if(cmp>0) {
            node.right=delete(node.right,key);
        } else{
            if(node.right == null) {
                return node.left;
            }
            if(node.left == null) {
                return node.right;
            }
            Node tree=node;
            node=min(tree.right);
            node.right=deleteMin(tree.right);
            node.left=tree.left;
        }
        node.N=size(node.left)+size(node.right)+1;
        return node;
    }
    /*
    public void deleteMax(){}
    private Node deleteMax(){}
     */
    /*
    public Iterable<Key> keys(){
        return keys(min(),max());
    }
    private Iterable<Key> keys(Key lo,Key hi){
        Queue<Key> queue=new Queue<Key>();
        keys(root,queue,lo,hi);
        return queue;
    }
    private void keys(Node node,Queue<Key> queue,Key lo,Key hi){
        if(node == null)
            return;
        int cmplo=lo.compareTo(node.key);
        int cmphi=hi.compareTo(node.key);
        if(cmplo < 0)
            keys(node.left,queue,lo,hi);
        if(cmplo <= 0 && cmphi >= 0)
            queue.enqueue(node.key);
        if(cmphi > 0)
            keys(node.right,queue,lo,hi);
    }

     */
}
