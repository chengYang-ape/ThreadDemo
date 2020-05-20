package com.yang.lambda;

//lambda再简化
public class TestLambda3 {
    public static void main(String[] args) {
        Luck luck = null;

        //1.lambda表达式
        luck = (int a) -> {
            System.out.println("我的幸运数字是---->" + a);
        };
        luck.lick(888);

        //2.去参数类型
        luck = (a) -> {
            System.out.println("我的幸运数字是---->" + a);
        };
        luck.lick(520);

        //3.去参数的括号
        luck = a -> {
            System.out.println("我的幸运数字是---->" + a);
        };
        luck.lick(521);

        //4.去掉花括号
        luck = a -> System.out.println("我的幸运数字是---->" + a);
        luck.lick(250);
    }
}

interface  Luck{
    void lick(int a);
}
