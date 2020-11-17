package java_common.threadDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.threadDemo
 * @Author: xuzq11
 * @CreateTime: 2020-11-17 08:41
 * @Description: condition实现生产者消费者模式
 */
public class MyCondition {

    private static AtomicInteger count = new AtomicInteger(0);



    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Product product = new Product(condition, lock, count);
        product.start();
        Consumer consumer = new Consumer(condition, lock, count);
        consumer.start();
    }
}
