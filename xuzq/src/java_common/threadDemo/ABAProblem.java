package java_common.threadDemo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * ABA 问题
 * 在CAS情况下可能会出现值被修改了过后，又被修改回来的情况，譬如链表记录的节点，金额花费等等，这种情况下问题并非未发生改变
 * AtomicStampedReference<T>可以避免这个问题
 */
public class ABAProblem {

    private static AtomicInteger atomicInteger = new AtomicInteger(100);
    private static AtomicStampedReference<Integer> atomicReference = new AtomicStampedReference<>(100,0);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(
                () -> {
                    atomicInteger.compareAndSet(100, 101);
                    atomicInteger.compareAndSet(101,100);
                }
        );

        Thread t2 = new Thread(
                () -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    boolean casResult = atomicInteger.compareAndSet(100,101);
                    System.out.println("AtomicInteger ABA CAS result : " + casResult);
                }
        );

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        Thread t3 = new Thread(
                () -> {
                    atomicReference.compareAndSet(100,101, atomicReference.getStamp(), atomicReference.getReference()+1);
                    atomicReference.compareAndSet(101,100, atomicReference.getStamp(), atomicReference.getReference()+1);
                }
        );

        Thread t4 = new Thread(
                () -> {
                    int stamp = atomicReference.getStamp();
                    System.out.println("before sleep stamp is : " + stamp);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    boolean casResult = atomicReference.compareAndSet(100,101, stamp, stamp+1);
                    System.out.println("AtomicStampReference ABA CAS result : " + casResult);
                }
        );

        t3.start();
        t4.start();
    }
}
