package Seminar;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Race extends Thread{

    private List<Runner> runners;
    private CountDownLatch cdl; //счётчик действий

    public Race(){
        cdl = new CountDownLatch(3);    //ждём 3 действия т.к. три участника 3..2..1... счётчик по действиям

        runners = new ArrayList<>(3);

        runners.add(new Runner("Tom", cdl));
        runners.add(new Runner("Helen", cdl));
        runners.add(new Runner("Mike", cdl));
    }

    @Override
    public void run() {
       try {
           /* каждому бегуну говорим идти на старт */
           goOnStart();
           cdl.await();    //ждём, пока счётчик е будет равен 0 (все бегуны пришли
           goAll();
       } catch (InterruptedException e){
           e.printStackTrace();
       }
    }

    private void goAll() throws InterruptedException {
        sleep(1000);
        System.out.println("на старт");
        sleep(1000);
        System.out.println("внимание");
        sleep(1000);
        System.out.println("марш");

        for (Runner runner: runners){
            runner.go(); //будим всех
        }
    }

    private void goOnStart() {
        for (Runner runner: runners){
            runner.start(); //Идём в метод run в Runner
        }
    }
}
