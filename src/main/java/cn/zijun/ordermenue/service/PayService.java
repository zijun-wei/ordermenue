package cn.zijun.ordermenue.service;

import cn.zijun.ordermenue.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;

/**
 * @Title PayService
 * @Description
 * @Author Zijun Wei
 * @Date 2020/3/10
 */
public interface PayService {
    PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

    RefundResponse refund(OrderDTO orderDTO);

    void OrderPay(String orderId);

}
