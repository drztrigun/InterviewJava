package geek;

public class Main {
    public static void main(String[] args) {
        AbstractRepository<Student, Long> abstractRepository = new AbstractRepository<>(Student.class);
        abstractRepository.openCurrentSession();

        Student student = abstractRepository.findById(1l);
        System.out.println(student);
        abstractRepository.closeCurrentSession();


    }
}
