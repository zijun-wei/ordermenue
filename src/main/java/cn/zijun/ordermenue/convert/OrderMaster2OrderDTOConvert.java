package cn.zijun.ordermenue.convert;

import cn.zijun.ordermenue.dataobject.OrderMaster;
import cn.zijun.ordermenue.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Zijun_Wei
 * @Title OrderMaster2OrderDTO
 * @Description
 * @date 2020/2/19
 */
public class OrderMaster2OrderDTOConvert {
    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO=new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }
    public static List<OrderDTO>convert(List<OrderMaster>orderMasterList){
        List<OrderDTO> orderDTOList = orderMasterList.stream().map(e ->
                convert(e)).collect(Collectors.toList());
        return orderDTOList;
    }
}
