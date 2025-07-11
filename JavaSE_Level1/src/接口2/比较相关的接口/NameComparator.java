package 接口2.比较相关的接口;

import java.util.Comparator;

public class NameComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
//        return o1.name>o2.name;
        return o1.name.compareTo(o2.name);

    }
}
