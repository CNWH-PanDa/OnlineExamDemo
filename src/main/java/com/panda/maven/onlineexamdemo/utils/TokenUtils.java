package com.panda.maven.onlineexamdemo.utils;


import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.panda.maven.onlineexamdemo.service.IUserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@Slf4j
public class TokenUtils {

    @Resource
    private IUserService userService;

    public static String genToken(String username, String sign) {
        return JWT.create()
                .withAudience(username)
                .withExpiresAt(DateUtil.offsetHour(new Date(), 2))
                .sign(Algorithm.HMAC256(sign));
    }
}


