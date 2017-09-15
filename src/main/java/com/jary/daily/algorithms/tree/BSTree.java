package com.jary.daily.algorithms.tree;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/15 上午10:55
 * 二叉查找树
 */
public class BSTree<T extends Comparable<T>> {

    private BSTNode<T> mRoot;//根节点


    /**
     * 节点定义
     *
     * @param <T>
     */
    class BSTNode<T extends Comparable<T>> {
        T key; //键值
        BSTNode<T> left;  //左孩子
        BSTNode<T> right; //右孩子
        BSTNode<T> parent;//父节点

        public BSTNode(T key, BSTNode<T> parent, BSTNode<T> left, BSTNode<T> right) {
            this.key = key;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public T getKey() {
            return key;
        }

        @Override
        public String toString() {
            return "key : "+key;
        }
    }

    public BSTree(){
        mRoot = null;
    }

    /**
     * 前序遍历 根->左->右
     *
     * @param tree
     */
    private void preOrder(BSTNode<T> tree) {
        if (tree != null) {
            System.out.print(tree.key + " ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void preOrder() {
        preOrder(mRoot);
    }

    /**
     * 中序遍历 左->根->右
     *
     * @param tree
     */
    private void inOrder(BSTNode<T> tree) {
        if (tree != null) {
            inOrder(tree.left);
            System.out.print(tree.key + " ");
            inOrder(tree.right);
        }
    }

    public void inOrder() {
        inOrder(mRoot);
    }

    /**
     * 后序遍历 左->右->根
     *
     * @param tree
     */
    private void postOrder(BSTNode<T> tree) {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(tree.key + " ");
        }
    }

    public void postOrder() {
        postOrder(mRoot);
    }

    /**
     * 递归实现查找 二叉树x中键值为key的节点
     *
     * @param x
     * @param key
     * @return
     */
    private BSTNode<T> search(BSTNode<T> x, T key) {
        if (x == null)
            return x;

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return search(x.left, key);
        else if (cmp > 0)
            return search(x.right, key);
        else
            return x;
    }

    public BSTNode<T> search(T key) {
        return search(mRoot, key);
    }

    /**
     * 非递归实现 查找二叉树x中键值为key的节点
     *
     * @param x
     * @param key
     * @return
     */
    private BSTNode<T> iterativeSearch(BSTNode<T> x, T key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0)
                x = x.left;
            else if (cmp > 0)
                x = x.right;
            else
                return x;
        }
        return x;
    }

    public BSTNode<T> iterativeSearch(T key) {
        return search(mRoot, key);
    }

    /**
     * 查找最大节点：返回tree为根节点的二叉树的最大节点
     *
     * @param tree
     * @return
     */
    private BSTNode<T> maximum(BSTNode<T> tree) {
        if (tree == null)
            return null;

        while (tree.right != null) {
            tree = tree.right;
        }
        return tree;
    }

    public T maximum() {
        BSTNode<T> p = maximum(mRoot);
        if (p != null)
            return p.key;

        return null;
    }

    /**
     * 查找最小节点：返回tree为根节点的二叉树的最小节点
     *
     * @param tree
     * @return
     */
    private BSTNode<T> minimum(BSTNode<T> tree) {
        if (tree == null)
            return null;
        while (tree.left != null) {
            tree = tree.left;
        }
        return tree;
    }

    public T minmum() {
        BSTNode<T> p = minimum(mRoot);
        if (p != null)
            return p.key;
        return null;
    }

