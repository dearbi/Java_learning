package 抽象类与接口.demo4;

public class Computer {
    public void powerOn(){
        System.out.println("开机");
    }
    public void powerOff(){
        System.out.println("关机");
    }

    public void useDevice(USB usb){
        usb.openDevice();
        if(usb instanceof KeyBoard){
            KeyBoard keyBoard=(KeyBoard)usb;
            keyBoard.input();
        }else if(usb instanceof Mouse){
            Mouse mouse=(Mouse)usb;
            mouse.click();
        }
        usb.closeDevice();
    }
}
