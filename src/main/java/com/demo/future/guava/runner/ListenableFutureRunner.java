package com.demo.future.guava.runner;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.sql.Time;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.omg.CORBA.TIMEOUT;

/**
 * @author wangyong
 */
public class ListenableFutureRunner {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
//    Future<Integer> future = executorService.submit(new Callable<Integer>() {
//      @Override
//      public Integer call() throws Exception {
//
//        try {
//          TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//          e.printStackTrace();
//        }
//
//        return 5;
//      }

//      @Override
//      public void run() {
//        try {
//          TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//          e.printStackTrace();
//        }
//      }

//    });

    //需要主动获取，堵塞着，弊端
//    Object result = future.get();
//    System.out.println(result);

    ListeningExecutorService listeningExecutorService = MoreExecutors
        .listeningDecorator(executorService);

//    ListenableFuture<?> listenableFuture = listeningExecutorService.submit(new Runnable() {
//      @Override
//      public void run() {
//        try {
//          System.out.println("执行业务...");
//          TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//          e.printStackTrace();
//        }
//
//      }
//    });
//
//    listenableFuture.addListener(new Runnable() {
//      @Override
//      public void run() {
//        System.out.println("完成任务");
//      }
//    }, executorService);

//    ListenableFuture<Integer> future = listeningExecutorService.submit(new Callable<Integer>() {
//      @Override
//      public Integer call() throws Exception {
//        System.out.println("执行异步任务...");
//        TimeUnit.SECONDS.sleep(5);
//        return 101;
//      }
//    });
//
//    System.out.println("执行其他业务...");
//
//    Futures.addCallback(future, new CallBackHandler(), executorService);

    //java8
    CompletableFuture<Integer> completableFuture = CompletableFuture
        .supplyAsync(() -> {
          try {
            System.out.println("执行异步任务...");
            TimeUnit.SECONDS.sleep(6);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          return 10;
        }, executorService);

    completableFuture.whenComplete((v, t) -> System.out.println("异步任务执行结束，结果:" + v));

  }


  /**
   * 回调处理类
   *
   * @author wangyong
   */
  static class CallBackHandler implements FutureCallback<Integer> {


    /**
     * 执行异步操作成功后得操作
     */
    @Override
    public void onSuccess(@Nullable Integer result) {

      System.out.println("success:" + result);


    }

    @Override
    public void onFailure(Throwable t) {
      t.printStackTrace();
    }


  }


}
