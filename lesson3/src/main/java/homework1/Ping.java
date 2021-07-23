package homework1;

public class Ping extends Thread{
    private Table table;
    private String pingPrint = "";

    public Ping(Table t){
        table = t;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            pingPrint = table.getPing();
            System.out.println(i + " " + pingPrint);
        }
    }
}
