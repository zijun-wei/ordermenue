package cn.zijun.ordermenue.utils;

import cn.zijun.ordermenue.enums.CodeEnum;

/**
 * @author Zijun_Wei
 * @Title EnumUtil
 * @Description
 * @date 2020/2/20
 */
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){
        for (T each:enumClass.getEnumConstants()){
            if (code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
