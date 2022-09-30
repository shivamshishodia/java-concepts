import java.util.*;
import java.util.stream.*;

class Student {

    String subject;
    String name;
    String surname;
    String city;
    int age;

    Student() {
    }

    Student(String subject, String name, String surname, String city, int age) {
        this.subject = subject;
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.age = age;
    }

}

public class GroupingBy {

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
            new Student("Math", "John", "Smith", "Miami", 19),
            new Student("Programming", "Mike", "Miles", "New York", 21),
            new Student("Math", "Michael", "Peterson", "New York", 20),
            new Student("Math", "James", "Robertson", "Miami", 20),
            new Student("Programming", "Kyle", "Miller", "Miami", 20)
        );

        Map<String, List<Student>> studentsBySubject = students.stream()
                .collect(Collectors.groupingBy(item -> item.subject));

        // studentsBySubject : {Programming=[Student@4ca8195f, Student@65e579dc], Math=[Student@61baa894, Student@b065c63, Student@768debd]}
        System.out.println("studentsBySubject : " + studentsBySubject);

        Map<String, List<String>> studentsByCity = students.stream()
                .collect(Collectors.groupingBy(item -> item.city,
                    Collectors.mapping(item -> item.name, Collectors.toList())));

        // studentsByCity : {New York=[Mike, Michael], Miami=[John, James, Kyle]}
        System.out.println("studentsByCity : " + studentsByCity);

        Map<Integer, Long> countByAge = students.stream()
                .collect(Collectors.groupingBy(item -> item.age, Collectors.counting()));

        // countByAge : {19=1, 20=3, 21=1}
        System.out.println("countByAge : " + countByAge);

        Map<String, List<String>> namesByCity = students.stream()
                .collect(Collectors.groupingBy(
                    item -> item.city,
                    TreeMap::new, // Specified TreeMap data structure
                    Collectors.mapping(item -> item.name, Collectors.toList())));

        // namesByCity : {Miami=[John, James, Kyle], New York=[Mike, Michael]}
        System.out.println("namesByCity : " + namesByCity);        

    }

}