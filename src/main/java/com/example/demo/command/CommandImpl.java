package com.example.demo.command;

public class CommandImpl implements ICommand {

    public Receiver1 receiver1;

    public CommandImpl(Receiver1 receiver1){
        this.receiver1 = receiver1;
    }

    @Override
    public void execute() {
        receiver1.doA();
    }
}
