package com.project.mockup2html.JUnitTests;

import java.io.PrintStream;

import org.junit.runner.RunWith;
//@RunWith(Arquillian.class)

public class Component {
    public void sendMessage(PrintStream to, String msg) {
        to.println(message(msg));
    }
 
    public String message(String msg) {
        return "Message, " + msg;
    }
}	