package com.jary.daily.grows.algorithms.tree;

import java.util.ArrayDeque;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/10/19 下午6:26
 * 二叉树 深度优先和广度优先
 */
public class BinaryTree {

    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value){
            this.value = value;
        }
    }

    TreeNode root;

    public BinaryTree(int[] array){
        root = makinBinaryTreeByArray(array,1);
    }

    /**
     * 采用递归方式创建一颗二叉树
     * 传入的是二叉树的数组表示
     * 构造后是二叉树的二叉链表表示法
     * @param array
     * @param index
     * @return
     */
    public static TreeNode makinBinaryTreeByArray(int[] array,int index){
        if(index < array.length){
            int value = array[index];
            if(value!=0){
                TreeNode t = new TreeNode(value);
                array[index] = 0;
                t.left = makinBinaryTreeByArray(array,index*2);
                t.right = makinBinaryTreeByArray(array,index*2+1);
                return t;
            }
        }
        return null;
    }

    /**
     * 深度优先 相当于先根遍历
     * 非递归实现
     * 栈
     */
    public void depthOrderTraversal(){
        if(root==null){
            System.out.println("empty tree");
            return ;
        }

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.print(node.value+" ");
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        System.out.println();
    }

    public void levelOrderTraversal(){
        if(root==null){
            System.out.println("empty tree");
            return;
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            System.out.print(node.value+" ");
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] arr = {0,13,65,5,97,25,0,37,22,0,4,28,0,0,32,0};
        BinaryTree tree = new BinaryTree(arr);
        tree.depthOrderTraversal();
        tree.levelOrderTraversal();
    }
}
