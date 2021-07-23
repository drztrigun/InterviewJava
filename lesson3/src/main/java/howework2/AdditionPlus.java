package howework2;

public class AdditionPlus implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            GeneralHeap.plusPlus();
        }
    }
}
