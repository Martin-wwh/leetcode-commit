package java_common.threadlocal;

import java.util.Date;

public class MyThread implements Runnable {

    private String command;

    public MyThread(){};

    public MyThread(String command){
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start time : " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " end time : " + new Date());
    }

    public void processCommand(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
