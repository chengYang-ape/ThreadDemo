package com.yang.demo01;

    import org.apache.commons.io.FileUtils;

    import java.io.File;
    import java.io.IOException;
    import java.net.URL;

    //练习Thread，实现多线程同步下载图片。
    public class TestThread2 extends Thread{
        private String url;  //图片地址
        private String name;   //保存的文件名

        public TestThread2(String url,String name){
            this.url = url;
            this.name = name;
        }
        @Override
        public void run() {
            WebDownloader webDownloader = new WebDownloader();
            webDownloader.downloader(url,name);
            System.out.println("下载了文件名为：" + name);
        }
        public static void main(String[] args) {
            TestThread2 t1 = new TestThread2("https://img-blog.csdnimg.cn/20200517131520779.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzQxNzI1Mg==,size_16,color_FFFFFF,t_70","1.jpg");
            TestThread2 t2 = new TestThread2("https://img-blog.csdnimg.cn/20200517131520779.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzQxNzI1Mg==,size_16,color_FFFFFF,t_70","2.jpg");
            TestThread2 t3 = new TestThread2("https://img-blog.csdnimg.cn/20200517131520779.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzQxNzI1Mg==,size_16,color_FFFFFF,t_70","3.jpg");
            t1.start();
            t2.start();
            t3.start();
        }
    }
    class WebDownloader{
        public void downloader(String url,String name){
            try {
                FileUtils.copyURLToFile(new URL(url),new File(name));
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("IO异常，downloader方法出现问题");
            }
        }
    }