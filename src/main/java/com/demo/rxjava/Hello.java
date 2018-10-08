package com.demo.rxjava;

import com.sun.istack.internal.NotNull;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;

/**
 * RxJava入门示例
 *
 * @author: wangyong
 * @date: 2018/10/5 23:46
 */
public class Hello {

  public static void main(String[] args) {
    Observable.create(new ObservableOnSubscribe<String>() {
      @Override
      public void subscribe(@NotNull ObservableEmitter<String> emitter) throws Exception {
        emitter.onNext("Hello world");

      }
    }).subscribe(new Consumer<String>() {
      @Override
      public void accept(@NotNull String str) throws Exception {
        System.out.println(str);
      }
    });

    Observable.just("Hello world").subscribe(new Consumer<String>() {
      @Override
      public void accept(String str) throws Exception {
        System.out.println(str);
      }
    });

    Observable.just("Hello,world!").subscribe(System.out::println);

  }

}
