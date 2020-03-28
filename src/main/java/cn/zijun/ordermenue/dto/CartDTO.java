package cn.zijun.ordermenue.dto;

import lombok.Data;

/**
 * @author Zijun_Wei
 * @Title CartDTO
 * @Description
 * @date 2020/2/18
 */
@Data
public class CartDTO {

    private String productId;

    private Integer productQuantity;


    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
