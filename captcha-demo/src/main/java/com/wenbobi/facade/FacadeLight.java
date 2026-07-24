package com.wenbobi.facade;

public class FacadeLight {
    HallLight hallLight=new HallLight();
    LivingRoomLight livingRoomLight = new LivingRoomLight();
    BedRoomLight bedRoomLight=new BedRoomLight();
    public void on(){
        hallLight.on();
        livingRoomLight.on();
        bedRoomLight.on();
    }

    public void off(){
        hallLight.off();
        livingRoomLight.off();
        bedRoomLight.off();
    }
}
