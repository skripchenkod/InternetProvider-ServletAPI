package com.epam.rd.java.basic.practice1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void shouldTestMain() {
        String[] args = {"1", "2"};
        Main.main(args);
        assertEquals(args[0], "1");
    }
}
