package com.amsidh.mvc.springreactivestreamingapp.service;

import com.amsidh.mvc.springreactivestreamingapp.model.Share;
import reactor.core.publisher.Flux;

import java.time.Duration;

public interface ShareService {
    Flux<Share> getShareStream(Duration duration);
}
