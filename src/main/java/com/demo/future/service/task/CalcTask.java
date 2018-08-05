package com.demo.future.service.task;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author wangyong
 */
public class CalcTask implements Runnable {

  CompletableFuture<Integer> completableFuture;

  public CalcTask(CompletableFuture<Integer> completableFuture) {
    this.completableFuture = completableFuture;
  }

  @Override
  public void run() {
    int result = 0;
    try {
      result = completableFuture.get() * completableFuture.get();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
    System.out.println("计算结果:" + result);
  }
}
