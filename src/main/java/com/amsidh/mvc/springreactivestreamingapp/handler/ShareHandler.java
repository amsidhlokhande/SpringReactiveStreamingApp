package com.amsidh.mvc.springreactivestreamingapp.handler;

import com.amsidh.mvc.springreactivestreamingapp.model.Share;
import com.amsidh.mvc.springreactivestreamingapp.service.ShareService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RequiredArgsConstructor
@Slf4j
@Component
public class ShareHandler {

    private final ShareService shareService;

    public Mono<ServerResponse> getShares(ServerRequest serverRequest) {
        int size = Integer.parseInt(serverRequest.queryParam("size").orElse("10"));
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(shareService.getShareStream(Duration.ofMillis(100L))
                        .take(size), Share.class);
    }

    public Mono<ServerResponse> getShareStream() {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_NDJSON)
                .body(shareService.getShareStream(Duration.ofMillis(100L)), Share.class);
    }

}
