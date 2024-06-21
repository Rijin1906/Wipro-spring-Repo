//package com.wipro.config;
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//@Configuration
//public class GatewayConfiiguration {
//	@Bean
//   public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
//       return builder.routes()
//               .route(r -> r.path("/gc/**")
//               		.filters(f->f.addRequestHeader("Hello","World"))
//                       .uri("lb://PRODUCER-SERVICE")
//                       )
//               .route(r -> r.path("/ccf/**")
//                       .uri("lb://CONSUMER-SERVICE")
//                      )
//               .build();
//   }
//}
