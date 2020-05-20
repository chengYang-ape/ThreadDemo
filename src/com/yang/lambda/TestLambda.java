package com.yang.lambda;

/**
 * 推导lambda表达式
 */
public class TestLambda {

    //3.静态内部类
    static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("I Like Lambda2");
        }
    }
    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();

        //4.局部内部类
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("I Like Lambda3");
            }
        }

        like = new Like3();
        like.lambda();

        //5.匿名内部类,没有类的名称必须借助接口或者父类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("i like lambda4");
            }
        };
        like.lambda();

        //用lambda简化
        like = () -> {
            System.out.println("i like lambda5");
        };
        like.lambda();
    }
}

//1.定义一个函数是接口
interface ILike{
    void lambda();
}

//2.实现类
class Like implements ILike{
    @Override
    public void lambda() {
        System.out.println("I Like Lambda");
    }
}