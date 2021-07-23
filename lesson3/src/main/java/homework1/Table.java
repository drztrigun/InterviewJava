package homework1;

public class Table extends Thread{
    private Table table;

    private boolean pinged = false;

    public synchronized String getPong(){
        while (pinged == false){
            try {
                wait();
            } catch (InterruptedException e){

            }
        }
        pinged = false;

        notifyAll();
        String text = "pong";

        return text;
    }

    public synchronized String getPing(){
        while (pinged == true){
            try {
                wait();
            } catch (InterruptedException e){

            }
        }
        pinged = true;

        notifyAll();
        String text = "ping";

        return text;
    }
}
