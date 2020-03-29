package cn.zijun.ordermenue.controller;

import cn.zijun.ordermenue.constant.CookieConstant;
import cn.zijun.ordermenue.constant.RedisConstant;
import cn.zijun.ordermenue.dataobject.SellerInfo;
import cn.zijun.ordermenue.enums.ResultEnum;
import cn.zijun.ordermenue.service.SellerService;
import cn.zijun.ordermenue.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Title SellerUserController
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/2/23
 */

@Controller
@RequestMapping("/seller")
public class SellerUserController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private StringRedisTemplate redisTemplate;


//    @GetMapping("/login")
//    public ModelAndView login(@RequestParam("openid")String openid,
//                              Map<String,Object>map,
//                              HttpServletResponse response){
//        SellerInfo sellerInfo=sellerService.findSellerInfoByOpenid(openid);
//        if (sellerInfo==null){
//            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
//            map.put("url","/sell/seller/order/list");
//            return new ModelAndView("common/error",map);
//        }
//
//        /**
//         * 设置token至redis
//         */
//        String token= UUID.randomUUID().toString();
//
//        Integer expire= RedisConstant.EXPIRE;
//
//        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX,token),openid,expire, TimeUnit.SECONDS);
//
//        Cookie cookie=new Cookie("token",token);
//
//        CookieUtil.set(response, CookieConstant.TOKEN,token,expire);
//
//        return new ModelAndView("redirect:/seller/order/list");
//    }


    @PostMapping("/login")
    public ModelAndView login(@RequestParam("username")String username,
                              @RequestParam("password")String password,
                              @RequestParam(value = "returnUri",required = false,defaultValue = "/seller/order/list")String uri,
                              Map<String,Object>map,
                              HttpServletResponse response){
        SellerInfo sellerInfo=sellerService.findSellerInfoByUsername(username);
        if (sellerInfo==null){
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error",map);
        }
        /**
         * 设置token至redis
         */
        String token= UUID.randomUUID().toString();

        Integer expire= RedisConstant.EXPIRE;

        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX,token),sellerInfo.getOpenid(),expire, TimeUnit.SECONDS);

        Cookie cookie=new Cookie("token",token);

        CookieUtil.set(response, CookieConstant.TOKEN,token,expire);

        return new ModelAndView("redirect:"+uri);
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                       HttpServletResponse response,
                       Map<String,Object>map){
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie != null){
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
            CookieUtil.set(response, CookieConstant.TOKEN,null,0);
        }
        map.put("msg",ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url","/sell/seller/order/list");
        return new ModelAndView("common/success",map);
    }
}
