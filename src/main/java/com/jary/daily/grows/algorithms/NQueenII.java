package com.jary.daily.grows.algorithms;

/**
 *
 * @author dell
 * @date 2017年4月27日 下午7:17:08
 * @title N皇后问题
 * @description 回溯法
 */
public class NQueenII {
    public static int num = 0;//累计方案总数
    public static final int MAXQUEEN = 4;//皇后个数，同时也是棋盘行列总数
    public static int[] cols = new int[MAXQUEEN];//定义cols数组，表示8列棋子摆放情况，rols[i]=j表示第i列存放行j

    public NQueenII(){
        getArrangement(0);
        System.out.println(MAXQUEEN+"皇后问题有"+num+"种摆放方法");
    }

    /**
     * n当前列
     * @param n
     */
    public void getArrangement(int n){
        //遍历该列所有不合法的行，并用row数组记录，不合法即rows[i]=true
        boolean[] rows = new boolean[MAXQUEEN];//rows[i]表示第i行是否可以摆放
        for(int i=0;i<n;i++){
            rows[cols[i]]=true;//当前列n的棋子不能放在前面列i的棋子所在行。
            int d = n-i;
            if(cols[i]-d>=0)//该句用于设置当前列n的棋子不能放在前面列i的棋子的斜线上
                rows[cols[i]-d]=true;
            if(cols[i]+d<=MAXQUEEN-1)// 该句用于设置当前列n的棋子不能放在前面列i的棋子的反斜线上
                rows[cols[i]+d] = true;
        }
        for(int i=0;i<MAXQUEEN;i++){
            //判断该行是否合法
            if(rows[i])
                continue;
            //设置当前列合法棋子所在行数
            cols[n] = i;
            //当前列不为最后一列时
            if(n<MAXQUEEN-1){
                getArrangement(n+1);
            }else {
                //累积方案个数
                num++;
                //打印棋盘信息
                printChessBoard();
            }
        }
    }

    public void printChessBoard(){
        System.out.println("第"+num+"种走法");
        for(int i=0;i<MAXQUEEN;i++){//行
            for(int j=0;j<MAXQUEEN;j++){
                if(i==cols[j])
                    System.out.print("0 ");
                else
                    System.out.print("+ ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        NQueenII queen = new NQueenII();

    }
}

