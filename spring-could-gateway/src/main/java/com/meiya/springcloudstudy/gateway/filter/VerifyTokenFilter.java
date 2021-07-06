package com.meiya.springcloudstudy.gateway.filter;

import com.meiya.springcloudstudy.common.utils.JsonWebTokenUtil;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.RequestPath;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Component
public class VerifyTokenFilter implements GlobalFilter, Ordered {

    private static final String TOKEN_KEY = "authorization";

    private static final Logger logger = LoggerFactory.getLogger(VerifyTokenFilter.class);


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        RequestPath path = exchange.getRequest().getPath();
        String token = exchange.getRequest().getHeaders().getFirst(TOKEN_KEY);
        if(StringUtils.isBlank(token)){
            logger.warn("{}请求未携带令牌, 鉴权失败!", path);
            return this.badRequestResponse(response, "令牌为空, 鉴权失败!");
        }
        try {
            Claims claims = JsonWebTokenUtil.parse(token);
        } catch (Exception e) {
            logger.error("令牌:[{}]有误, 鉴权失败!", token);
            return this.badRequestResponse(response, "令牌为误, 鉴权失败!");
        }
        return chain.filter(exchange);
    }

    /**
     * 构建失败请求响应
     * @param response 响应对象
     * @param message 响应信息
     * @return 响应
     */
    private Mono<Void> badRequestResponse(ServerHttpResponse response, String message){
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        DataBuffer buffer = response.bufferFactory().wrap(message.getBytes(StandardCharsets.UTF_8));
        return response.writeWith(Mono.just(buffer));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
