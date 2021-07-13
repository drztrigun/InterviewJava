package geek.homework2;

class Lorry extends Car implements Stopable, Moveable {

    @Override
    void open() {

    }

    public void move(){
        System.out.println("Car is moving");
    }

    public void stop(){
        System.out.println("Car is stop");
    }

}
