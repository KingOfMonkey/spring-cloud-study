package com.meiya.springcloudstudy.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.SecretKey;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 *  jwt工具类
 */
public class JsonWebTokenUtil {
    // 生成签名的时候使用的秘钥secret，切记这个秘钥不能外露哦。它就是你服务端的私钥，在任何场景都不应该流露出去
    private static final String primaryKey = "r3NQf5nOat5x4V4qcDm80MicaskWeBhf86y4KvP6vOdZlPVEkH0g";

    /**
     * 创建token
     * @param userId 用户Id
     * @param sub 主题
     * @param millions 过期时间
     * @return token
     */
    public static String create(String userId, String sub, long millions){
        SecretKey key = generateKey();
        Long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        Claims claims = Jwts.claims();
        claims.put("userId", userId);
        claims.put("roles", "administrator");
        claims.put("loginDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now));
        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)//使用自定义载体，这个需要放到最前面，否则会将下面的设置覆盖掉
                .setId(UUID.randomUUID().toString())//token的id（代表唯一性)
                .setIssuer("pico")//签发人
                .setSubject(sub)//主题
                .setAudience("webClient")//接收jwt的一方
                .setIssuedAt(now)//签发token日志
                .signWith(key);//使用key签名
        if (millions > 0) {
            long expMillis = nowMillis + millions;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp); //设置过期时间
        }
        return builder.compact();
    }

    private static SecretKey generateKey(){
        byte[] keyBytes = Base64.decodeBase64(primaryKey);
        SecretKey key = Keys.hmacShaKeyFor(keyBytes);
        return key;
    }

    /**
     * 解析token
     * @param token
     * @return 结果：成功返回Claims 失败抛出异常
     */
    private static Claims parse(String token){
        SecretKey key = generateKey();
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    }
}
