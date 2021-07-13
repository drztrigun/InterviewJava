package geek.homework1;

public class Main {
    public static void main(String[] args) {
        Person person = Person.newBuilder()
                .firstName("Alex")
                .lastName("Lyubimov")
                .country("Russia")
                .phone("8-903-903-93-93")
                .age(30)
                .gender("male")
                .build();

    }
}
