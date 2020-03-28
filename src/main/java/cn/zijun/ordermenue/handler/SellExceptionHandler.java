package cn.zijun.ordermenue.handler;

import cn.zijun.ordermenue.exception.ResponseBankException;
import cn.zijun.ordermenue.exception.SellException;
import cn.zijun.ordermenue.exception.SellerAuthorizeException;
import cn.zijun.ordermenue.utils.ResultVoUtil;
import cn.zijun.ordermenue.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

import static org.springframework.http.HttpStatus.FORBIDDEN;

/**
 * @Title ExceptionHandler
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/2/23
 */
@ControllerAdvice
@Slf4j
public class SellExceptionHandler {

    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerSellerAuthorizeException(Exception e){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        String uri = request.getRequestURL().toString();
        Enumeration<String> parameterNames = request.getParameterNames();
        StringBuilder returnUri=new StringBuilder(uri+"?1=1");
        while (parameterNames.hasMoreElements()){
            returnUri.append("&");
            String name = parameterNames.nextElement();
            String param=request.getParameter(name);
            returnUri.append(name+"="+param);
        }
        ModelAndView mv=new ModelAndView("user/login");
        mv.addObject("returnUri",returnUri.toString());
        return mv;
    }


    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellerException(SellException e){
        return ResultVoUtil.error(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(value = ResponseBankException.class)
    @ResponseStatus(FORBIDDEN)
    public void handlerResponseBankException(ResponseBankException e){

    }
}
