package com.example.demo.command;

public class Invoker {
    public static void main(String[] args) {
        Receiver1 receiver1 = new Receiver1();
        Receiver2 receiver2 = new Receiver2();
        ICommand command = new CommandImpl(receiver1);
        ICommand command1 = new CommandImpl2(receiver2);
        command.execute();
        command1.execute();
    }
}
