package com.yang.state;


//测试守护线程，上帝守护你的举例
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        thread.setDaemon(true);  //默认是false 是用户线程

        thread.start();//开启上帝守护线程

        new Thread(you).start();  //用户线程启动
    }
}
//上帝
class God implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("上帝保佑着你");
        }
    }
}
//你
class You implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("希望你一生都开心的活着");
        }
        System.out.println("======goodbye! world======");
    }
}