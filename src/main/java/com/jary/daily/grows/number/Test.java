package com.jary.daily.grows.number;

/**
 * @author fanzhengjie
 * @create 2018/7/18 下午11:05
 * @description
 */
public class Test {

    public static void main(String[] args){
        testNPE();
    }

    /**
     * 考虑这段代码 为啥包空指针
     * 拆箱问题
     */
    private static void testNPE(){
        ResultResponse resultResponse = new ResultResponse();
        DetailConfigItem detailConfigItem = new DetailConfigItem();
        boolean hasDetailConfigItem = null!= detailConfigItem;
        resultResponse.setHeadPicUrl(hasDetailConfigItem? detailConfigItem.getImageUrl():"");
        resultResponse.setActionType(hasDetailConfigItem? detailConfigItem.getActionType(): 0);
        System.out.println(resultResponse);
    }

}
