package com.yang.syn;


//多个线程互相抱着对方需要的资源，形成死锁。
public class DeadLock {
    public static void main(String[] args) {
        Makeup g1 = new Makeup(0,"小红帽");
        Makeup g2 = new Makeup(1,"灰姑娘");
        g1.start();
        g2.start();
    }
}
//口红
class Lipstick{
}
//镜子
class Mirror{
}

class Makeup extends Thread{

    //需要的资源只有一份，用static保证只有一份
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice; //选择
    String girlName; //使用者的名字

    Makeup(int choice,String girlName){
        this.choice = choice;
        this.girlName = girlName;

    }
    @Override
    public void run() {
        //化妆
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //化妆，互相持有对方的锁，需要拿到对方的资源
    private void makeup() throws InterruptedException {
        if (choice ==0){
            synchronized (lipstick){  //获得口红的锁
                System.out.println(this.girlName + "获得口红的锁");
                Thread.sleep(1000);
                }
            synchronized (mirror){   //想要一秒后获得镜子的锁
                System.out.println(this.girlName + "获得镜子的锁");
            }
        }else {
            synchronized (mirror){  //获得镜子的锁
                System.out.println(this.girlName + "获得镜子的锁");
                Thread.sleep(2000);
                }
            synchronized (lipstick){   //想要一秒后获得镜子的锁
                System.out.println(this.girlName + "获得口红的锁");
            }
        }
    }
}