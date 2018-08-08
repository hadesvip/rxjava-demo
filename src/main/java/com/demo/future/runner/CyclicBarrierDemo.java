package com.demo.future.runner;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 循环栅栏
 *
 * @author wangyong
 */
public class CyclicBarrierDemo {


  public static class Solider implements Runnable {

    private String solider;

    private final CyclicBarrier cyclicBarrier;

    public Solider(String solider, CyclicBarrier cyclicBarrier) {
      this.solider = solider;
      this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
      try {
        cyclicBarrier.await();
        doWork();
        cyclicBarrier.await();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (BrokenBarrierException e) {
        e.printStackTrace();
      }

    }


    void doWork() {
      try {
        Thread.sleep(Math.abs(new Random().nextInt() % 10000));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(solider + ":任务执行完成");
    }

  }


  public static class BarrierRun implements Runnable {

    boolean flag;
    int N;

    public BarrierRun(boolean flag, int n) {
      this.flag = flag;
      N = n;
    }

    @Override
    public void run() {
      if (flag) {
        System.out.println("司令:[士兵" + N + "个，任务完成！]");
      } else {
        System.out.println("司令:[士兵]" + N + "个集合完毕！");
        flag = true;
      }

    }
  }


  public static void main(String[] args) {

    final int N = 10;
    Thread[] threads = new Thread[N];
    boolean flag = false;
    CyclicBarrier cyclicBarrier = new CyclicBarrier(N, new BarrierRun(flag, N));
    System.out.println("集合队伍");
    for (int i = 0; i < N; i++) {
      System.out.println("士兵第" + i + "个来报道!");
      threads[i] = new Thread(new Solider("士兵" + i, cyclicBarrier));
      threads[i].start();
    }

  }

}
