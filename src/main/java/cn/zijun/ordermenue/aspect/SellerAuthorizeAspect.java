package cn.zijun.ordermenue.aspect;

import cn.zijun.ordermenue.constant.CookieConstant;
import cn.zijun.ordermenue.constant.RedisConstant;
import cn.zijun.ordermenue.exception.SellerAuthorizeException;
import cn.zijun.ordermenue.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Title SellerAuthorizeAspect
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/2/23
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Pointcut("execution(* cn.zijun.ordermenue.controller.Seller*.*(..))"+
    "&& !execution(* cn.zijun.ordermenue.controller.SellerUserController.*(..))")
    public void verify(){};

    @Before("verify()")
    public void doVerify(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();

        Cookie cookie= CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie==null){
            log.warn("【登录校验】Cookie中查不到token");
            throw new SellerAuthorizeException();
        }

        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
        if (StringUtils.isEmpty(tokenValue)){
            log.warn("【登录校验】Cookie中查不到token");
            throw new SellerAuthorizeException();
        }

    }
}
