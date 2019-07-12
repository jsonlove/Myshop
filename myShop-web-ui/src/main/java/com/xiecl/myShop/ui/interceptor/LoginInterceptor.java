package com.xiecl.myShop.ui.interceptor;

import com.xiecl.myShop.commons.constans.ConstansUtil;
import com.xiecl.myShop.domain.TbUser;
import com.xiecl.myShop.ui.api.ConstansUi;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("11111111111");
        TbUser tbUser = (TbUser) request.getSession().getAttribute(ConstansUi.CACHE_USER_KEY);
        // 未登录状态
        if (tbUser == null) {

            return true;
        }

        // 已登录状态
        else {
            response.sendRedirect(request.getContextPath()+"/index");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
