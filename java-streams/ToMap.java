import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class StudentDetail {

    String name;
    String surname;
    String city;
    double avgGrade;
    int age;

    StudentDetail() {
    }

    StudentDetail(String name, String surname, String city, double avgGrade, int age) {
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.avgGrade = avgGrade;
        this.age = age;
    }

}

public class ToMap {

    public static void main(String[] args) {

        List<StudentDetail> students = Arrays.asList(
            new StudentDetail("John", "Smith", "Miami", 7.38, 19),
            new StudentDetail("Mike", "Miles", "New York", 8.4, 21),
            new StudentDetail("Michael", "Peterson", "New York", 7.5, 20),
            new StudentDetail("James", "Robertson", "Miami", 9.1, 20),
            new StudentDetail("Kyle", "Miller", "Miami", 9.83, 20)
        );

        Map<String, Double> nameToAvgGrade = students.stream().collect(Collectors.toMap(item -> item.name, item -> item.avgGrade));

        // nameToAvgGrade : {Mike=8.4, James=9.1, Kyle=9.83, Michael=7.5, John=7.38}
        System.out.println("nameToAvgGrade : " + nameToAvgGrade);

        Map<String, StudentDetail> nameToStudentObject = students.stream().collect(Collectors.toMap(item -> item.name, Function.identity()));

        // nameToStudentObject : {Mike=StudentDetail@27082746, James=StudentDetail@66133adc, Kyle=StudentDetail@7bfcd12c, Michael=StudentDetail@42f30e0a, John=StudentDetail@24273305}
        System.out.println("nameToStudentObject : " + nameToStudentObject);

        Map<String, Double> nameToAvgGradeWithDuplicateCheck = students.stream()
            .collect(Collectors.toMap(item -> item.name, item -> item.avgGrade,
                (a, b) ->
                { throw new IllegalStateException("Duplicate key");})
            );

        // nameToAvgGradeWithDuplicateCheck : {Mike=8.4, Kyle=9.83, James=9.1, Michael=7.5, John=7.38}.
        System.out.println("nameToAvgGradeWithDuplicateCheck : " + nameToAvgGradeWithDuplicateCheck);
        
    }
    
}
