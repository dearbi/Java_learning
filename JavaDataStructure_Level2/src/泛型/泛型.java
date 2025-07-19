package 泛型;

/*class MyArray<E extends Number> {

}*/

class Alg<T extends Comparable<T>> {
    public T findMax(T[] array) {
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }
}

class Stundet {

}

class Alg2 {
    public <T extends Comparable<T>> T findMax(T[] array) {
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }
}


class Alg3 {
    public static <T extends Comparable<T>> T findMax(T[] array) {
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }
}

public class 泛型 {
    public static void main(String[] args) {//静态方法不用通过类来调用
        Integer[] array = {1, 3, 21, 15, 8, 17, 6, 9};
        int ret=Alg3.findMax(array);
        System.out.println(ret);
    }
    public static void main2(String[] args) {
        Alg2 alg2 = new Alg2();
        Integer[] array = {1, 3, 21, 15, 8, 17, 6, 9};
        alg2.<Integer>findMax(array);
        alg2.findMax(array);
    }
    public static void main1(String[] args) {
//        MyArray<Integer> myArray = new MyArray<Integer>();

        Alg<Integer> alg1 = new Alg<Integer>();
        Integer[] array = {1, 3, 21, 15, 8, 17, 6, 9};
        int ret = alg1.findMax(array);
        System.out.println(ret);
        Alg<String> alg2 = new Alg<String>();
//        Alg<Stundet> alg2 = new Alg<Stundet>();
    }
}
