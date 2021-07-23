package homework1;

public class Pong extends Thread{
    private Table table;
    private String pongPrint = "";

    public Pong(Table t){
        table = t;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            pongPrint = table.getPong();
            System.out.println(i + " " + pongPrint);
        }
    }
}
