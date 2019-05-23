package com.xxx;


import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Data;
import org.apache.commons.jexl3.*;
import org.apache.commons.jexl3.internal.Engine;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * aa
 *
 * @author guodq
 * @create 2018-09-14 下午8:34
 */

public class AA {
    private static List<Integer> r1 = Lists.newArrayList();

    private static List<Integer> r2 = Lists.newArrayList();

    private static String a = "{\"status\":[2,3]} && {\"status\":[2,3]}";


    public static void main(String[] args) {

//        Map<String,Object> statusMap = Maps.newHashMap();
//        statusMap.put("status",Lists.newArrayList(2,3));
////        String s = JSON.toJSONString(statusMap);
//        List<Object> caiList = Lists.newArrayList();
//        // 查找所有的没有计算完成的
//        List<CalProcess> processes = Lists.newArrayList(new CalProcess(1,"("+JSON.toJSONString(statusMap) + "&&" + JSON.toJSONString(statusMap)+")",1));
//
//        // 查找采购单
//        Map<Integer,PurOrder> pMap = Maps.newHashMap();
//        pMap.put(1,new PurOrder(1,2,3));
//        for (CalProcess process : processes) {
//                cal(process.getElements(),pMap.get(process.pId));
//        }
        String exp1 = "status == 3 ";
        String exp2 = "status == 3 && payStatus = 5";
//        a = " ";1哦
        JexlEngine jexlEngine = new Engine();
        JexlExpression jexlExpression = jexlEngine.createExpression(exp1);
        JexlContext context = new MapContext();
        context.set("status",5);
        System.out.println(jexlExpression.evaluate(context));
    }

    @Data
    public static class PurOrder{

        private Integer pId;

        private Integer orderStatus;

        private Integer payStatus;

        public PurOrder(Integer pId, Integer orderStatus, Integer payStatus) {
            this.pId = pId;
            this.orderStatus = orderStatus;
            this.payStatus = payStatus;
        }
    }

    @Data
    public static class CalProcess{
        private Integer status;

        private String elements;

        private Integer pId;

        public CalProcess(Integer status, String elements, Integer pId) {
            this.status = status;
            this.elements = elements;
            this.pId = pId;
        }
    }

    // ({"status":[2,3]}&&{"status":[2,3]})
    public static boolean cal(String rule, PurOrder purOrder){
       return true;
    }

}
