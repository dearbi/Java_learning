package 泛型;

class Food {
    @Override
    public String toString() {
        return "Food";
    }
}

class Fruit extends Food {
    @Override
    public String toString() {
        return "Fruit";
    }
}

class Apple extends Fruit {
    @Override
    public String toString() {
        return "Apple";
    }
}

class Banana extends Fruit {
    @Override
    public String toString() {
        return "Banana";
    }
}

class Plate<T> { // 设置泛型
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

public class 通配符2 {
    public static void main(String[] args) {
        Plate<Food> plate = new Plate<Food>();
        plate.setData(new Food());

        System.out.println(plate.getData());
        fun2(plate);


/*        Fruit food = new Fruit();
        Fruit fruit=(Fruit) food;*/
    }

    public static void fun2(Plate<? super Fruit> pa) {
        pa.setData(new Banana());

        Object o= pa.getData();
        System.out.println(o);
    }

    public static void main1(String[] args) {
        Plate<Apple> plate1 = new Plate<Apple>();
        plate1.setData(new Apple());
        Plate<Banana> plate2 = new Plate<Banana>();
        plate2.setData(new Banana());

        fun1(plate1);
        fun1(plate2);
    }

    public static void fun1(Plate<? extends Fruit> temp) {
//        temp.setData(new Banana()); //error
//        temp.setData(new Apple()); //error
        System.out.println(temp.getData());
    }

}
