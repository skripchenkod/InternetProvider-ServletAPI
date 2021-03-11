package com.epam.rd.java.basic.practice1;

import java.io.PrintStream;

public class Main {

    public static void main(String[] args) {
        printHelloWorld(System.out);
    }

    static void printHelloWorld(PrintStream out){
        out.print("Hello, World");
    }
}
