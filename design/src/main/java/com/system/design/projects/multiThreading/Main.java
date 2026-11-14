package com.system.design.projects.multiThreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String args[]) throws ExecutionException, InterruptedException {
        System.out.println("Main Thread "+Thread.currentThread().getName());
        Runnable runnable = () -> {
            System.out.println("Running in: "
                    + Thread.currentThread().getName());
        };
        Thread thread = new Thread(runnable);
        thread.start();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ProducerConsumer producerConsumer = new ProducerConsumer();
        executorService.submit(() -> producerConsumer.removeValue(1));
        executorService.submit(() -> producerConsumer.addValue(1));
        executorService.submit(() -> producerConsumer.addValue(1));
        executorService.submit(() -> producerConsumer.removeValue(1));


       // cache thread create /reuse thread based on requirement
        ExecutorService executor =
                Executors.newCachedThreadPool();

        executor.submit(() -> System.out.println("Task 1"));
        executor.submit(() -> System.out.println("Task 2"));

        //scheduled thread pool
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);

        scheduledThreadPool.schedule(() -> System.out.println("hello"),2, TimeUnit.MILLISECONDS);


        Callable<Integer> call = () -> 20;
        Future<Integer> callRes = executorService.submit(call);
        Integer res = callRes.get();
        System.out.println(res);
        executor.shutdown();
        scheduledThreadPool.shutdown();
        executorService.shutdown();

        //synchronize list
        List<Integer> list =
                Collections.synchronizedList(
                        new ArrayList<>());

        list.add(10);
        Thread t1= new Thread(new DaemonThreadEx());
        t1.setDaemon(true);
        t1.start();

        //pool of single thread
        ExecutorService singleExecutorService = Executors.newSingleThreadExecutor();

    }
}
