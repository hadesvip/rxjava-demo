package com.demo.future.service.future;

/**
 * 包装数据
 *
 * @author wangyong
 */
public class FutureData implements Data {

  /**
   * 真实数据
   */
  private RealData realData;

  /**
   * 处理状态
   */
  private boolean ready;

  /**
   * 堵塞直到真实数据组装完成
   */
  @Override
  public synchronized String getResult() {
    while (!ready) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    return this.realData.getResult();
  }

  /**
   * 设置真实的数据
   */
  public synchronized void setRealData(RealData realData) {
    if (ready) {
      return;
    }
    this.realData = realData;
    ready = true;
    notify();
  }
}
       