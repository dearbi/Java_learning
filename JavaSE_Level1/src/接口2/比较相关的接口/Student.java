package 接口2.比较相关的接口;

public class Student implements Comparable<Student> {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student o) {
/*        if(this.age>o.age){
            return 1;
        }else if(this.age == o.age){
            return 0;
        }else{
            return -1;
        }*/
        return this.age - o.age;
    }
}
