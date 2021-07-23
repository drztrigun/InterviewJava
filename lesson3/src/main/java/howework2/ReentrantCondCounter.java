package howework2;

import java.text.SimpleDateFormat;

public class ReentrantCondCounter {

    GeneralHeap generalHeap = null;
    SimpleDateFormat simpleDateFormat = null;

    ReentrantCondCounter(){
        generalHeap = new GeneralHeap();
        simpleDateFormat = new SimpleDateFormat("HH:mm:ss ");

        Thread Addition = new Thread(new Addition());
        Thread Subtraction = new Thread(new AdditionPlus());

        Addition.start();
        Subtraction.start();

        while (Addition.isAlive() || Subtraction.isAlive()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.exit(0);
    }

    public static void main(String[] args) {
        new ReentrantCondCounter();
    }
}
