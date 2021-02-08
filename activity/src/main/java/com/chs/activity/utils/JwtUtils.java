package com.chs.activity.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

/**
 * @author : HongSheng.Chen
 * @date : 2020/12/24 10:07
 */
public class JwtUtils {

    private final static String SECRET = "secret";

    private final static String ISSUER = "issuer";

    private final static String USER_ID = "userId";

    public static String creatToken(String userId, Long time) {

        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        String token = JWT.create()
                // 发布者
                .withIssuer(ISSUER)
                // 生成签名的时间
                .withIssuedAt(new Date())
                // 生成签名的有效期,小时
                .withExpiresAt(new Date(System.currentTimeMillis() + time))
                // 插入数据
                .withClaim(USER_ID, userId)
                .sign(algorithm);
        return token;

    }


    public static String verifierToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    //匹配指定的token发布者 auth0
                    .withIssuer(ISSUER)
                    .build();
            //解码JWT ，verifier 可复用
            DecodedJWT jwt = verifier.verify(token);

            return jwt.getClaim(USER_ID).asString();
        } catch (JWTVerificationException e) {

            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String token = JwtUtils.creatToken("chs", 10 * 1000L);
        String s = JwtUtils.verifierToken(token);
        System.out.println(token);
        System.out.println(s);
    }

}
