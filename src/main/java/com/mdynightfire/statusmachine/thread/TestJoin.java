package com.mdynightfire.statusmachine.thread;

/**
 * @ClassName ThreadTest
 * @Description TODO
 * @Author deyin.mdy
 * @Date 2020/5/17 6:22 下午
 */
public class TestJoin {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        ThreadTest t1=new ThreadTest("A");
        ThreadTest t2=new ThreadTest("B");
        t1.start();
        t1.join();
        t2.start();
    }


}
class ThreadTest extends Thread {
    private String name;
    public ThreadTest(String name){
        this.name=name;
    }
    public void run(){
        for(int i=1;i<=5;i++){
            System.out.println(name+"-"+i);
        }
    }
}
