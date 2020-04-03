package com.learn.demo;

public class Service {


    public static Object obj = new Object();
    public static Object obj2 = new Object();
    public Object obj3 = new Object();
    /**
     * 对象锁 和go2共享
     */
    public synchronized void go1(){
        try {
            System.out.println("go进入等待！");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("go1");
    }

    /**
     * 对象锁  和go1共享
     */
    public synchronized void go2(){
        System.out.println("go2");
    }

    /**
     * 类锁  和go4共享
     */
    public static synchronized void go3(){
        try {
            System.out.println("go3进入等待！");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("go3");
    }

    /**
     * 类锁  和go3共享
     */
    public static synchronized void go4(){
        System.out.println("go4");
    }


    /**
     * 5,6共享
     */
    public static void go5(){
        synchronized (obj) {
            try {
                System.out.println("go5进入等待！");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("go5");
        }
    }

    /**
     * 5,6共享
     */
    public static void go6(){
        synchronized (obj) {
            System.out.println("go6");
        }
    }

    /**
     * 类的静态变量锁 7,8共享
     */
    public  synchronized void go7(){
        synchronized (obj2) {
            try {
                System.out.println("go7进入等待！");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("go7");
        }
    }

    /**
     * 类的静态变量锁 7,8共享
     */
    public  synchronized void go8(){
        synchronized (obj2) {
            System.out.println("go8");
        }
    }


    /**
     * 9,10共享
     */
    public void go9(){
        synchronized (obj3) {
            try {
                System.out.println("go9进入等待！");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("go9");
        }
    }
    /**
     * 9,10共享
     */
    public void go10(){
        synchronized (obj3) {
            System.out.println("go10");
        }
    }


    /**
     * 11,12共享
     */
    public synchronized void go11(){
        try {
            System.out.println("go11进入等待！");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("go11");
    }

    /**
     * 11,12共享
     */
    public void go12(){
        synchronized (this) {
            System.out.println("go12");
        }
    }

}
