package cn.zijun.ordermenue.vo;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
* http请求返回的最外层
*
* */
@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = 2386624526963317922L;
    /**错误码*/
    private Integer code;

    /**提示信息*/
    private String msg;

    /**具体内容*/
    private  T data;
}
