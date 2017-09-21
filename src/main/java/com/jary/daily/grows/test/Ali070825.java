package com.jary.daily.grows.test;

import java.util.*;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/8/25 下午7:50
 */
public class Ali070825 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<UnilateralLine> lineList = new ArrayList<UnilateralLine>();
        while (scanner.hasNextLine()) {
            String[] options = scanner.nextLine().split(";");
            if (options.length < 5) {
                break;
            }
            lineList.add(new UnilateralLine(options[0], options[1], options[2], options[3], options[4], options[5]));
        }
        scanner.close();

        // wirte your code here
        List<String> result = calculateUnilateral(lineList);

        for (String str : result) {
            System.out.println(str);
        }

    }

    public static List<String> calculateUnilateral(List<UnilateralLine> lineList) {
        List<String> result = new ArrayList<String>();
        Map<String,List<UnilateralLine>> src = new HashMap<>();//出发分拨
        Map<String,List<UnilateralLine>> dest = new HashMap<>();//到达分拨
        for(UnilateralLine line : lineList){
            if(src.containsKey(line.sCen)){
                List<UnilateralLine> list = src.get(line.sCen);
                list.add(line);
                src.put(line.sCen,list);
            }else{
                List<UnilateralLine> list = new ArrayList<>();
                list.add(line);
                src.put(line.sCen,list);
            }

            if(dest.containsKey(line.eCen)){
                List<UnilateralLine> list = dest.get(line.eCen);
                list.add(line);
                dest.put(line.eCen,list);
            }else {
                List<UnilateralLine> list = new ArrayList<>();
                list.add(line);
                dest.put(line.eCen,list);
            }
        }

        for(Map.Entry<String,List<UnilateralLine>> entry : src.entrySet()){
            String sCen = entry.getKey();
            List<UnilateralLine> list = entry.getValue();
            for(Map.Entry<String,List<UnilateralLine>> entry1 : dest.entrySet()){

            }
        }

        return result;
    }

    public static class UnilateralLine {
        private String id;
        private String sCen;//出发分拨
        private String sPro;//出发省
        private String eCen;//到达分拨
        private String ePro;//到达省
        //9.6m/17.5m
        private String tType;//车型

        public UnilateralLine(String id, String sCen, String sPro, String eCen, String ePro, String tType) {
            this.id = id;
            this.sCen = sCen;
            this.sPro = sPro;
            this.eCen = eCen;
            this.ePro = ePro;
            this.tType = tType;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSCen() {
            return sCen;
        }

        public void setSCen(String ePro) {
            this.ePro = ePro;
        }

        public String getSPro() {
            return sPro;
        }

        public void setSPro(String sPro) {
            this.sPro = sPro;
        }

        public String getECen() {
            return eCen;
        }

        public void setECen(String eCen) {
            this.eCen = eCen;
        }

        public String getEPro() {
            return ePro;
        }

        public void setEPro(String ePro) {
            this.ePro = ePro;
        }

        public String getTType() {
            return tType;
        }

        public void setTType(String tType) {
            this.tType = tType;
        }
    }
}
