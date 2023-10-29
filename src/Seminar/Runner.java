package Seminar;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Runner extends Thread{

    private String name;
    private double speed;
    private Random random;
    private CountDownLatch cdl;

    public Runner(String name, CountDownLatch cdl){
        this.name = name;
        this.cdl = cdl;
        random = new Random();
        speed = random.nextDouble(2, 7);
    }

    @Override
    public void run() {
        try {
            goOnStart();            //отправляем на страт
            synchronized (this){    //ждём всех (спим, пока не разбудят) метод go - это его пробуждение
                wait();
            }
            goOnFinish();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    public void goOnStart() throws InterruptedException{
        System.out.println(name + ": идёт на старт");
        sleep(random.nextInt(2, 5) * 1000L); //пришёл на старт и ждёт остальных
        System.out.println(name + ": пришёл на старт");
        cdl.countDown();    //уменьшили счётчик на 1
    }

    public void goOnFinish() throws InterruptedException{
        sleep((long) (speed * 1000)); //пришёл на старт и ждёт остальных
        System.out.println(name + ": добежал до финиша");
        cdl.countDown();    //уменьшили счётчик на 1
    }

    public void go(){
        synchronized (this){
            notify();
        }
    }
}
