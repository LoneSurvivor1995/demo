package com.example.demo.command;

public class CommandImpl2 implements ICommand{

    public  Receiver2 receiver2 ;

    public CommandImpl2(Receiver2 receiver2){
        this.receiver2 = receiver2;
    }
    @Override
    public void execute() {
        receiver2.doA();
    }
}
