package com.amsidh.mvc.springreactivestreamingapp.service.impl;

import com.amsidh.mvc.springreactivestreamingapp.model.Share;
import com.amsidh.mvc.springreactivestreamingapp.service.ShareService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;

class ShareServiceImplTest {

    ShareService shareService;

    @BeforeEach
    void setUp() {
        this.shareService = new ShareServiceImpl();
    }

    @Test
    public void testGetShareStream() throws InterruptedException {

        Consumer<Share> shareConsumer = System.out::println;

        Consumer<Throwable> errorConsumer = e -> System.out.println(e.getMessage());

        CountDownLatch countDownLatch = new CountDownLatch(1);

        Runnable completeConsumer = () -> countDownLatch.countDown();

        Flux<Share> shareStream = this.shareService.getShareStream(Duration.ofMillis(100l));

        shareStream.take(30).subscribe(shareConsumer, errorConsumer, completeConsumer);

        countDownLatch.await();


    }
}