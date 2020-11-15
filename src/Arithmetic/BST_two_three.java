package Arithmetic;
/*
2-3查找树定义：
    一颗2-3查找树，要么是空树，要么是由以下节点组成：
        2-节点：含有一个键和两条链接，左连接小于键的值，右链接大于键的值
        3-节点：含有两个键和三条链接，左连接小于这两个键的值，右链接大于这两个链接的值，中链接介于这两个键的值之间。
 */
public class BST_two_three {
    class Node{
        int val;
        Node left,right,middle;
    }
    Node root;
    public Node Find(int val){
        return Find(root,val);
    }
    private Node Find(Node node,int val){
        if(node == null) {
            return null;
        }
        if(node.val > val) {
            return Find(node.left,val);
        } else if(node.val < val) {
            return Find(node.right,val);
        } else if(node.val != val) {
            return Find(node.middle,val);
        } else {
            return node;
        }
    }

    public Node Insert(int val){
        return Insert(root,val);
    }
    private Node Insert(Node node,int val){
        Node tree=Find(val);
        if(Find(val) != null) {
            return tree;
        }
        //tree == null

        tree = node;
        while(tree != null){
            if(tree.val > val) {
                tree = tree.left;
            } else if(tree.val < val) {
                tree = tree.right;
            } else {
                return tree;
            }
        }
        return tree;
    }
}
