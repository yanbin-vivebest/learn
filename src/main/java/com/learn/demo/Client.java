package com.learn.demo;

public class Client {
    public static void main(String[] args) {
        Service s = new Service();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Service.go5();
            }
        }).start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                Service.go6();
            }
        }).start();
    }
}
