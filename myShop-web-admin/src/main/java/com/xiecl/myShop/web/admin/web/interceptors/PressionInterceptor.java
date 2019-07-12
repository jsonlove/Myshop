package com.xiecl.myShop.web.admin.web.interceptors;

import com.xiecl.myShop.commons.constans.ConstansUtil;
import com.xiecl.myShop.domain.TbUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PressionInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
      if(modelAndView==null){return;}
        if(modelAndView.getViewName().endsWith("login")){
          TbUser user= (TbUser) httpServletRequest.getSession().getAttribute(ConstansUtil.SESSION_USER);
          if(user!=null){
              httpServletResponse.sendRedirect("/home");
          }
      }
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
