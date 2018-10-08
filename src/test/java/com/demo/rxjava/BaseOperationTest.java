package com.demo.rxjava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import org.junit.Test;

/**
 * 基本操作
 *
 * @author: wangyong
 * @date: 2018/10/8 22:21
 */
public class BaseOperationTest {

  @Test
  public void ObservableTest() {
    Observable.just("hello,rxjava...").subscribe(
        new Consumer<String>() {
          @Override
          public void accept(String str) throws Exception {
            System.out.println(str);
            //throw new NullPointerException("空指针");
          }
        },
        //出现异常执行
        new Consumer<Throwable>() {
          @Override
          public void accept(Throwable throwable) throws Exception {
            System.out.println(throwable.getMessage());
          }
        },
        //正常结束，最后执行
        new Action() {
          @Override
          public void run() throws Exception {
            System.out.println("complete...");
          }
        },
        //优先执行
        new Consumer<Disposable>() {
          @Override
          public void accept(Disposable disposable) throws Exception {
            System.out.println("subscribe");
          }
        }
    );
  }

  @Test
  public void ObserverTest() {
    Observable.just("hello,RxJava...").subscribe(new Observer<String>() {
      @Override
      public void onSubscribe(Disposable d) {
        System.out.println("subscribe...");
      }

      @Override
      public void onNext(String str) {
        System.out.println(str);
      }

      @Override
      public void onError(Throwable e) {
        System.out.println(e.getMessage());
      }

      @Override
      public void onComplete() {
        System.out.println("complete");
      }
    });
  }


}
