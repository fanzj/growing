package com.jary.daily.grows.test;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/20 下午8:11
 */
public class YJ {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    class TreeToSequence {
        public String toSequence(TreeNode root) {
            String s = "";
            if(root!=null){
                s += "("+root.val;
                s += toSequence(root.left);
                s += toSequence(root.right)+")";
            }
            return s;
        }
    }

    public String toSequence(TreeNode root) {
        String s = "";
        if (root!=null){
            s += root.val;
            if (root.left!=null || root.right!=null){
                s+="(";
                s+=toSequence(root.left);
                if (root.right!=null){
                    s+=",";
                }
                s += toSequence(root.right);
                s += ")";
            }
        }
        return s;
    }

    public TreeNode insert(int x,TreeNode t){
        if(t==null)
            t = new TreeNode(x);
        else if(x<=t.val){
            t.left = insert(x, t.left);
        }else{
            t.right = insert(x, t.right);
        }
        return t;
    }

    public void print(TreeNode node){
        if(node!=null){
            print(node.left);
            System.out.println(node.val);

            print(node.right);
        }
    }

    public static void main(String[] args){
        YJ obj = new YJ();
        int[] A = {3,1,5,4,6};
        TreeNode node = null;
        for(int i=0;i<A.length;i++){
            node = obj.insert(A[i],node);
        }
        System.out.println(obj.toSequence(node));
        obj.print(node);
    }


}
