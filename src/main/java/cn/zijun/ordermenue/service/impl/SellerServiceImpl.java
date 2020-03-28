package cn.zijun.ordermenue.service.impl;

import cn.zijun.ordermenue.dao.SellerInfoDao;
import cn.zijun.ordermenue.dataobject.SellerInfo;
import cn.zijun.ordermenue.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Title SellerServiceImpl
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/2/23
 */

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerInfoDao sellerInfoDao;
    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return sellerInfoDao.findByOpenid(openid);
    }

    @Override
    public SellerInfo findSellerInfoByUsername(String username) {
        return sellerInfoDao.findByUsername(username);
    }
}
