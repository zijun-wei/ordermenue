package cn.zijun.ordermenue.exception;

import cn.zijun.ordermenue.enums.ResultEnum;
import lombok.Getter;

/**
 * @author Zijun_Wei
 * @Title SellException
 * @Description
 * @date 2020/2/18
 */
@Getter
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
