package cn.zijun.ordermenue.service.impl;

import cn.zijun.ordermenue.dto.OrderDTO;
import cn.zijun.ordermenue.enums.ResultEnum;
import cn.zijun.ordermenue.exception.SellException;
import cn.zijun.ordermenue.service.BuyerService;
import cn.zijun.ordermenue.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Zijun_Wei
 * @Title BuyerServiceImpl
 * @Description
 * @date 2020/2/19
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid,orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO=checkOrderOwner(openid,orderId);
        if (orderDTO==null){
            log.error("【取消订单】查不到该订单，orderId={}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIT);
        }

        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrderOwner(String openid, String orderId){
        OrderDTO orderDTO=orderService.findOne(orderId);
        if (orderDTO==null){
            return null;
        }
        if (!orderDTO.getBuyerOpenId().equalsIgnoreCase(openid)){
            log.error("【查询订单】订单的openid不一致，openid={},orderDTO={}",openid,orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
