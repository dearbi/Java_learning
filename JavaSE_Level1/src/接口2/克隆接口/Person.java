package 接口2.克隆接口;

public class Person implements Cloneable {
    public int id;
    public Money m=new Money();

    public Person(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //return super.clone(); 浅拷贝

        //深拷贝
        Person tmp=(Person)super.clone();
        tmp.m=(Money)this.m.clone();
        return tmp;
    }
}
