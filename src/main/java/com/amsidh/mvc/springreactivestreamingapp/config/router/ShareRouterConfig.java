package com.amsidh.mvc.springreactivestreamingapp.config.router;

import com.amsidh.mvc.springreactivestreamingapp.handler.ShareHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_NDJSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class ShareRouterConfig {

    @Bean
    public RouterFunction<ServerResponse> getShareRouterConfig(ShareHandler shareHandler) {
        return RouterFunctions.route().GET("/share", accept(APPLICATION_JSON), shareHandler::getShares)
                .GET("/share", accept(APPLICATION_NDJSON), shareHandler::getShareStream)
                .build();
    }
}
