package com.demo.future.service.handler;

import java.util.concurrent.Callable;

/**
 * @author wangyong
 */
public class FutureHandler implements Callable<String> {


  private String param;

  public FutureHandler(String param) {
    this.param = param;
  }

  /**
   * 异步回调
   */
  @Override
  public String call() throws Exception {
    Thread.sleep(3000);
    return this.param + ",处理完成。" + Thread.currentThread().getId();
  }
}
