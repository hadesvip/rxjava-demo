package com.demo.future.runner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangyong
 */
public class CountDownLatchRunner {

  public static void main(String[] args) throws InterruptedException {

//    CountDownLatch countDownLatch = new CountDownLatch(2);
//
//
//    Thread t1 = new Thread(new Runnable() {
//      @Override
//      public void run() {
//        try {
//          System.out.println("t1线程开始初始化...");
//          Thread.sleep(2000);
//          countDownLatch.countDown();
//          System.out.println("t1线程初始化完成..");
//        } catch (InterruptedException e) {
//          e.printStackTrace();
//        }
//      }
//    });
//
//    Thread t2 = new Thread(new Runnable() {
//      @Override
//      public void run() {
//        try {
//          System.out.println("t2线程开始初始化...");
//          countDownLatch.await();
//          System.out.println("t2线程初始化完成..");
//        } catch (InterruptedException e) {
//          e.printStackTrace();
//        }
//      }
//    });
//
//    Thread t3 = new Thread(new Runnable() {
//      @Override
//      public void run() {
//        try {
//          System.out.println("t3线程开始初始化...");
//          Thread.sleep(2000);
//          countDownLatch.countDown();
//          System.out.println("t3线程初始化完成..");
//        } catch (Exception e) {
//          e.printStackTrace();
//        }
//      }
//    });
//
//    t1.start();
//    t2.start();
//    t3.start();

    CountDownLatch countDownLatch = new CountDownLatch(5);

    ExecutorService executorService = Executors.newFixedThreadPool(5);

    for (int i = 0; i < 5; i++) {
      executorService.submit(new Runnable() {
        @Override
        public void run() {
          try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + "-->任务执行完成");
            countDownLatch.countDown();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      });
    }

    countDownLatch.await();
    System.out.println("任务即将执行完成，开始执行下面对应的业务处理...");
    executorService.shutdown();
  }
}
