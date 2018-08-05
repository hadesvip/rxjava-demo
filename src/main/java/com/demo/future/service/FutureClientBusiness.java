package com.demo.future.service;

import com.demo.future.service.future.Data;

/**
 * @author wangyong
 */
public interface FutureClientBusiness {


  /**
   * 查询操作
   *
   * @param keyword 关键字
   * @return 数据对象
   */
  Data query(String keyword);


  /**
   * 计算
   */
  Integer calc(Integer num);
}
