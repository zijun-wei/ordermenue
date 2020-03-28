package cn.zijun.ordermenue.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Zijun_Wei
 * @Title ProductForm
 * @Description
 * @date 2020/2/23
 */
@Data
public class ProductForm {
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer categoryType;
}
