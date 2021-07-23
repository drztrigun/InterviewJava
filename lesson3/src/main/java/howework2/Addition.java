package howework2;

public class Addition implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            GeneralHeap.plus();
            try {
                Thread.sleep(600);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
