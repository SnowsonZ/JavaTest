package com.snowson.practice.thread.test;

import com.snowson.practice.thread.ReturnRunnable;
import com.snowson.practice.thread.ReturnThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * author: SnowsonZ
 * created on: 2018/5/9 7:27
 * description:
 * Callable<V> == Runnable + return
 * Future == 获取callable的返回结果
 * 当FutureTask处于未启动状态时，执行FutureTask.cancel()方法将导致此任务永远不会执行。
 */

public class ReturnThreadTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ReturnThread rt = new ReturnThread();
        ExecutorService es = Executors.newCachedThreadPool();
        Future<String> result = es.submit(rt);
        String content = result.get();
        System.out.println(content);

        Future<?> fu = es.submit(new ReturnRunnable());
        Object o = fu.get();
        System.out.println(o == null);

        //FutureTask
        FutureTask<String> ft = new FutureTask<String>(new ReturnRunnable(), "return of Runnable");
//        FutureTask<String> ft = new FutureTask<String>(new ReturnThread());
//        Future<?> submit = es.submit(ft);
//        System.out.println(ft.cancel(true));
//        System.out.println("isCancelled: " + ft.isCancelled());
//        System.out.println(ft.get());
//        String s = ft.get();
//        System.out.println("content execute before: " + s);
//        boolean c1 = ft.cancel(true);
//        System.out.println("cancel before: " + c1);
        boolean c2 = ft.isCancelled();
        System.out.println("isCanceled before: " + c2);
        boolean c3 = ft.isDone();
        System.out.println("isDone before: " + c3);
        Future<?> returnVal = es.submit(ft);
//        boolean c11 = ft.cancel(true);
//        System.out.println("cancel execute after: " + c11);
        Object returnObj = ft.get();
        System.out.println("get execute after: " + returnObj);
        boolean c10 = ft.isDone();
        System.out.println("isDone execute after: " + c10);
        es.shutdown();
    }
}
