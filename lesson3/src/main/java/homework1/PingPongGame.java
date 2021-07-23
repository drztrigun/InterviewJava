package homework1;

public class PingPongGame {
    public static void main(String[] args) {

        Table table = new Table();

        Pong pong = new Pong(table);

        Ping ping = new Ping(table);

        System.out.println("thread main start");

        ping.start();

        pong.start();

    }
}
