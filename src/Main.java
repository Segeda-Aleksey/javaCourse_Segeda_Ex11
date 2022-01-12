import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Comparator<Student> studentComparator = new StudentNameCorpare().thenComparing(new StudentAgeCorpare());

        Set<Student> setStudent = new HashSet<>();
        setStudent.add(new Student("Aleksey", 20, 3,FavoritLesson.MATHEMATIKS));
        setStudent.add(new Student("Vasilii", 18, 1,FavoritLesson.JAVA));
        setStudent.add(new Student("Max", 19, 2,FavoritLesson.PROGRAMMING));
        setStudent.add(new Student("Petr", 22, 5,FavoritLesson.MATHEMATIKS));

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int i = 0;
            while (i != 5) {
                menu();

                i = Integer.parseInt(reader.readLine());
                if (i == 1){
                    addNewStudent(setStudent);
                }
                if (i == 2) {
                    Set<Student> sortedStudent = new TreeSet<>(studentComparator);
                    sortedStudent.addAll(setStudent);
                    System.out.println(sortedStudent);
                }
                if (i == 3) {
                    Comparator<Student> studentComparatorRevers = studentComparator.reversed();
                    Set<Student> reversStudent = new TreeSet<>(studentComparatorRevers);
                    reversStudent.addAll(setStudent);
                    System.out.println(reversStudent);
                }
                if (i == 4) {
                    if (setStudent.size() == 0) {
                        System.out.println("Нет элементов");
                    }
                    else {
                        System.out.println("Введите индекс удаляемого студента начиная с 1 до "
                                + setStudent.size());
                        int index = Integer.parseInt(reader.readLine());
                        if (index > setStudent.size()) System.out.println("Нет такого элемента");
                        for (Student element : setStudent) {
                            --index;
                            if (index == 0) {
                                setStudent.remove(element);
                                break;
                            }

                        }
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void menu()  {
        System.out.println("1 Ввести ученика\n2 Вывести всех учеников по возрастанию\n3 Вывести " +
                "всех учеников по убаванию\n4 Удалить ученика по индексу\n5 Выйти из программы");
    }

    private static void addNewStudent(Set<Student> setStudent) {
        System.out.println("Выберете из списка любимый предмет:\n" +
                "1 - PROGRAMMING,\n" +
                "2 - JAVA,\n" +
                "3 - MATHEMATIKS");

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FavoritLesson favorit = FavoritLesson.JAVA;
                    String choice = reader.readLine();
            switch (choice) {
                case "1":
                    favorit = FavoritLesson.PROGRAMMING;
                    break;
                case "2":
                    favorit = FavoritLesson.JAVA;
                    break;
                case "3":
                    favorit = FavoritLesson.MATHEMATIKS;
                    break;
                default:
                    System.out.println("Вы ввели некорректное число");
                    return;
            }

            System.out.println("Введите через пробел имя возраст и класс");
            String str = reader.readLine();
            String[] strings = str.split(" ");
            if (strings.length != 3) {
                System.out.println("Вы ввели неверные данные");
                return;
            }
            for (Student element:setStudent  ) {
                if (element.name.equals(strings[0]) && element.age == Integer.parseInt(strings[1])) {
                    System.out.println("Ученик уже есть в базе");
                    return;
                }
            }
            setStudent.add(new Student(strings[0],Integer.parseInt(strings[1]), Integer.parseInt(strings[2]),
                    favorit));

        } catch (Exception e) {
            System.out.println("Некорректные данные " + e);
        }
    }


}
class StudentNameCorpare implements Comparator<Student> {
    public int compare(Student student1, Student student2) {
        return student1.getName().compareTo(student2.getName());
    }
}

class StudentAgeCorpare implements Comparator<Student> {
    public int compare(Student student1, Student student2) {
        return student1.getAge() - student2.getAge();
    }
}