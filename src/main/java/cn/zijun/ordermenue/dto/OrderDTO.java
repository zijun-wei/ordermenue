package cn.zijun.ordermenue.dto;

import cn.zijun.ordermenue.dataobject.OrderDetail;
import cn.zijun.ordermenue.enums.OrderStatusEnum;
import cn.zijun.ordermenue.enums.PayStatusEnum;
import cn.zijun.ordermenue.utils.EnumUtil;
import cn.zijun.ordermenue.utils.serializer.Date2LongSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Zijun_Wei
 * @Title OrderDTO
 * @Description
 * @date 2020/2/18
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenId;

    private BigDecimal orderAmount;

    /**订单状态*/
    private Integer orderStatus;

    private Integer payStatus;

    @JsonSerialize(using= Date2LongSerializer.class)
    private Date createTime;

    @JsonSerialize(using= Date2LongSerializer.class)
    private Date updateTime;

    private List<OrderDetail>orderDetailList;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
    }
}
