package com.zzm.datasource.utils;

import java.util.Random;
import java.util.UUID;

/**
 * @Author: james
 * @Description: 各种id生成策略
 * @Date: created in 13:57 2018/8/30
 * @version 1.0
 **/
public class IDUtils {

    /**
     * 确保不能实例化
     */
    private IDUtils(){};

    /**
     * 获取随机id
     * @param randomNum 随机最大值
     * @param limitNum 限制的位数
     * @return
     */
    public static String getRandomID(Integer randomNum,String limitNum) {

        //取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();

        Random random = new Random();
        //加上randomNum位随机数
        int end3 = random.nextInt(randomNum);

        //如果不足limitNum位前面补0
        String str = millis + String.format("%0"+limitNum+"d", end3);

        return str;
    }

    /**
     * 获取UUID4位
     * @return
     */
    public static String getUuid4ID(Integer subscript) {
        System.out.println("之前"+UUID.randomUUID().toString());
        //去除空格
        String[] id = UUID.randomUUID().toString().split("-");
        for(String str : id){
            System.out.println(str);
        }
        return id[subscript];
    }

    public static String getUuidID() {

        //去除空格
        String id = UUID.randomUUID().toString().replaceAll("-","");

        //确保id值不能大于40位
        id = id.length() > 40 ? id.substring(0,39) : id;

        return id;
    }



    public static void main(String[] args) {
        System.out.println(getUuid4ID(0));
    }

}
