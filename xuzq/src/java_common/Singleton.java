package java_common;

import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 双重校验锁实现对象单例（线程安全）
 */
public class Singleton {

    /**
     * volatile 关键字是必须的
     * uniqueInstance = new Singleton()分为三个步骤
     * 1. 为 uniqueInstance 分配内存空间
     * 2. 初始化 uniqueInstance
     * 3. 将 uniqueInstance 指向分配的内存地址
     * 但是由于 JVM 具有指令重排的特性，执行顺序有可能变成 1->3->2。指令重排在单线程环境下不会出现问题，但是在多线程环境下会导致一个线程获得还没有初始化的实例。例如，线程 T1 执行了 1 和 3，此时 T2 调用 getUniqueInstance() 后发现 uniqueInstance 不为空，因此返回 uniqueInstance，但此时 uniqueInstance 还未被初始化。
     *
     * 使用 volatile 可以禁止 JVM 的指令重排，保证在多线程环境下也能正常运行。
     */
    private static volatile Singleton uniqueInstance;

    public static Singleton getInstance(){
        //判断对象是否已经实例过
        if (uniqueInstance == null){
            synchronized (Singleton.class){
                if (uniqueInstance == null)
                    uniqueInstance = new Singleton();
            }
        }
        return uniqueInstance;
    }

    @Test
    public void test(){
        String s = "2大1小";
        String regex = "(\\d+)大(\\d+)小";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        matcher.find();
        int[] a = {1,2,3};

        System.out.println(matcher.group(1) + " " + matcher.group(2));
    }
}
