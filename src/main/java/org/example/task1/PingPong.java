package org.example.task1;

public class PingPong {

    public static void main(String[] args) {
        PingPong pingPong = new PingPong();
        pingPong.start();
    }

    private void start() {
        Thread ping = new Thread(() -> {
            while (true){
                try {
                    printWord();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "ping");
        ping.start();

        Thread pong = new Thread(() -> {
            while (true){
                try {
                    printWord();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "pong");
        pong.start();
    }

    protected synchronized void printWord() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(2000);

        notify();
        wait();
    }
}