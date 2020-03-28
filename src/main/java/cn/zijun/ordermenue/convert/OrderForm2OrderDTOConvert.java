package cn.zijun.ordermenue.convert;


import cn.zijun.ordermenue.dataobject.OrderDetail;
import cn.zijun.ordermenue.dto.OrderDTO;
import cn.zijun.ordermenue.enums.ResultEnum;
import cn.zijun.ordermenue.exception.SellException;
import cn.zijun.ordermenue.form.OrderForm;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Zijun_Wei
 * @Title OrderForm2OrderDTOConvert
 * @Description
 * @date 2020/2/19
 */
@Slf4j
public class OrderForm2OrderDTOConvert {
    public static OrderDTO convert(OrderForm orderForm){
        Gson gson=new Gson();
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenId(orderForm.getOpenid());
        List<OrderDetail> orderDetailList=new ArrayList<>();

        try{
            orderDetailList=gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        }catch (Exception e){
            log.error("【对象转换】错误，string={}",orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }


}
