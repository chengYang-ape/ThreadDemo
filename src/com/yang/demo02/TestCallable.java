package com.yang.demo02;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;


//线程创建方式三：实现Callable接口。
public class TestCallable implements Callable<Boolean> {
    private String url;  //图片地址
    private String name;   //保存的文件名

    public TestCallable(String url,String name){
        this.url = url;
        this.name = name;
    }
    @Override
    public Boolean call() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为：" + name);
        return true;
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://img-blog.csdnimg.cn/20200517131520779.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzQxNzI1Mg==,size_16,color_FFFFFF,t_70","1.jpg");
        TestCallable t2 = new TestCallable("https://img-blog.csdnimg.cn/20200517131520779.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzQxNzI1Mg==,size_16,color_FFFFFF,t_70","2.jpg");
        TestCallable t3 = new TestCallable("https://img-blog.csdnimg.cn/20200517131520779.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzQxNzI1Mg==,size_16,color_FFFFFF,t_70","3.jpg");

        //创建执行服务：
        ExecutorService ser = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);

        //获取结果：
        boolean rs1 = r1.get();
        boolean rs2 = r2.get();
        boolean rs3 = r3.get();

        //关闭服务
        ser.shutdownNow();

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

