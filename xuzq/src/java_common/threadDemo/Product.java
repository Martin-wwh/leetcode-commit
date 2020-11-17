package java_common.threadDemo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.threadDemo
 * @Author: xuzq11
 * @CreateTime: 2020-11-17 09:08
 * @Description:
 */
public class Product extends Thread {

    Condition condition;
    ReentrantLock lock;
    AtomicInteger count;

    public Product(Condition condition, ReentrantLock lock, AtomicInteger count) {
        this.condition = condition;
        this.lock = lock;
        this.count = count;
    }

    @Override
    public void run() {
        while(true){
            try {
                lock.lock();
                if (count.get() == 0){
                    condition.await();
                }
                System.out.println("消费信息。。。" + count.get());
                count.addAndGet(-1);
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
