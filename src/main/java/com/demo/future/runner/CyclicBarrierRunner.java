package com.demo.future.runner;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 循环栅栏
 *
 * @author wangyong
 */
public class CyclicBarrierRunner {

  public static void main(String[] args) {
    CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
      @Override
      public void run() {
        System.out.println("所有线程都准备就绪了...");
      }
    });

    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {

        try {
          Thread.sleep(2000);
          cyclicBarrier.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        } catch (BrokenBarrierException e) {
          e.printStackTrace();
        }

        System.out.println("t1准备就绪");
      }
    });

    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {

        try {
          Thread.sleep(2000);
          cyclicBarrier.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        } catch (BrokenBarrierException e) {
          e.printStackTrace();
        }

        System.out.println("t2准备就绪");
      }
    });

    Thread t3 = new Thread(new Runnable() {
      @Override
      public void run() {

        try {
          Thread.sleep(2000);
          cyclicBarrier.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        } catch (BrokenBarrierException e) {
          e.printStackTrace();
        }

        System.out.println("t3准备就绪");
      }
    });

    t1.start();
    t2.start();
    t3.start();

    System.out.println("一起执行....");




  }

}
