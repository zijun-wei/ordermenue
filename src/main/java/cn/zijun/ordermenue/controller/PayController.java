package cn.zijun.ordermenue.controller;

import cn.zijun.ordermenue.dto.OrderDTO;
import cn.zijun.ordermenue.enums.ResultEnum;
import cn.zijun.ordermenue.exception.SellException;
import cn.zijun.ordermenue.service.OrderService;
import cn.zijun.ordermenue.service.PayService;
import com.lly835.bestpay.model.PayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Objects;

/**
 * @Title PayController
 * @Description
 * @Author Zijun Wei
 * @Date 2020/3/10
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

//    @GetMapping("/create")
//    public ModelAndView create(@RequestParam("orderId") String orderId,
//                       @RequestParam("returnUrl")String returnUrl,
//                       Map<String, Object> map){
//        /**1. 查询订单*/
//        OrderDTO orderDTO = orderService.findOne(orderId);
//        if (orderDTO == null) {
//            throw new SellException(ResultEnum.ORDER_NOT_EXIT);
//        }
//
//        /**2. 发起支付*/
//        PayResponse payResponse = payService.create(orderDTO);
//
//        map.put("payResponse", payResponse);
//        map.put("returnUrl", returnUrl);
//
//        return new ModelAndView("pay/create", map);
//    }

    @GetMapping("/create")
    public String create(@RequestParam("orderId") String orderId,
                       @RequestParam("returnUrl")String returnUrl,
                       Map<String, Object> map){
        /**1. 查询订单*/
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIT);
        }

        orderService.paid(orderDTO);
        return "redirect:"+returnUrl;
    }


    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData) {
        payService.notify(notifyData);

        //返回给微信处理结果
        return new ModelAndView("pay/success");
    }
}
