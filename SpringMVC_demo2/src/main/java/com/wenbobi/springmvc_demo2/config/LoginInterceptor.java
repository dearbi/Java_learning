package com.wenbobi.springmvc_demo2.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wenbobi.springmvc_demo2.enums.ResultCode;
import com.wenbobi.springmvc_demo2.model.UserInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        if (session == null) {
            log.info("用户未登录,请求被拦截: {}", request.getRequestURI());
            writeUnloginResponse(response);
            return false;
        }

        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        if (userInfo == null || userInfo.getId() == null || userInfo.getId() < 1) {
            log.info("用户未登录,请求被拦截: {}", request.getRequestURI());
            writeUnloginResponse(response);
            return false;
        }

        return true;
    }

    private void writeUnloginResponse(HttpServletResponse response) throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(ResultCode.unlogin()));
    }
}
