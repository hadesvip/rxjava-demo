package com.demo.future.runner;

import com.demo.future.service.handler.FutureHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 多线程future测试
 * future以空间换时间
 * @author wangyong
 *
 */
public class FutureRunner {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    FutureTask<String> searchFutureTask = new FutureTask<>(new FutureHandler("执行查询"));
    FutureTask<String> insertFutureTask = new FutureTask<>(new FutureHandler("执行插入"));

    ExecutorService executorService = Executors.newFixedThreadPool(1);
    executorService.submit(searchFutureTask);
    executorService.submit(insertFutureTask);

    System.out.println("处理其他相关任务...");
    Thread.sleep(2000);

    //堵塞完成
    String searchResult = searchFutureTask.get();
    String insertResult = insertFutureTask.get();

    System.out.println("执行查询任务完成->" + searchResult);
    System.out.println("执行插入任务完成->" + insertResult);
  }

}
