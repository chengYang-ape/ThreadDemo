package com.yang.syn;


//不安全的买票,运行之后有负数
//同步之后
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();
        new Thread(station,"wo").start();
        new Thread(station,"ni").start();
        new Thread(station,"牛牛").start();
    }
}
class BuyTicket implements Runnable{
    //定义票
    private int ticketNums = 10;
    boolean flag = true;

    @Override
    public void run() {
        //买票
        while(flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //synchronized 同步方法
    private synchronized void buy() throws InterruptedException {
        //判断是否有票
        if (ticketNums <= 0){
            flag = false;
            return;
        }
        //模拟延时
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName() + "拿到第" + ticketNums-- + "张票");
    }
}