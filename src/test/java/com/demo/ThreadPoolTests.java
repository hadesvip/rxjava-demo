package com.demo;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class ThreadPoolTests {


  @Test
  public void poolTest() {

    ExecutorService executorService = new ThreadPoolExecutor(20, 50, 60l, TimeUnit.SECONDS,
        new LinkedBlockingQueue<Runnable>());

//    executorService.
  }


  @Test
  public void forkJoinTest() {

    int cpuNums = Runtime.getRuntime().availableProcessors();



    ForkJoinPool forkJoinPool = new ForkJoinPool();

    System.out.println(forkJoinPool.getActiveThreadCount());


  }


}