    /**
     * 查找节点x的前驱节点，即 查找二叉树中数据值小于该节点的最大节点
     *
     * @param x
     * @return
     */
    public BSTNode<T> predecessor(BSTNode<T> x) {
        if (x.left != null)//如果左孩子存在，则x的前驱节点为以其左孩子为根的子树的最大节点
            return maximum(x.left);

        //如果x没有左孩子，则x有以下两种可能：
        //1.x是一个右孩子，则x的前驱节点为其父节点
        //2.x是一个左孩子，则查找x的最低父节点，并且该父节点要具有右孩子，找到的这个最低的父节点就是x的前驱
        BSTNode<T> y = x.parent;
        while (y != null && x == y.left) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    /**
     * 查找节点x的后继节点，即 查找二叉树中数据值大于该节点的最小节点
     *
     * @param x
     * @return
     */
    public BSTNode<T> successor(BSTNode<T> x) {
        if (x.right != null)//如果右孩子存在，则x的后继节点为以其右孩子为根的子树的最小节点
            return minimum(x.right);

        //如果没有右孩子，则x有以下两种可能：
        //1.x是一个左孩子，则x的后继节点为其父节点
        //2.x是一个右孩子，则查找x的最低父节点，并且该父节点要有左孩子，找到的这个最低的父节点就是x的后继
        BSTNode<T> y = x.parent;
        while (y != null && x == y.right) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    /**
     * 将节点插入到二叉树
     *
     * @param bst 二叉树
     * @param z   待插入节点
     */
    private void insert(BSTree<T> bst, BSTNode<T> z) {
        int cmp;
        BSTNode<T> y = null;
        BSTNode<T> x = bst.mRoot;

        //找到z的插入位置
        while (x != null) {
            y = x;
            cmp = z.key.compareTo(x.key);
            if (cmp < 0)
                x = x.left;
            else
                x = x.right;
        }
        z.parent = y;
        if (y == null)
            bst.mRoot = z;
        else {
            cmp = z.key.compareTo(y.key);
            if (cmp < 0)
                y.left = z;
            else
                y.right = z;
        }
    }

    /**
     * 新建节点key,并将其插入到二叉树
     *
     * @param key
     */
    public void insert(T key) {
        BSTNode<T> z = new BSTNode<>(key, null, null, null);

        if (z != null)
            insert(this, z);
    }

    /**
     * 删除节点z,并返回被删除的节点
     *
     * @param bst 二叉树
     * @param z   删除的节点
     * @return
     */
    private BSTNode<T> remove(BSTree<T> bst, BSTNode<T> z) {
        BSTNode<T> x = null;
        BSTNode<T> y = null;

        if (z.left == null || z.right == null)
            y = z;
        else
            y = successor(z);

        if (y.left != null)
            x = y.left;
        else
            x = y.right;

        if (x != null)
            x.parent = y.parent;

        if (y.parent == null)
            bst.mRoot = x;
        else if (y == y.parent.left)
            y.parent.left = x;
        else
            y.parent.right = x;

        if (y != z)
            z.key = y.key;

        return y;
    }

    public void remove(T key) {
        BSTNode<T> z, node;
        if ((z = search(mRoot, key)) != null) {
            if ((node = remove(this, z)) != null)
                node = null;
        }
    }

    /**
     * 打印
     *
     * @param tree
     * @param key       节点的键值
     * @param direction 0 ：该节点是根节点；-1：该节点是它的父节点的左孩子；1：该节点是它的父节点的右孩子
     */
    private void print(BSTNode<T> tree, T key, int direction) {
        if (tree != null) {
            if (direction == 0) {//tree是根节点
                System.out.println(tree.key + " is root");
            } else {
                System.out.println(tree.key + " is " + key + "'s " + (direction == 1 ? "right" : "left") + " child ");
            }
            print(tree.left, tree.key, -1);
            print(tree.right, tree.key, 1);
        }
    }

    public void print() {
        if (mRoot != null)
            print(mRoot, mRoot.key, 0);
    }

    /**
     * 销毁二叉树
     *
     * @param tree
     */
    private void destory(BSTNode<T> tree) {
        if (tree == null)
            return;

        if (tree.left != null)
            destory(tree.left);
        if (tree.right != null)
            destory(tree.right);
    }

    public void clear(){
        destory(mRoot);
        mRoot = null;
    }
}
