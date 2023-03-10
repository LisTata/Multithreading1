package com.company.basic;

public class RunnableDemo2 {
    public static void main(String[] args) {
       System.out.println("Thread : " + Thread.currentThread().getName());

        System.out.println("Creating Runnable...");
        Thread thread=(new Thread(new RunnableBasic2()));
        thread.start();
        System.out.println("Creating Thread...");
        Thread thread2 = new Thread(new RunnableBasic2());
        System.out.println("Starting Thread...");
        thread2.start();
        //Finish child thread
        try {
            thread.join();//Дождаться завершения другого потока
           thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finish:" + Thread.currentThread().getName());

    }

}

class RunnableBasic2 implements Runnable{

    @Override
    public void run() {
        for (int i=0; i<3; i++) {
            System.out.println("Thread : " + Thread.currentThread().getName() + " is running...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finish:" + Thread.currentThread().getName());

    }
}
