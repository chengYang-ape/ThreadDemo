package com.yang.demo01;

//多个线程同时操作同一个对象，买火车票的例子
public class TestThread4 implements Runnable {
    private int ticketNums = 10;

    @Override
    public void run() {
        while (true){
            if (ticketNums <= 0){
                break;
            }
            System.out.println(Thread.currentThread().getName() + "--->拿到了第" + ticketNums-- + "张票");
        }
    }
    public static void main(String[] args) {
        TestThread4 testThread4 = new TestThread4();
        new Thread(testThread4,"小明").start();
        new Thread(testThread4,"老师").start();
        new Thread(testThread4,"黄牛").start();
    }
}
