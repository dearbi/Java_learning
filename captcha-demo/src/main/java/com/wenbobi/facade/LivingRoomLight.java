package com.wenbobi.facade;

public class LivingRoomLight implements Light{

    @Override
    public void on() {
        System.out.println("客厅灯开");
    }

    @Override
    public void off() {
        System.out.println("客厅灯关");
    }
}
