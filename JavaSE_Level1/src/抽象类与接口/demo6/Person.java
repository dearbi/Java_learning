package 抽象类与接口.demo6;

import java.util.Objects;

public class Person {
    public String id;//学号、身份证号

    public Person(String id){
        this.id = id;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
