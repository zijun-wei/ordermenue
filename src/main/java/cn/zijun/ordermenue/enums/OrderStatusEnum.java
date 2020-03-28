package cn.zijun.ordermenue.enums;

import lombok.Getter;

/**
 * @author Zijun_Wei
 * @Title OrderStatusEnum
 * @Description 订单状态枚举
 * @date 2019/12/30
 */

@Getter
public enum OrderStatusEnum implements CodeEnum{

    /**
     * 订单状态，默认为新订单
     * */
    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已取消"),
    ;
    private Integer code;

    private String message;

    OrderStatusEnum(Integer code,String message) {
        this.code = code;
        this.message=message;
    }
}
