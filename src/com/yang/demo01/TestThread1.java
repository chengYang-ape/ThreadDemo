package com.yang.demo01;

//创建线程方式一：继承Thread类，重写run方法。
public class TestThread1 extends Thread{
    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码---" + i);
        }
    }
    public static void main(String[] args) {
        //main线程，主线程
        //创建一个线程，调用start方法。
        TestThread1 testThread1 = new TestThread1();
        //testThread1.run();
        testThread1.start();
        for (int i = 0; i < 2000; i++) {
            System.out.println("我在学习多线程--" + i);
        }

    }
}
