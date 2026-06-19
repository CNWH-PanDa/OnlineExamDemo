package com.panda.maven.onlineexamdemo.common;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.panda.maven.onlineexamdemo.entity.User;
import com.panda.maven.onlineexamdemo.exception.ServiceException;
import com.panda.maven.onlineexamdemo.service.IUserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
public class JwtInterceptor implements HandlerInterceptor {

    private static final String ERROR_CODE_401 = "401";

    @Autowired
    private IUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("token");
        if (StrUtil.isBlank(token)) {
            token = request.getParameter("token");
        }
        // 执行认证
        if (StrUtil.isBlank(token)) {
            throw new ServiceException(ERROR_CODE_401, "无token，请重新登录");
        }

        // 获取 token 中的username
        String username;
        User user;
        try {
            username = JWT.decode(token).getAudience().get(0);
            // 根据token中的username查询数据库
            user = userService.getByUsername1(username);
        } catch (Exception e) {
            String errMsg = "token验证失败，请重新登录";
            log.error(errMsg + ", token=" + token, e);
            throw new ServiceException(ERROR_CODE_401, errMsg);
        }
        if (user == null) {
            throw new ServiceException(ERROR_CODE_401, "用户不存在，请重新登录");
        }

        String path = request.getRequestURI();

        if (user.getRole().equals("student") && (path.startsWith("/api/teacher/profile/") || path.startsWith("/api/teacher/exam"))) {
            throw new ServiceException("学生无法访问");
        }

        try {
            // 用户密码加签验证 token
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
            jwtVerifier.verify(token); // 验证token
        } catch (JWTVerificationException e) {
            throw new ServiceException(ERROR_CODE_401, "token验证失败，请重新登录");
        }
        return true;
    }
}
