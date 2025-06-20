package 抽象类与接口.demo4;

public class KeyBoard implements USB {
    @Override
    public void openDevice() {
        System.out.println("打开键盘");
    }

    @Override
    public void closeDevice() {
        System.out.println("关闭键盘");
    }

    public void input(){
        System.out.println("输入");
    }
}
