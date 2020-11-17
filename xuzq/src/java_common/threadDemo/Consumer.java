package java_common.threadDemo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.threadDemo
 * @Author: xuzq11
 * @CreateTime: 2020-11-17 09:10
 * @Description:
 */
public class Consumer extends Thread {

    Condition condition;
    ReentrantLock lock;
    AtomicInteger count;

    public Consumer(Condition condition, ReentrantLock lock, AtomicInteger count) {
        this.condition = condition;
        this.lock = lock;
        this.count = count;
    }

    @Override
    public void run() {
        while(true){
            try {
                lock.lock();
                if (count.get() >= 10){
                    condition.await();
                }
                System.out.println("生产信息。。。" + count.get());
                count.incrementAndGet();
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
