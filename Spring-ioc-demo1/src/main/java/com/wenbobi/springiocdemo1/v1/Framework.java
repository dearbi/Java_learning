package com.wenbobi.springiocdemo1.v1;

public class Framework {
    private Bottom bottom;

    public Framework(int size) {
        bottom = new Bottom(size);
        System.out.println("framework init ...");
    }
}
