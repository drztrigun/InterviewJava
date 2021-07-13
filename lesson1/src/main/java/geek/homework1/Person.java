package geek.homework1;

public class Person {

    public Person(String firstName, String lastName, String middleName, String country, String address, String phone, int age, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.country = country;
        this.address = address;
        this.phone = phone;
        this.age = age;
        this.gender = gender;
    }

    private String firstName;

    private String lastName;

    private String middleName;

    private String country;

    private String address;

    private String phone;

    private int age;

    private String gender;

    public static Builder newBuilder (){
        return new Builder();
    }

    public static class Builder {

        private String firstName;

        private String lastName;

        private String middleName;

        private String country;

        private String address;

        private String phone;

        private int age = 18;

        private String gender;

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder middleName(String middleName){
            this.middleName = middleName;
            return this;
        }

        public Builder country(String country){
            this.country = country;
            return this;
        }

        public Builder address(String address){
            this.address = address;
            return this;
        }

        public Builder phone(String phone){
            this.phone = phone;
            return this;
        }

        public Builder age(int age){
            this.age = age;
            return this;
        }

        public Builder gender(String gender){
            this.gender = gender;
            return this;
        }

        public Person build(){
            return new Person(firstName, lastName, middleName, country, address, phone, age, gender);
        }

    }
}
