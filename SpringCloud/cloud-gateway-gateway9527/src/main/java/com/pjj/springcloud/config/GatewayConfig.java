package com.pjj.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 潘俊杰
 * @date 2021年10月27日 15:21
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator consumerRouteLocator(RouteLocatorBuilder builder){

        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_pjj",r -> r.path("/guoji")
                .uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }
}
