package com.system.design.projects.multiThreading;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class AsyncController {

    private final AsyncService asyncService;

    public AsyncController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    public List<String> processOrder() throws ExecutionException, InterruptedException {
        return asyncService.processOrder();
    }
    public CompletableFuture<List<String>> processOrderAsync() throws ExecutionException, InterruptedException {
        return asyncService.processOrderAsync();
    }
}
