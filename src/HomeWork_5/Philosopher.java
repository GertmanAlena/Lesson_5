package HomeWork_5;

import Seminar.Runner;

import java.util.Random;

public class Philosopher extends Thread{

    private String name;
    private int leftFork;
    private int rightFork;
    private Fork forks[];
    private int id;
    private Thread thread;
    private Random random;


    public Philosopher(String name, Fork forks[], int id){
        this.name = name;
        this.id = id;
        leftFork = getLeftFork(id);
        rightFork = getRightFork(id);
        thread = new Thread(this);
        thread.start();
        this.forks = forks;
    }
    public String getNameR() {
        return name;
    }
    private int getRightFork(int id) {
        return (id + 1) % 5;
    }

    private int getLeftFork(int id) {
        return id;
    }
    public int getIdR() {
        return id;
    }
    @Override
    public void run() {
        try {
            reflecting();
            getForks();
            eat();
            dropForks();

        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private void dropForks() {
        System.out.println(getNameR() + " кладёт вилку");

        Fork forkOne = getForks(getLeftFork(getIdR()));
        Fork forkTwo = getForks(getRightFork(getIdR()));

        forkOne.drop();
        forkTwo.drop();
    }
    protected Fork getForks(int forkNumber) {
        return this.forks[forkNumber];
    }

    private void getForks() {
        System.out.println("нужно взять вилки");

        Fork forkOne = getFork(getLeftFork(getIdR()));
        Fork forkTwo = getFork(getRightFork(getIdR()));
        try{
            if(!forkOne.use() || !forkTwo.use()){
                thread.sleep((int) (Math.random() * 10000));
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
//        forkOne.use();
//        forkTwo.use();
    }
    protected Fork getFork(int forkNumber) {
        return this.forks[forkNumber];
    }

    public void eat(){
        try {
            System.out.println(this.getNameR() + " кушает))");
            thread.sleep((int) (Math.random() * 10000));
            System.out.println(this.getNameR() + " наелся, готов размышлять");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void reflecting() throws InterruptedException{
        System.out.println(name + ": начал размышлять");
        thread.sleep((int) (Math.random() * 20000));
        System.out.println(name + ": захотел кушать");
    }


}
