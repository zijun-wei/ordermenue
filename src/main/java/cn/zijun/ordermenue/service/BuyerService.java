package cn.zijun.ordermenue.service;

import cn.zijun.ordermenue.dto.OrderDTO;

/**
 * @author Zijun_Wei
 * @Title BuyerService
 * @Description
 * @date 2020/2/19
 */
public interface BuyerService {
    /**查询一个订单*/
    OrderDTO findOrderOne(String openid,String orderId);

    /**取消订单*/
    OrderDTO cancelOrder(String openid,String orderId);
}
