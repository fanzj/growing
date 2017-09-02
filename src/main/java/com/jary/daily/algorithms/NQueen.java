package com.jary.daily.algorithms;

/**
 *
 * @author dell
 * @date 2017年4月27日 下午4:26:10
 * @title N皇后问题
 * @description
 */
public class NQueen {

    private static final int N = 4;//四皇后


    private static int isCorrtect(int i,int j,int[][] Q){
        int row,col;
        for(row=i,col=0;col<N;col++){//判断行
            if(Q[row][col]==1 && col!=j)
                return 0;
        }
        for(col=j,row=0;row<N;row++){//判断列
            if(Q[row][col]==1 && row!=i)
                return 0;
        }
        for(row=i-1,col=j-1;col>=0 && row>=0;col--,row--){//左上
            if(Q[row][col]==1)
                return 0;
        }
        for(row=i+1,col=j+1;col<N && row<N;col++,row++){//右下
            if(Q[row][col]==1)
                return 0;
        }
        for(row=i+1,col=j-1;col>=0 && row<N;col--,row++){//左下
            if(Q[row][col]==1)
                return 0;
        }
        for(row=i-1,col=j+1;col<N && row>=0;col++,row--){//右上
            if(Q[row][col]==1)
                return 0;
        }
        return 1;
    }

    private static int Queue(int j,int[][] Q,int count){
        if(j==N){//递归结束条件
            print(Q);//得到一个解，在屏幕上打印
            count++;
            return count;
        }
        for(int i=0;i<N;i++){
            if(isCorrtect(i, j, Q)==1){//如果Q[i][j]可以放置皇后
                Q[i][j] = 1;//放置皇后
                count = Queue(j+1, Q,count);//递归深度优先搜索解空间树
                Q[i][j] = 0;//实现回溯到上一层
            }
        }
        return count;
    }

    private static void print(int[][] Q){
        int len = Q.length;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                System.out.print(Q[i][j]);
                if(j<len-1)
                    System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] Q = new int[N][N];
        int i,j;
        for(i=0;i<N;i++){
            for(j=0;j<N;j++){
                Q[i][j] = 0;
            }
        }
        System.out.println("count = "+NQueen.Queue(0, Q,0));
    }
}
