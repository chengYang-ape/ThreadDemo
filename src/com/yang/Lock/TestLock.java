package com.yang.Lock;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        TestLock2 t1 = new TestLock2();
        new Thread(t1).start();
        new Thread(t1).start();
        new Thread(t1).start();
    }
}
class TestLock2 implements Runnable{
    int ticketNums = 10;

    //定义可重复锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try{
                lock.lock();//加锁
                if (ticketNums > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() +" 取到 "+ ticketNums-- );
                }else {
                    break;
                }
            }finally {
                //解锁
                lock.unlock();
            }

        }

    }
}
