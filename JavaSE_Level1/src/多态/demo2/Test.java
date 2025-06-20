package 多态.demo2;


class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


public class Test {
    public static void main(String[] args) {
        Person person = new Person("老张",1);
        System.out.println(person);
    }


    public static void drawShapes1() {
        Rect rect = new Rect();
        Cycle cycle = new Cycle();
        Flower flower = new Flower();

        String[] shapes = {"cycle", "rect", "cycle", "rect", "flower"};

        for (int i = 0; i < shapes.length; i++) {

            String shape = shapes[i];

            if (shape.equals("cycle")) {
                cycle.draw();
            } else if (shape.equals("rect")) {
                rect.draw();
            } else {
                flower.draw();
            }
        }
    }

    public static void drawShapes2() {
        Rect rect = new Rect();
        Cycle cycle = new Cycle();
        Flower flower = new Flower();

        Shape[] shapes = {rect, cycle, rect, cycle, flower};

        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    public static void main2(String[] args) {
//        drawShapes1();
        drawShapes2();
    }

    public static void drawMap(Shape shape) {
        shape.draw();
    }

    public static void main1(String[] args) {
        drawMap(new Rect());
        drawMap(new Cycle());
        drawMap(new Flower());
    }
}
