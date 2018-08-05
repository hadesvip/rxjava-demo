package com.demo.future.service.future;

/**
 * 获取真实的数据
 *
 * @author wangyong
 */
public class RealData implements Data {

  private String result;

  public RealData(String param) {
    System.out.format("根据查询参数:%s,进行数据库操作，比较耗时...", param);
    try {
      Thread.sleep(5000);
      System.out.println("-----------------");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    result = "查询了5000条数据...";
  }

  @Override
  public String getResult() {
    return this.result;
  }
}
