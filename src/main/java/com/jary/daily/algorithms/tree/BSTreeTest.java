package com.jary.daily.algorithms.tree;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/15 下午7:18
 */
public class BSTreeTest {

    private static final int arr[] = {1, 5, 4, 3, 2, 6};

    public static void main(String[] args){
        BSTree<Integer> tree = new BSTree<>();

        System.out.print("== 依次添加：");
        int len = arr.length;
        for(int i=0;i<len;i++){
            System.out.print(arr[i]+" ");
            tree.insert(arr[i]);
        }

        System.out.print("\n== 前序遍历：");
        tree.preOrder();

        System.out.print("\n== 中序遍历：");
        tree.inOrder();

        System.out.print("\n== 后序遍历：");
        tree.postOrder();
        System.out.println();

        System.out.println("== 最小值："+tree.minmum());
        System.out.println("== 最大值："+tree.maximum());
        System.out.println("== 树的详细信息：");
        tree.print();

        System.out.println("\n== 删除节点："+arr[3]);
        tree.remove(arr[3]);

        System.out.print("== 中序遍历：");
        tree.inOrder();
        System.out.println();

        //销毁二叉树
        tree.clear();
    }
}
