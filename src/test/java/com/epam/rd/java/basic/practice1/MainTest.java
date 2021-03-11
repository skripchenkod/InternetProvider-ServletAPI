package com.epam.rd.java.basic.practice1;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MainTest {

    @Test
    public void shouldTestMain() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        Main.printHelloWorld(printStream);
        String actualString = byteArrayOutputStream.toString();

        Assert.assertEquals("Hello, World", actualString );
    }
}
