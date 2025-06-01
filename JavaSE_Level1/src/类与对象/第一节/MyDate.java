package 类与对象.第一节;

public class MyDate {
    public int year;
    public int month;
    public int day;

//    public void setDate(int y, int m, int d) {
//        year = y;
//        month = m;
//        day = d;
//    }
    public  MyDate(){
        this(1900,1,1);//必须放到第一行
        System.out.println("不带参数的构造方法");
    }


    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

//    public void setDate(/*MyDate this,*/int year, int month, int day) {
//        this.year = year;
//        this.month = month;
//        this.day = day;
//    }


    public void printDate() {
        System.out.println("year: "+year+" month: "+month+" day: "+day);
        this.test();
    }


    public void test() {
        System.out.println("test()");
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
