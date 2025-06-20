package 抽象类与接口.demo4;

public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.powerOn();
        Mouse mouse=new Mouse();
        computer.useDevice(mouse);
        computer.powerOff();

    }
}
