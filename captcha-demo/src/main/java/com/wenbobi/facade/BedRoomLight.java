package com.wenbobi.facade;

public class BedRoomLight implements Light{

    @Override
    public void on() {
        System.out.println("卧室灯开");
    }

    @Override
    public void off() {
        System.out.println("卧室灯关");
    }
}
