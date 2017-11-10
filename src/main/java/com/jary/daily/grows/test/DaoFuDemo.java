package com.jary.daily.grows.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/11/10 上午8:57
 */
public class DaoFuDemo {

    public static final int MAX_ID = 1002;

    static class Employee {

        List<Integer> in;//进入时间列表
        List<Integer> out;//离开时间列表
        List<Integer> diff;//滞留时间
        int total_stay;//该员工的最大滞留时间

        public Employee() {
            in = new ArrayList<>();
            out = new ArrayList<>();
            diff = new ArrayList<>();
            total_stay = 0;
        }

        @Override
        public String toString() {
            return "Employee{" +
                "in=" + in +
                ", out=" + out +
                ", diff=" + diff +
                ", total_stay=" + total_stay +
                '}';
        }
    }

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        Employee[] employees = new Employee[MAX_ID];//每个索引表示员工编号
        for (int i = 1; i < MAX_ID; i++) {
            employees[i] = new Employee();
        }
        int N;//N条记录

        N = Integer.valueOf(in.nextLine());
        for (int i = 1; i <= N; i++) {
            String line = in.nextLine();//输入的每行数据
            String[] lines = line.split(" ");
            Integer id = Integer.valueOf(lines[0]);//每条记录的编号
            String tag = lines[1];//进入或离开
            String[] str_time = lines[2].split(":");
            int[] time = new int[2];
            time[0] = Integer.valueOf(str_time[0]);//时
            time[1] = Integer.valueOf(str_time[1]);//分
            int total_min = time[0] * 60 + time[1];

            //作为结构输入
            if ("E".equals(tag)) {//进入
                employees[id].in.add(total_min);
            } else if ("L".equals(tag)) {//离开
                employees[id].out.add(total_min);
            }
        }


        int total_num = 0;//有效记录数
        int total_time = 0;//总时间数
        int max_time = Integer.MIN_VALUE;//最大时间
        for (int i = 1; i < MAX_ID; i++) {
            //筛选有效记录

            int size_in = employees[i].in.size();//员工i进入的时间列表长度
            int size_out = employees[i].out.size();//员工i离开时时间列表长度
            if (size_in != 0 && size_out != 0) {//有效记录
                int min_size = Math.min(size_in, size_out);

                //记录有效，计算每次进入离开的滞留时间
                int total_stay = 0;
                for (int j = 0; j < min_size; j++) {
                    employees[i].diff.add(employees[i].out.get(j) - employees[i].in.get(j));

                    //该员工的总滞留时间
                    total_stay += employees[i].out.get(j) - employees[i].in.get(j);

                    //总时间增加
                    total_time += employees[i].out.get(j) - employees[i].in.get(j);


                }

                employees[i].total_stay = total_stay;

                //找出最大滞留时间
                max_time = Math.max(max_time, employees[i].total_stay);

                //有效记录增加
                total_num++;

            }


        }

        System.out.printf("avg=%d\n", total_time / total_num);
        System.out.printf("max=%d\n", max_time);


    }

}
