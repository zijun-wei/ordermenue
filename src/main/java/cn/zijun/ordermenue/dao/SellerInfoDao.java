package cn.zijun.ordermenue.dao;

import cn.zijun.ordermenue.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Title SellerInfoDao
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/2/23
 */
public interface SellerInfoDao extends JpaRepository<SellerInfo,String>{
    /**
     * 用于查询用户，微信登录会提供openid
     * @param openid
     * @return
     */
    SellerInfo findByOpenid(String openid);

    SellerInfo findByUsername(String username);
}
