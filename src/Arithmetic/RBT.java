package Arithmetic;

public class RBT {
    class Tree {
        int key;
        boolean color;
        Tree left,right,p;
    }
    Tree root;
    boolean RED = true;
    boolean BLACK = false;

    public void leftRotate(Tree root, Tree x) {
        Tree y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.p = x;
        }
        y.p = x.p;
        if (x.p == null) {
            root = y;
        } else if (x == x.p.left) {
            x.p.left = y;
        } else {
            x.p.right = y;
        }
        y.left = x;
        x.p = y;
    }

    public void rightRotate(Tree root, Tree x) {
        Tree y = x.left;
        x.left = y.right;
        if (y.right != null) {
            y.right.p = x;
        }
        y.p = x.p;
        if (x.p == null) {
            root = y;
        } else if (x == x.p.left) {
            x.p.left = y;
        } else {
            x.p.right = y;
        }
        y.right = x;
        x.p = y;
    }

    public void RB_Insert(Tree root, Tree z) {
        Tree y = null;
        Tree x = root;
        while (x != null) {
            y = x;
            if (z.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
            z.p = y;
            if (y == null) {
                root = z;
            } else if (z.key < y.key) {
                y.left = z;
            } else {
                y.right = z;
            }
            z.left = null;
            z.right = null;
            z.color = RED;
            RB_Insert_Fixup(root, z);
        }
    }
    public void RB_Insert_Fixup(Tree root, Tree z) {
        Tree y;
        while (z.p.color == RED) {
            if (z.p == z.p.p.left) {
                y = z.p.p.right;
                if (y.color == RED) {
                    z.p.color = BLACK;
                    y.color = BLACK;
                    z.p.p.color = RED;
                } else if (z == z.p.right) {
                    z = z.p;
                    leftRotate(root, z);
                }
                z.p.color = BLACK;
                z.p.p.color = RED;
                rightRotate(root, z.p.p);
            } else {
                // 同上述代码，交换左右节点
            }
        }
    }

    public void RB_Transplant(Tree root, Tree u, Tree v) {
        if (u.p == null) {
            root = v;
        } else if (u == u.p.left) {
            u.p.left = v;
        } else {
            u.p.right = v;
        }
        v.p = u.p;
    }
    public void RB_Delete(Tree root, Tree z) {
        Tree y = z,x;
        // y-original-color = y.color;
        if (z.left == null) {
            x = z.right;
            RB_Transplant(root, z, z.right);
        }else if (z.right == null) {
            x = z.left;
            RB_Transplant(root, z, z.left);
        }else{
            y = Tree_Minimum(z.right);
            // y-original-color = y.color;
            x = y.right;
            if (y.p == z) {
                x.p = y;
            } else {
                RB_Transplant(root, y, y.right);
                y.right = z.right;
                y.right.p = y;
            }
            RB_Transplant(root, z, y);
            y.left = z.left;
            y.left.p = y;
            y.color = z.color;
            // if (y-original-color == BLACK)  RB_Delete_Fixup(root, x);
        }
    }
    public Tree Tree_Minimum(Tree root) {
        Tree min = root;
        while (min.left != null) {
            min = min.left;
        }
        return min;
    }
}