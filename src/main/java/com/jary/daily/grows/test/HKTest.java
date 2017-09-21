package com.jary.daily.grows.test;

import java.util.*;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/14 下午2:41
 */
public class HKTest {


    public static void main(String[] args) {

        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        Scanner in = new Scanner(System.in);
        String[] names = new String[10000];
        while (in.hasNext()) {
            String input = in.nextLine();
            String[] strs = input.split(";");


            boolean isOk = true;
            for (int i = 0; i < strs.length; i++) {
                if (!isValid(strs[i])) {
                    isOk = false;
                }
            }

            if (isOk) {
                for (int i = 0; i < strs.length; i++) {
                    String[] info = strs[i].split(",");
                    int id = Integer.parseInt(info[0]);
                    int bossId = Integer.parseInt(info[2]);
                    names[bossId] = info[1];
                    if (map.containsKey(bossId)) {
                        List<Integer> list = map.get(bossId);
                        list.add(id);
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(id);
                        map.put(bossId, list);
                    }
                }
            } else {
                System.out.println("incorrect data");
            }


            int key = 0;
            List<Integer> sub = map.get(0);
            System.out.print(names[key] + "-");
            while (sub != null && sub.size() != 0) {
                Iterator<Integer> it = sub.iterator();
                while (it.hasNext()){
                    key = it.next();
                    System.out.print(names[key] + "-");
                    it.remove();
                }
            }
        }

    }

    private static boolean isValid(String s) {
        String[] info = s.split(",");
        if (info[0].equals(info[2]))
            return false;
        else if (isNum(info[0]) && isNum(info[2])) {
            return true;
        }
        return false;
    }

    private static boolean isNum(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9')
                return false;
        }
        return true;
    }
}
