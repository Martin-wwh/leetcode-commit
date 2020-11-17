package java_common.threadDemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownDemo {

    private static final int threadCount = 550;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(300);
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i=0; i<threadCount; i++){
            final int threadNum = i;
            threadPool.execute( () -> {
                try {
                    test(threadNum);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        threadPool.shutdown();
        System.out.println("all thread finished");
    }

    //模拟耗时操作
    public static void test(int threadNum) throws InterruptedException {
        Thread.sleep(500);
        System.out.println("ThreadNum: " + threadNum);
        Thread.sleep(500);
    }
}
