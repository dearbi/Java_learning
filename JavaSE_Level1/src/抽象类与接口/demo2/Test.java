package 抽象类与接口.demo2;

public class Test {

    public static void drawMap(Shape shape){
        shape.draw();
    }
    public static void main(String[] args) {
        /*Shape shape = new Shape(); 抽象类不能实例化*/
        drawMap(new Rect());
        drawMap(new Cycle());
    }
}
