package com.yang.state;


//测试停止线程
//1.建议线程正常停止--->利用次数，不建议死循环
//2.建议使用标志位--->设置一个标识位
//3.不要使用stop、destroy或者JDK不建议的方法
public class TestThreadStop implements Runnable{
    //1.设置一个标识为
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag){
            System.out.println("run....Thread" + i++);
        }
    }

    //2.设置一个公开的方法停止线程，转换标识位
    public void stop(){
        this.flag = false;
    }

    public static void main(String[] args) {
        TestThreadStop testThreadStop = new TestThreadStop();
        new Thread(testThreadStop).start();

        for (int i = 0; i < 2000; i++) {
            System.out.println("main..." + i);
            if (i == 800){
                //3.调用stop方法。
                testThreadStop.stop();
                System.out.println("线程该停止了");
            }
        }
    }
}
