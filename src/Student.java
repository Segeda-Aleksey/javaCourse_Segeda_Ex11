import java.util.Objects;

public class Student {

    String name;
    int age;
    int classStudent;
    FavoritLesson favoritLesson;

    public Student(String name, int age, int classStudent, FavoritLesson favoritLesson) {
        this.name = name;
        this.age = age;
        this.classStudent = classStudent;
        this.favoritLesson = favoritLesson;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getClassStudent() {
        return classStudent;
    }

    public FavoritLesson getFavoritLesson() {
        return favoritLesson;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", classStudent=" + classStudent +
                ", favoritLesson=" + favoritLesson +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return getAge() == student.getAge() && getClassStudent() == student.getClassStudent() && getName().equals(student.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getClassStudent(), getFavoritLesson());
    }
}
