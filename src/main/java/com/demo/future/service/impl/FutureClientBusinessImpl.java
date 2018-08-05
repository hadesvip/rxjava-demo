package com.demo.future.service.impl;


import com.demo.future.service.FutureClientBusiness;
import com.demo.future.service.future.Data;
import com.demo.future.service.future.FutureData;
import com.demo.future.service.future.RealData;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangyong
 */
public class FutureClientBusinessImpl implements FutureClientBusiness {

  /**
   * 查询操作
   *
   * @param keyword 关键字
   */
  @Override
  public Data query(final String keyword) {
    final FutureData futureData = new FutureData();
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    executorService.execute(new Runnable() {
      @Override
      public void run() {
        RealData realData = new RealData(keyword);
        futureData.setRealData(realData);
      }
    });
    return futureData;
  }

  @Override
  public Integer calc(Integer num) {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    return num * num;
//    return num / 0;
  }
}
