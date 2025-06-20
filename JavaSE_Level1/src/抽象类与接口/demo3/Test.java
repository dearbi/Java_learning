package 抽象类与接口.demo3;

public class Test {
    public static void drawMap(IShape iShape){
        iShape.draw();
    }
    public static void main(String[] args) {
        drawMap(new Cycle());
        drawMap(new Rect());

        IShape[] iShapes={new Rect(),new Cycle()};
        IShape iShape=new Cycle();
    }
}
