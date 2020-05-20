package com.yang.state;


//模拟网络延时
public class TestSleep implements Runnable{
    private int ticketNums = 10;

    @Override
    public void run() {
        while (true){
            if (ticketNums <= 0){
                break;
            }
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--->拿到了第" + ticketNums-- + "张票");
        }
    }
    public static void main(String[] args) {
        TestSleep testSleep = new TestSleep();
        new Thread(testSleep,"小明").start();
        new Thread(testSleep,"老师").start();
        new Thread(testSleep,"黄牛").start();
    }
}
