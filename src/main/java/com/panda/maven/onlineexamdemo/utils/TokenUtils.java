package com.panda.maven.onlineexamdemo.utils;


import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@Slf4j
public class TokenUtils {

    private static final String JWT_SECRET = "OnlineExamSecretKey2026!";

    public static String genToken(String username) {
        return JWT.create()
                .withAudience(username)
                .withExpiresAt(DateUtil.offsetHour(new Date(), 2))
                .sign(Algorithm.HMAC256(JWT_SECRET));
    }
}


