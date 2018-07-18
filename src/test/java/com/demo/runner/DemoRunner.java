package com.demo.runner;

public class DemoRunner implements Runnable {

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getId() + ":" + Thread.currentThread().getName());
  }
}
