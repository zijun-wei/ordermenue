package cn.zijun.ordermenue.controller;

import cn.zijun.ordermenue.dto.OrderDTO;
import cn.zijun.ordermenue.enums.ResultEnum;
import cn.zijun.ordermenue.exception.SellException;
import cn.zijun.ordermenue.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author Zijun_Wei
 * @Title SellerOrderController
 * @Description 卖家端订单
 * @date 2020/2/20
 */
@Controller
@RequestMapping("/seller/order")
@Slf4j
public class SellerOrderController {

    @Autowired
    private OrderService orderService;
    /**
     *
     * @param page 第几页,从第一页开始
     * @param size 一页有几行数据
     * @return 订单列表
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                             @RequestParam(value = "size",defaultValue = "5")Integer size,
                             Map<String,Object> map){
        PageRequest pageRequest=PageRequest.of(page-1,size);
        Page<OrderDTO>orderDTOPage=orderService.findList(pageRequest);
        map.put("orderDTOPage",orderDTOPage);
        map.put("currentPage",page);
        map.put("pageSize",size);
        return new ModelAndView("order/list",map);
    }

    /**
     * @param orderId 订单的id号
     * @param map ModelAndView
     * @return ModelAndView
     */
    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam("orderId")String orderId,Map<String,Object>map){
        try{
            OrderDTO orderDTO=orderService.findOne(orderId);
            orderService.cancel(orderDTO);
        }catch (SellException e){
            log.error("【卖家取消订单】 发生异常{}",e);
            map.put("msg", e.getMessage());
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error",map);
        }

        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMessage());
        map.put("url","/sell/seller/order/list");
        return new ModelAndView("common/success",map);
    }

    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId")String orderId,
                               Map<String,Object>map){
        OrderDTO orderDTO=new OrderDTO();
        try{
            orderDTO=orderService.findOne(orderId);
        }catch (SellException e){
            log.error("【卖家查询订单】 发生异常{}",e);
            map.put("msg", e.getMessage());
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error",map);
        }
        map.put("orderDTO",orderDTO);
        return new ModelAndView("order/detail",map);
    }

    /**
     * @param orderId 订单的id号
     * @param map
     * @return 完结订单
     */
    @GetMapping("/finish")
    public ModelAndView finish(@RequestParam("orderId")String orderId,Map<String,Object>map){
        try{
            OrderDTO orderDTO=orderService.findOne(orderId);
            orderService.finish(orderDTO);
        }catch (SellException e){
            log.error("【卖家完结订单】 发生异常{}",e);
            map.put("msg", e.getMessage());
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error",map);
        }

        map.put("msg", ResultEnum.ORDER_FINISH_SUCCESS.getMessage());
        map.put("url","/sell/seller/order/list");
        return new ModelAndView("common/success",map);
    }
}
