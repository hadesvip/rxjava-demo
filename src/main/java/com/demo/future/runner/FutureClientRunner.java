package com.demo.future.runner;

import com.demo.future.service.FutureClientBusiness;
import com.demo.future.service.future.Data;
import com.demo.future.service.impl.FutureClientBusinessImpl;

/**
 * future 模式
 *
 * @author wangyong
 */
public class FutureClientRunner {

  public static void main(String[] args) {
    FutureClientBusiness futureClientBusiness = new FutureClientBusinessImpl();
    Data queryData = futureClientBusiness.query("query");
    System.out.println("执行其他业务性操作...");
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    String result = queryData.getResult();
    System.out.println("真实的处理数据-->" + result);
  }
}
