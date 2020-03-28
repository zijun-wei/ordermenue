package cn.zijun.ordermenue.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * @author Zijun_Wei
 * @Title JsonUtil
 * @Description
 * @date 2020/2/20
 */
public class JsonUtil {

    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
