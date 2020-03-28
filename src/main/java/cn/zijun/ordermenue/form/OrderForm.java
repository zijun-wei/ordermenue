package cn.zijun.ordermenue.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author Zijun_Wei
 * @Title OrderForm
 * @Description
 * @date 2020/2/19
 */
@Data
public class OrderForm {
    @NotEmpty(message = "姓名必填")
    private String name;

    @NotEmpty(message = "手机号必填")
    private String phone;

    @NotEmpty(message = "地址必填")
    private String address;

    @NotEmpty(message = "openid必填")
    private String openid;

    @NotEmpty(message = "购物内容必填")
    private String items;
}
