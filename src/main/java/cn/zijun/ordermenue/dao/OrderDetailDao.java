package cn.zijun.ordermenue.dao;

import cn.zijun.ordermenue.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Zijun_Wei
 * @Title OderDetailDao
 * @Description
 * @date 2020/2/18
 */
public interface OrderDetailDao extends JpaRepository<OrderDetail,String> {
    /**根据订单号查询订单*/
    List<OrderDetail> findByOrderId(String orderId);
}
