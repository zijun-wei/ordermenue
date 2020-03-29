package cn.zijun.ordermenue.controller;

import cn.zijun.ordermenue.enums.ResultEnum;
import cn.zijun.ordermenue.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @Title WechatController
 * @Description
 * @Author Zijun Wei
 * @Date 2020/3/9
 */
@Controller
@RequestMapping("/wechat")
@Slf4j
public class WechatController {

    @Autowired
    private WxMpService wxMpService;

    private final String returnUri="http://119.3.105.163/#/";

//    @GetMapping("/authorize")
//    public String authorize(@RequestParam("returnUrl")String returnUrl) {
//        1.配置
//        2.调用方法
//
//        String url = "http://zijunorder.natapp1.cc/sell/wechat/userInfo";
//        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO, returnUrl);
//        return "redirect:"+redirectUrl;
//    }

    @GetMapping("/authorize")
    public ModelAndView authorize(@RequestParam("returnUrl")String returnUrl, Map<String,Object> map){

        map.put("returnUri",returnUri);
        /**自定义方法*/
        return new ModelAndView("buyer/login",map);
    }

//    @GetMapping("/userInfo")
//    public String userInfo(@RequestParam("code")String code,
//                         @RequestParam("state")String returnUrl){
//        WxMpOAuth2AccessToken wxMpOAuth2AccessToken=new WxMpOAuth2AccessToken();
//        try {
//            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
//        } catch (WxErrorException e) {
//            log.error("【微信授权网页】 {}",e);
//            throw new SellException(ResultEnum.WECHAT_MP_ERROR.getCode(),e.getError().getErrorMsg());
//        }
//        String openId = wxMpOAuth2AccessToken.getOpenId();


    @PostMapping("/userInfo")
        public String userInfo(@RequestParam("returnUri")String returnUrl,
                @RequestParam("telephone")String telephone,
                @RequestParam("username")String username){
        /**自定义*/
        String openId=telephone;
        return "redirect:"+returnUrl+"?openid="+openId;
    }
}
