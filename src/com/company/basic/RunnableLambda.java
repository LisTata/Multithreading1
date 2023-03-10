package com.company.basic;

public class RunnableLambda {
    public static void main(String[] args) {
        System.out.println("Thread : " + Thread.currentThread().getName());
        System.out.println("Creating Runnable...");
        Runnable runnable = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Thread : " + Thread.currentThread().getName() + " is running...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Finish:" + Thread.currentThread().getName());

        };
        System.out.println("Creating Thread...");
        Thread thread = new Thread(runnable);

        System.out.println("Starting Thread...");
        thread.start();
        //Finish child thread
        try {
            thread.join();//Дождаться завершения другого потока
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finish:" + Thread.currentThread().getName());

    }
}


