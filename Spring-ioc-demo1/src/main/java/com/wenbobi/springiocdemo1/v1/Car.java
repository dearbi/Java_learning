package com.wenbobi.springiocdemo1.v1;

public class Car {

    public Car(int size) {
        Framework framework = new Framework(size);
        System.out.println("car init ...");
    }

    public void run() {
        System.out.println("car run ...");
    }
}
