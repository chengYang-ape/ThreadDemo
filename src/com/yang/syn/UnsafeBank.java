package com.yang.syn;

//不安全的取钱
public class UnsafeBank {

    public static void main(String[] args) {
        Account account = new Account(1000,"结婚基金");
        Drawing you = new Drawing(account,50,"你");
        Drawing girl = new Drawing(account,800,"girl");
        you.start();
        girl.start();
    }
}
//账户
class Account{
    int money;  //余额
    String name;  //卡名

    public Account(int money, String name){
        this.money = money;
        this.name = name;
    }
}
//银行：模拟取款
class Drawing extends Thread{
    Account account;//账户
    int drawingMoney;  //取了多少钱
    int nowMoney;   //手里多少钱

    public Drawing (Account account,int drawingMoney,String name){
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        synchronized (account){
            //判断有没有钱
            if (account.money - drawingMoney < 0){
                System.out.println(Thread.currentThread().getName() + "钱不够，取不了");
                return;
            }
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //卡内余额 = 余额  - 你取的钱
            account.money = account.money - drawingMoney;
            nowMoney = nowMoney + drawingMoney;

            System.out.println(account.name + "余额为" + account.money);
            //this.getName() = Thread.currentThread().getName()
            System.out.println(this.getName() + "手里的钱" + nowMoney);
        }

    }
}