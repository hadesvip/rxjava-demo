package com.demo.future.runner;

import com.demo.future.service.FutureClientBusiness;
import com.demo.future.service.impl.FutureClientBusinessImpl;
import com.demo.future.service.task.CalcTask;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangyong
 */
public class CompletableFutureRunner {

  public static void main(String[] args) throws ExecutionException, InterruptedException {

    //经典方式
//    final CompletableFuture<Integer> future = new CompletableFuture<>();
//    new Thread(new CalcTask(future)).start();
//    try {
//      Thread.sleep(1000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//
//    future.complete(60);

    //异步方式
    FutureClientBusiness futureClientBusiness = new FutureClientBusinessImpl();
//    CompletableFuture<Integer> future = CompletableFuture
//        .supplyAsync(() -> futureClientBusiness.calc(50));
//
//    System.out.println("执行其他业务逻辑....");
//    System.out.println(future.get());



//    CompletableFuture<Void> future = CompletableFuture
//        .supplyAsync(() -> futureClientBusiness.calc(50))
//        .whenComplete((v, e) -> {
//          try {
//            Thread.sleep(2000);
//          } catch (InterruptedException e1) {
//            e1.printStackTrace();
//          }
//        })
//        .exceptionally(ex -> {
//          System.out.println(ex.toString());
//          return 0;
//        })
//        .thenApply(i -> Integer.toString(i))
//        .thenApply(str -> "计算结果数据:" + str)
//        .thenAccept(System.out::println);
//
//
//    System.out.println("执行其他业务1");
//    future.get();
//    System.out.println("执行其他业务2");

    ExecutorService executorService = Executors.newFixedThreadPool(1);

    CompletableFuture<Void> future = CompletableFuture
        .supplyAsync(() -> futureClientBusiness.calc(50), executorService)
        .whenComplete((v, e) -> {
          System.out.println("开始执行...");
          try {
            Thread.sleep(10000);
          } catch (InterruptedException e1) {
            e1.printStackTrace();
          }
        })
        .exceptionally(ex -> {
          System.out.println(ex.toString());
          return 0;
        })
        .thenApply(i -> Integer.toString(i))
        .thenApply(str -> "计算结果数据:" + str)
        .thenAccept(System.out::println);

    executorService.shutdown();
    System.out.println("执行其他业务1");
//    future.get();
    System.out.println("执行其他业务2");
    while (true) {
      //.....
    }
  }
}
