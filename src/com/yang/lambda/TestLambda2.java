package com.yang.lambda;

public class TestLambda2 {

    static class Love2 implements ILove{
        @Override
        public void love(int a) {
            System.out.println("I Love You--->" + a);
        }
    }

    public static void main(String[] args) {
        ILove love =  new Love();
        love.love(1);

        love = new Love2();
        love.love(2);

        class Love3 implements ILove{
            @Override
            public void love(int a) {
                System.out.println("I Love You--->" + a);
            }
        }
        love = new Love3();
        love.love(3);

        love = new ILove() {
            @Override
            public void love(int a) {
                System.out.println("I Love You--->" + a);
            }
        };
        love.love(4);


        love = (int a) -> {
            System.out.println("I Love You--->" + a);
        };
        love.love(520);
    }
}
interface ILove {
    void love (int a);
}

class Love implements ILove{

    @Override
    public void love(int a) {
        System.out.println("I Love You--->" + a);
    }
}
