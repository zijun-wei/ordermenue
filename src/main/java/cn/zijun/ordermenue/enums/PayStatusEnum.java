package cn.zijun.ordermenue.enums;

import lombok.Getter;

/**
 * @author Zijun_Wei
 * @Title PayStatusEnum
 * @Description
 * @date 2019/12/30
 */

@Getter
public enum PayStatusEnum implements CodeEnum{
    /**
     * 支付状态，默认为等待支付
     * */
    WAIT(0,"新订单"),
    SUCCESS(1,"完结"),
    ;
    private Integer code;

    private String message;

    PayStatusEnum(Integer code,String message) {
        this.code = code;
        this.message=message;
    }
}
