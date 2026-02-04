package io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Demo11 {
    public static void main(String[] args) {
        try(Writer writer = new FileWriter("./1.txt",true)){
            writer.write("hello world");


        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
