package cn.zijun.ordermenue.dao;

import cn.zijun.ordermenue.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Zijun_Wei
 * @Title OderMasterDao
 * @Description
 * @date 2020/2/18
 */
public interface OrderMasterDao extends JpaRepository<OrderMaster,String> {
    /**按买家Openid查订单*/
    Page<OrderMaster> findByBuyerOpenId(String buyerOpenid, Pageable pageable);
}
