package com.system.design.projects.multiThreading;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.*;

@Service
public class AsyncService {
    ExecutorService executorService = Executors.newFixedThreadPool(5);

    public List<String> processOrder() throws ExecutionException, InterruptedException {
        Future<String> future1 = executorService.submit(this::createAudit);
        Future<String> future2 = executorService.submit(this::createOrder);
        Future<String> future3 = executorService.submit(this::paymentProcess);
        Future<String> future4 = executorService.submit(this::createShipment);

        return List.of(
                future1.get(),
                future2.get(),
                future3.get(),
                future4.get()
        );

    }
    public CompletableFuture<List<String>> processOrderAsync(){
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(this::createAudit);
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(this::createOrder);
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(this::paymentProcess);
        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(this::createShipment);

        return CompletableFuture.allOf(
                future1,
                future2,
                future3,
                future4
        ).thenApply(data ->
                List.of(future1.join(),future2.join(),future3.join(),future4.join()));
    }
    public String createAudit(){
        return "audit created";
    }
    public String createOrder(){
        return "order created";
    }
    public String paymentProcess(){
        return "payment done";
    }
    public String createShipment(){
        return "shipment done";
    }

}
