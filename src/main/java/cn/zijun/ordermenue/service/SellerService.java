package cn.zijun.ordermenue.service;

import cn.zijun.ordermenue.dataobject.SellerInfo;

/**
 * @Title SellerService
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/2/23
 */
public interface SellerService {
    /**
     * 查看卖家端信息
     * @param openid 微信提供openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);

    SellerInfo findSellerInfoByUsername(String username);

}
