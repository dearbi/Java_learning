package com.wenbobi.facade;

public class HallLight implements Light{

    @Override
    public void on() {
        System.out.println("走廊灯开");
    }

    @Override
    public void off() {
        System.out.println("走廊灯关");
    }
}
